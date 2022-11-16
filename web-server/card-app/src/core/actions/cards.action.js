export const CardsActions = {
    INIT: '@@card/INIT',
    SELECT_CARD: '@@card/SELECT_CARD',
    INIT_CARD_TO_SELL: '@@card/INIT_CARD_TO_SELL',
    ADD_CARD_FOR_GAME: '@@card/ADD_CARD_FOR_GAME',
    RESET_CARD_FOR_GAME: '@@card/RESET_CARD_FOR_GAME',
    SELECT_CARD_IN_GAME: '@@card/SELECT_CARD_IN_GAME',
};

export const cardInit = (cards) => {
    return {
        type: CardsActions.INIT,
        payload: {
            cards,
        },
    };
};

export const selectCard = (cardSelected) => {
    return {
        type: CardsActions.SELECT_CARD,
        payload: {
            cardSelected,
        },
    };
};

export const userCardsToSell = (cardsToSell) => {
    return {
        type: CardsActions.INIT_CARD_TO_SELL,
        payload: {
            cardsToSell,
        },
    };
};

export const addCardForGame = (card) => {
    return {
        type: CardsActions.ADD_CARD_FOR_GAME,
        payload: {
            card,
        },
    };
};

export const resetCardForGame = () => {
    return {
        type: CardsActions.RESET_CARD_FOR_GAME,
    };
};

export const selectCardInGame = (card) => {
    return {
        type: CardsActions.SELECT_CARD_IN_GAME,
        payload: {
            card,
        },
    };
};
