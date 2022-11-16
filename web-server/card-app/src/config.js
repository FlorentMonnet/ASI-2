const myConstClass = {
    IMAGE_PATH: '/public/ressources',
    API_PATH: 'https://asi2-backend-market.herokuapp.com/',
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
};

export default myConstClass;
