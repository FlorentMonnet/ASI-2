// import Config from '../config';
const Config = require('../config');

var userOnWaitingList = [];

const connection = (socket) => {
    const addOnWaitingList = ({ User }) => {
        if (userOnWaitingList.length > 0) {
            console.log(userOnWaitingList.shift());
            console.log(userOnWaitingList);
        } else {
            userOnWaitingList.push(User);
        }
    };

    socket.on(Config.SOCKET_EVENT.ADD_WAITING_LIST, addOnWaitingList);
};
