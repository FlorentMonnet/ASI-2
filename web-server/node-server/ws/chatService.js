const {Config} = require('../config');
const socketServerUtil = require('../socketServer');

const socketServer = socketServerUtil.getServer();

const connection = (socket) => {
    // const functionAAppeler = ({ cards }) => {
    //     blabla
    // }
    const receivedMessage = () => {
        console.log('emitting message: ' + msg);
        io.emit('chat message', msg);
    };

    // socket.on(ENUM.nomchannel, functionAAppeler)
    socket.on(Config.SOCKET_EVENT.CHAT_MESSAGE, receivedMessage)
}

socketServer.on(Config.SOCKET_EVENT.CONNECT, connection);

// io.on("connection", (socket) => {
//     console.log(socket.id); // ojIckSD2jqNzOqIrAGzL
// });

// io.on('connection', (socket) => {
//     socket.on('chat message', msg => {
//         console.log("emitting message: " + msg);
//         io.emit('chat message', msg);
//     });
// });
