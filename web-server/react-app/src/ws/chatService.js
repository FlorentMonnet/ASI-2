import Config from '../config';
import { socket } from './index';
import { addChatMessage } from '../core/actions/chat.action';

class ChatService {
    static _instance;

    constructor(
        socket = null,
        dispatch = null
    ) {
        if (!ChatService._instance) {
            ChatService._instance = this;
        }
        if (
            socket !== null &&
            dispatch !== null
        ) {
            this.socket = socket;
            this.dispatch = dispatch;
            socket.on(Config.SOCKET_EVENT.RECEIVED_CHAT_MESSAGE, (message) => {
                console.log("received a message!");
                console.log("id:" + socket.id);
                dispatch(
                    addChatMessage(message)
                );
            });

            this._instance = this;
        } else {
            throw new Error(
                'Impossible de creer un Chat Service sans paramètres'
            );
        }
        return ChatService._instance;
    }

    static getInstance() {
        if (!ChatService._instance) {
            throw new Error('ChatService jamais instancié');
        } else {
            return this._instance;
        }
    }

    emitMessage(message) {
        console.log("emitting message: \"" + message + "\" from socket: " + socket.id);
        this.socket.emit(Config.SOCKET_EVENT.CHAT_MESSAGE, message);
    }


}
export default ChatService;