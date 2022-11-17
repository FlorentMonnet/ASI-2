import Config from '../config'

const io = require("socket.io-client");

export const socket = io(Config.SOCKET_PATH, {
    cors: {
        origin: Config.SOCKET_PATH,
    }
});

