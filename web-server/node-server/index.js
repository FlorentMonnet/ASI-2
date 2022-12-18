const app = require('express')();
const http = require('http').createServer(app);
const socketServerUtil = require('./model/socketServer');

socketServerUtil.init(http);

const port = process.env.PORT || 3001;

const gameService = require('./ws/gameService');
const chatService = require('./ws/chatService');
const userService = require('./ws/userService');

http.listen(port, () => {
    console.log(`Socket.IO server running at http://localhost:${port}/`);
});
