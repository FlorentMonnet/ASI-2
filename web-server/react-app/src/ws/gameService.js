import Config from '../config';
import { socket } from './index';

socket.on(Config.SOCKET_EVENT.OPPONENT_FOUND, (userIdFound) => {
    alert('Opponent found ' + userIdFound);
});

const gameService = {
    addOnWaitingList(user) {
        socket.emit(Config.SOCKET_EVENT.ADD_WAITING_LIST, user);
    },
};
export default gameService;
