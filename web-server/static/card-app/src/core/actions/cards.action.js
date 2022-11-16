export const CardsActions = {
    INIT: '@@card/INIT',
    SELECT_CARD: '@@card/SELECT_CARD',
    INIT_CARD_TO_SELL: '@@card/INIT_CARD_TO_SELL',
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

export const cardsToSellInit = (cardsToSell) => {
    return {
        type: CardsActions.INIT_CARD_TO_SELL,
        payload: {
            cardsToSell,
        },
    };
};
