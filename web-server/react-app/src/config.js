const API_PATH = 'http://localhost:80/api/';
const myConstClass = {
    IMAGE_PATH: '/public/ressources',
    API_USER_PATH: API_PATH + 'user-microservice/',
    API_CARD_PATH: API_PATH + 'card-microservice/',
    API_TRANSACTION_PATH: API_PATH + 'transaction-microservice/',
    SOCKET_PATH: 'http://localhost:80/socket',
    HEADER_CONFIG: {
        play: {
            iconHeader: 'gamepad',
            title: 'Play',
            subTitle: 'Play with yours card',
        },
        sell: {
            iconHeader: 'money',
            title: 'SELL',
            subTitle: 'Sell your card to get money',
        },
        buy: {
            iconHeader: 'shopping cart',
            title: 'BUY',
            subTitle: 'Buy card',
        },
    },
    MODE: {
        BUY: 'buy',
        SELL: 'sell',
        GAME: 'Game',
        SELECT_CARD: 'selectCardGame',
        GAME_ZONE: 'GameZone',
        GAME_ADVERSE: 'GameAdverse',
        HEADER: 'Header',
    },
    SOCKET_EVENT: {
        CONNECT: 'connect',
        ADD_WAITING_LIST: 'addOnWaitingList',
        OPPONENT_FOUND: 'opponentFound',
        CHAT_MESSAGE: 'chatMessage',
        ROOM_JOINED: 'roomJoined',
        GAME_ATTACK: 'gameAttack',
        UPDATE_GAME: 'updateGame',
        END_GAME: 'endGame',
    },
};

export default myConstClass;
