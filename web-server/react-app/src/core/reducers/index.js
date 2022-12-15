import { CardsActions } from '../actions/cards.action';
import { GameActions } from '../actions/game.action';
import { UserActions } from '../actions/user.action';

const initStateValue = {
    cards: [],
    cardsToSell: [],
    cardSelected: {},
    users: [],
    userConnected: null,
    cardToPlay: [],
    opponentCardToPlay: [],
    userSelected: null,
    opponentInGame: null,
    cardSelectedInGame: null,
    cardOpponentSelectedInGame: null,
    turnGameUserId: null,
    userPointInGame: 0,
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

    if (action.type === CardsActions.SELECT_CARD_OPPONENT_IN_GAME) {
        return {
            ...state,
            cardOpponentSelectedInGame: action.payload.card,
        };
    }

    if (action.type === UserActions.ADD_OPPONENT) {
        return {
            ...state,
            opponentInGame: action.payload.opponent,
        };
    }

    if (action.type === GameActions.UPDATE_GAME) {
        return {
            ...state,
            userConnected: action.payload.user,
            opponentInGame: action.payload.adverseUser,
            cardToPlay: action.payload.cards,
            opponentCardToPlay: action.payload.adverseCards,
            userPointInGame: action.payload.currentPoint,
            turnGameUserId: action.payload.turnGameUserId,
            cardOpponentSelectedInGame: null,
            cardSelectedInGame: null,
        };
    }

    if (action.type === GameActions.END_GAME) {
        return {
            ...state,
            opponentInGame: null,
            cardToPlay: null,
            opponentCardToPlay: null,
            userPointInGame: null,
            turnGameUserId: null,
            cardOpponentSelectedInGame: null,
            cardSelectedInGame: null,
        };
    }

    return state;
};
