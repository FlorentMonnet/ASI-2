const { Config } = require('../config');
const socketServerUtil = require('../socketServer');

const socketServer = socketServerUtil.getServer();

let userOnWaitingList = [];

const connection = (socket) => {
    const addOnWaitingList = (user) => {
        console.log(user);
        if (userOnWaitingList.length === 0) {
            console.log('User is added to waiting list');
            userOnWaitingList.push(user);
        } else {
            console.log(userOnWaitingList.length);
            console.log(userOnWaitingList);
            let opponent = userOnWaitingList.shift();
            console.log('sdfs' + opponent);
            console.log(userOnWaitingList);
            socket.emit(Config.SOCKET_EVENT.OPPONENT_FOUND, opponent);
        }
    };

    socket.on(Config.SOCKET_EVENT.ADD_WAITING_LIST, addOnWaitingList);
};

socketServer.on(Config.SOCKET_EVENT.CONNECT, connection);
