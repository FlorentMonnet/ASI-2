import Config from '../../config';
const io = require('socket.io-client');

const socket = io(Config.SOCKET_PATH, {
    cors: {
        origin: Config.SOCKET_PATH,
        methods: ['GET', 'POST'],
    },
});

socket.emit('myEvent1', 'Hello World');
socket.on('myEvent2', function (data) {
    alert(data);
});
