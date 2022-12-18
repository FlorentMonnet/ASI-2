const { Config } = require('../config');
const socketServerUtil = require('../model/socketServer');
const utils = require('../model/utils');

const socketServer = socketServerUtil.getServer();


const connection = (socket) => {
    const receivedMessage = (message) => {

        var current_date = new Date();
        var hh = String(current_date.getHours()).padStart(2, '0');
        var mm = String(current_date.getMinutes() + 1).padStart(2, '0');
        // var ss = String(current_date.getSeconds() + 1).padStart(2, '0');
        current_date = hh + ':' + mm;
        message = current_date + " - " + message;
        //     setMessages([...messages, [msg, current_date, socket.id]])

        // let chatRoomName = utils.getChatRoomName();
        // console.log('Creating room ' + chatRoomName);

        // socket.join("all-chat");
        console.log('emitting message: ' + message + " on socket: " + socket.id);
        socketServer.sockets.emit(Config.SOCKET_EVENT.RECEIVED_CHAT_MESSAGE, message);

    };

    socket.on(Config.SOCKET_EVENT.CHAT_MESSAGE, receivedMessage);
};

socketServer.on(Config.SOCKET_EVENT.CONNECT, connection);