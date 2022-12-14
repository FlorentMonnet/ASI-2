export const selectorCardsToSell = (state) => state.cardsToSell;

export const selectorCardsToBuy = (state) => state.cards;

export const selectorUserCards = (state) => state.cardsToSell;

export const selectorUserCardsToPlay = (state) => state.cardToPlay;

export const selectorAdverseUserCards = (state) => state.opponentCardToPlay;

export const selectorSelectedCard = (state) => state.cardSelected;

export const selectorSelectedCardInGame = (state) => state.cardSelectedInGame;

export const selectorSelectedCardOpponentInGame = (state) =>
    state.cardOpponentSelectedInGame;
