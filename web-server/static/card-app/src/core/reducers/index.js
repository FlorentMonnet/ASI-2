import { CardsActions } from '../actions/cards.action';
import { UserActions } from '../actions/user.action';

const initStateValue = {
    cards: [],
    cardsToSell: [],
    cardSelected: {},
    users: [],
    userConnected: null,
    cardToPlay: [],
    userSelected: null,
    cardSelectedInGame: null,
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

    if (action.type === CardsActions.INIT_CARD_TO_SELL) {
        // console.log(action.payload.cardsToSell);
        return {
            ...state,
            cardsToSell: action.payload.cardsToSell,
        };
    }

    if (action.type === UserActions.CONNECT) {
        delete action.payload.user.pwd;
        return {
            ...state,
            userConnected: action.payload.user,
        };
    }

    if (action.type === UserActions.SELECTED) {
        console.log('In Reducer: ' + action.payload.user);
        return {
            ...state,
            userSelected: action.payload.user,
        };
    }

    if (action.type === UserActions.INIT_USERS) {
        // console.log('Store : { payload : ' + action.payload.users + ', type : ' + action.type + '}');
        return {
            ...state,
            users: action.payload.users,
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

    if (action.type === CardsActions.SELECT_CARD_IN_GAME) {
        return {
            ...state,
            cardSelectedInGame: action.payload.card,
        };
    }

    return state;
};
