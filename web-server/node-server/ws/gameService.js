const { Config } = require('../config');
const socketServerUtil = require('../socketServer');
const utils = require('../utils');

const socketServer = socketServerUtil.getServer();

let userOnWaitingList = [];
let roomsCreated = [];

const connection = (socket) => {
    const addOnWaitingList = (user) => {
        console.log(user);
        if (userOnWaitingList.length === 0) {
            console.log('User is added to waiting list');
            user = JSON.parse(user);
            userOnWaitingList.push(user);

            //Création de la room
            let roomName = utils.getRoomName();
            roomsCreated[user.id] = roomName;
            socket.join(roomName);
            console.log('Creating room ' + roomName);
        } else {
            console.log('Opponent mode : ');
            let opponent = userOnWaitingList.shift();
            // Join opponent room
            let opponentRoom = roomsCreated[opponent.id];
            console.log('Joined room ' + opponentRoom);
            socket.join(opponentRoom);
            socket
                .to(opponentRoom)
                .emit(Config.SOCKET_EVENT.OPPONENT_FOUND, opponent);
            socket.emit(Config.SOCKET_EVENT.ROOM_JOINED, opponentRoom);
        }
    };

    socket.on(Config.SOCKET_EVENT.ADD_WAITING_LIST, addOnWaitingList);
};

socketServer.on(Config.SOCKET_EVENT.CONNECT, connection);
