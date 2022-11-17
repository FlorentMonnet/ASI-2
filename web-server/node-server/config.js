const Config = {
    API_PATH: 'https://asi2-backend-market.herokuapp.com/',
    SOCKET_PATH: 'http://localhost:3001',
    SOCKET_EVENT: {
        CONNECT: 'connect',
        ADD_WAITING_LIST: 'addOnWaitingList',
        OPPONENT_FOUND: 'opponentFound',
        CHAT_MESSAGE: 'chatMessage',
    },
};

module.exports = {
    Config,
};