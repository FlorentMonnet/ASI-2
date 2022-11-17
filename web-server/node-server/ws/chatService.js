const {Config} = require('../config');
const io = require('../index');
// import io from '../index'

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

io.on(Config.SOCKET_EVENT.CONNECT, connection);

// io.on("connection", (socket) => {
//     console.log(socket.id); // ojIckSD2jqNzOqIrAGzL
// });

// io.on('connection', (socket) => {
//     socket.on('chat message', msg => {
//         console.log("emitting message: " + msg);
//         io.emit('chat message', msg);
//     });
// });
