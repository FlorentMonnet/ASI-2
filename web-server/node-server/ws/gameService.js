const { Config } = require('../config');
const socketServerUtil = require('../socketServer');

const socketServer = socketServerUtil.getServer();

let userOnWaitingList = [];

const connection = (socket) => {
    const addOnWaitingList = ({ User }) => {
        if (userOnWaitingList.length >= 1) {
            console.log(userOnWaitingList.length);
            console.log(userOnWaitingList);
            let opponent = userOnWaitingList.shift();
            console.log('sdfs' + opponent);
            console.log(userOnWaitingList);
            socket.emit(Config.SOCKET_EVENT.OPPONENT_FOUND, opponent);
        } else {
            console.log('User is added');
            userOnWaitingList.push(User);
        }
    };

    socket.on(Config.SOCKET_EVENT.ADD_WAITING_LIST, addOnWaitingList);
};

socketServer.on(Config.SOCKET_EVENT.CONNECT, connection);
