const app = require('express')();
const http = require('http').createServer(app);

// const io = require('socket.io')(http);

const io = require("socket.io")(http, {
    cors: {
        origin: "*",
        methods: ["GET", "POST"],
    }
});

const port = process.env.PORT || 3001;

const gameService = require('./ws/gameService');
const chatService = require('./ws/chatService');
const userService = require('./ws/userService');

io.on("connection", (socket) => {
    console.log(socket.id); // ojIckSD2jqNzOqIrAGzL
});

io.on('connection', (socket) => {
    socket.on('chat message', msg => {
        console.log("emitting message: " + msg);
        io.emit('chat message', msg);
    });
});

http.listen(port, () => {
    console.log(`Socket.IO server running at http://localhost:${port}/`);
});