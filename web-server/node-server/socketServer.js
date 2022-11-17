var socketServer;

module.exports = {
    init: (httpServer) => {
        socketServer = require('socket.io')(httpServer, {
            cors: {
                origin: '*',
                methods: ['GET', 'POST'],
            },
        });
    },
    getServer: () => {
        return socketServer;
    },
};
