import { CardsActions } from '../actions/cards.action';
import { UserActions } from '../actions/user.action';

const initStateValue = {
    cards: [],
    cardsToSell: [],
    cardSelected: {},
    userConnected: null,
};

export const rootReducer = (state = initStateValue, action) => {
    if (action.type === CardsActions.INIT) {
        // console.log('Store : { payload : ' + action.payload.cards + ', type : ' + action.type + '}');
        return {
            ...state,
            cards: action.payload.cards,
        };
    }
    if (action.type === CardsActions.SELECT_CARD) {
        return {
            ...state,
            cardSelected: action.payload.cardSelected,
        };
    }
    if (action.type === UserActions.CONNECT) {
        delete action.payload.user.pwd;
        return {
            ...state,
            userConnected: action.payload.user,
        };
    }

    if (action.type === CardsActions.INIT_CARD_TO_SELL) {
        console.log(action.payload.cardsToSell);
        return {
            ...state,
            cardsToSell: action.payload.cardsToSell,
        };
    }

    return state;
};
