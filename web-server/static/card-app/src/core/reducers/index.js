import { CardsActions } from '../actions/cards.action';
import { UserActions } from '../actions/user.action';

const initStateValue = {
    cards: [],
    cardsToSell: [],
    cardSelected: {},
    userConnected: null,
    cardToPlay: [],
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
        return {
            ...state,
            cardsToSell: action.payload.cardsToSell,
        };
    }

    if (action.type === CardsActions.ADD_CARD_FOR_GAME) {
        let temp = state.cardToPlay;
        temp.push(action.payload.card);
        return {
            ...state,
            cardToPlay: temp,
        };
    }

    if (action.type === CardsActions.RESET_CARD_FOR_GAME) {
        return {
            ...state,
            cardToPlay: [],
        };
    }

    return state;
};
