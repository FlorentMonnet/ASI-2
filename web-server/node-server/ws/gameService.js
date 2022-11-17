// import Config from '../config';
const Config = require('../config');
const io = require('../index');

var userOnWaitingList = [];

const connection = (socket) => {
    const addOnWaitingList = ({ User }) => {
        if (userOnWaitingList.length > 0) {
            let opponent = userOnWaitingList.shift();
            console.log(opponent);
            console.log(userOnWaitingList);
            socket.emit(Config.SOCKET_EVENT.OPPONENT_FOUND, opponent);
        } else {
            userOnWaitingList.push(User);
        }
    };

    socket.on(Config.SOCKET_EVENT.ADD_WAITING_LIST, addOnWaitingList);
};
