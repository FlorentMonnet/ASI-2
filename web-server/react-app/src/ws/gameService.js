import { useNavigate } from 'react-router-dom';
import Config from '../config';
import { endGame, updateGame } from '../core/actions/game.action';
import {
    setOpponentInGame,
    setUserPointInStartGame,
} from '../core/actions/user.action';

class GameService {
    static _instance;

    constructor(
        socket = null,
        navigate = null,
        dispatch = null,
        userConnected = null
    ) {
        if (!GameService._instance) {
            GameService._instance = this;
        }
        if (
            socket !== null &&
            navigate !== null &&
            dispatch !== null &&
            userConnected !== null
        ) {
            this.socket = socket;
            this.navigate = navigate;
            this.dispatch = dispatch;
            this.userConnected = userConnected;

            //When a another user joined the room
            socket.on(Config.SOCKET_EVENT.OPPONENT_FOUND, (user) => {
                //Dispacth action for add opponent
                dispatch(setOpponentInGame(user));
                this.navigate('/play');
            });

            // For navigate to play
            socket.on(Config.SOCKET_EVENT.ROOM_JOINED, () => {
                this.navigate('/play');
            });

            //For update game
            socket.on(Config.SOCKET_EVENT.UPDATE_GAME, (update) => {
                update = JSON.parse(update);

                let userIndex =
                    update.users[0].id === this.userConnected.id ? 0 : 1;
                let opponentIndex =
                    update.users[0].id === this.userConnected.id ? 1 : 0;
                console.log('For update game');
                console.log(userIndex);
                console.log(opponentIndex);

                let user = update.users[userIndex];
                let adverseUser = update.users[opponentIndex];
                let cards = this.getListWithoutNull(update.cardsUsers[user.id]);
                let adverseCards = this.getListWithoutNull(
                    update.cardsUsers[adverseUser.id]
                );
                let currentPoint = update.currentAttanquantEnergyPoint;
                let turnGameUserId = update.currentUserTurn;

                dispatch(
                    updateGame(
                        user,
                        adverseUser,
                        cards,
                        adverseCards,
                        currentPoint,
                        turnGameUserId
                    )
                );
            });

            // For navigate to play
            socket.on(Config.SOCKET_EVENT.END_GAME, (end) => {
                dispatch(endGame());
                end = JSON.parse(end);
                if (end.winnerUserId === this.userConnected.id) {
                    this.navigate('/win');
                } else {
                    this.navigate('/loose');
                }
            });

            this._instance = this;
        } else {
            throw new Error(
                'Impossible de creer un Game Service sans paramétres'
            );
        }
        return GameService._instance;
    }

    static getInstance() {
        if (!GameService._instance) {
            throw new Error('GameService jamais instancier');
        } else {
            return this._instance;
        }
    }

    addOnWaitingList(user) {
        this.socket.emit(Config.SOCKET_EVENT.ADD_WAITING_LIST, user);
    }

    attack(attack) {
        this.socket.emit(Config.SOCKET_EVENT.GAME_ATTACK, attack);
    }

    getListWithoutNull(cards) {
        let cardsWithoutNull = cards.filter((r) => r !== null);
        return cardsWithoutNull;
    }
}
export default GameService;
