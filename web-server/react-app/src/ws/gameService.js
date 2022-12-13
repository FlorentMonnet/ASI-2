import { useNavigate } from 'react-router-dom';
import Config from '../config';

class GameService {
    constructor(socket = null, navigate = null) {
        if (!GameService._instance) {
            GameService._instance = this;
        }
        if (socket !== null && navigate !== null) {
            this.socket = socket;
            this.navigate = navigate;

            //When a another user joined the room
            socket.on(Config.SOCKET_EVENT.OPPONENT_FOUND, (userIdFound) => {
                console.log('Opponent found ' + userIdFound);
                this.navigate('/play');
            });

            // For navigate to play
            socket.on(Config.SOCKET_EVENT.ROOM_JOINED, () => {
                this.navigate('/play');
            });

            this._instance = this;
        } else {
            throw new Error(
                'Impossible de creer un Game Service sans paramétres'
            );
        }
        return GameService._instance;
    }

    static getInstance() {
        return this._instance;
    }

    addOnWaitingList(user) {
        this.socket.emit(Config.SOCKET_EVENT.ADD_WAITING_LIST, user);
    }
}
export default GameService;
