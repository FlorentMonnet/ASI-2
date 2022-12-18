import React, { useState } from 'react';
import { useSelector } from 'react-redux';
import {
    selectorAdverseUserCards,
    selectorSelectedCardInGame,
    selectorSelectedCardOpponentInGame,
    selectorUserCardsToPlay,
} from '../../core/selectors/card.selector';
import {
    selectorUserConnected,
    selectorAdverseUser,
    selectorTurnUserId,
    selectorUserPointInGame,
} from '../../core/selectors/user.selector';
import CardListGame from '../CardListGame';
import User from '../User/Index';
import Config from '../../config';
import Card from '../Card';
import Chat from '../Chat/Chat';
import GameService from '../../ws/gameService';

function GameZone() {
    const user = useSelector(selectorUserConnected);
    const adverseUser = useSelector(selectorAdverseUser);

    const cards = useSelector(selectorUserCardsToPlay);
    const adverseCards = useSelector(selectorAdverseUserCards);

    const turnUserId = useSelector(selectorTurnUserId);

    const cardSelectedInGame = useSelector(selectorSelectedCardInGame);
    const cardOpponentSelectedInGame = useSelector(
        selectorSelectedCardOpponentInGame
    );

    const currentPoint = useSelector(selectorUserPointInGame);

    function attack() {
        if (
            cardSelectedInGame !== null &&
            cardOpponentSelectedInGame !== null
        ) {
            const gameService = GameService.getInstance();
            let attack = {
                user: user,
                opponent: adverseUser,
                userPoint: currentPoint,
                card: cardSelectedInGame,
                attackedCard: cardOpponentSelectedInGame,
            };
            gameService.attack(attack);
        } else {
            alert('Select cards');
        }
    }

    console.log('turnUserId === user.id');
    console.log(turnUserId + ' === ' + user.id);

    console.log(turnUserId === user.id);

    return (
        <div className="ui segment">
            <div className="ui grid">
                <div className="four wide column">
                    <div id="chatContent">
                        <Chat />
                    </div>
                </div>
                <div className="twelve wide column">
                    <div className="row">
                        <div className="ui grid">
                            <div className="two wide column">
                                {adverseUser !== null ? (
                                    <User
                                        mode={Config.MODE.GAME_ZONE}
                                        user={adverseUser}
                                        point={
                                            turnUserId === adverseUser.id
                                                ? currentPoint
                                                : 0
                                        }
                                    />
                                ) : (
                                    ''
                                )}
                            </div>
                            <div className="ten wide column">
                                <CardListGame
                                    cards={adverseCards}
                                    mode={Config.MODE.GAME_ADVERSE}
                                />
                            </div>
                            <div className="four wide column">
                                <div id="fullCardA1">
                                    {cardOpponentSelectedInGame !== null ? (
                                        <Card
                                            card={cardOpponentSelectedInGame}
                                            display="card"
                                            mode={Config.MODE.GAME}
                                        />
                                    ) : (
                                        ''
                                    )}
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row">
                        <div className="ui grid ">
                            <div className="twelve wide column">
                                <h4 className="ui horizontal divider header">
                                    VS
                                </h4>
                            </div>
                            <div className="four wide column">
                                <button
                                    className={
                                        turnUserId === user.id
                                            ? 'huge ui primary button'
                                            : 'huge ui primary button disabled'
                                    }
                                    onClick={() => attack()}
                                >
                                    Attack
                                </button>
                            </div>
                        </div>
                    </div>

                    <div className="row">
                        <div className="ui grid">
                            <div className="two wide column">
                                <User
                                    mode={Config.MODE.GAME_ZONE}
                                    user={user}
                                    point={
                                        turnUserId === user.id
                                            ? currentPoint
                                            : 0
                                    }
                                />
                            </div>
                            <div className="ten wide column">
                                <CardListGame
                                    cards={cards}
                                    mode={Config.MODE.GAME}
                                />
                            </div>
                            <div className="four wide column">
                                <div id="fullCardB1">
                                    {cardSelectedInGame !== null ? (
                                        <Card
                                            card={cardSelectedInGame}
                                            display="card"
                                            mode={Config.MODE.GAME}
                                        />
                                    ) : (
                                        ''
                                    )}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default GameZone;
