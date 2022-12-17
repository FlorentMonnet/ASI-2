const Config = {
    API_PATH: 'https://asi2-backend-market.herokuapp.com/',
    SOCKET_PATH: 'http://localhost:80/socket',
    SOCKET_EVENT: {
        CONNECT: 'connection',
        ADD_WAITING_LIST: 'addOnWaitingList',
        OPPONENT_FOUND: 'opponentFound',
        CHAT_MESSAGE: 'chatMessage',
        GAME_ATTACK: 'gameAttack',
        ROOM_JOINED: 'roomJoined',
        UPDATE_GAME: 'updateGame',
        END_GAME: 'endGame',
    },
};

module.exports = {
    Config,
};
