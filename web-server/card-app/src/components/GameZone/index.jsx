import React from 'react';
import { useSelector } from 'react-redux';
import {
    selectorAdverseUserCards,
    selectorSelectedCardInGame,
    selectorUserCardsToPlay,
} from '../../core/selectors/card.selector';
import {
    selectorUserConnected,
    selectorAdverseUser,
} from '../../core/selectors/user.selector';
import CardListGame from '../CardListGame';
import User from '../User/Index';
import Config from '../../config';
import Card from '../Card';

function GameZone() {
    const user = useSelector(selectorUserConnected);
    const adverseUser = useSelector(selectorAdverseUser);

    const cards = useSelector(selectorUserCardsToPlay);
    const adverseCards = useSelector(selectorAdverseUserCards);

    const cardSelectedInGame = useSelector(selectorSelectedCardInGame);

    return (
        <div className="ui segment">
            <div className="ui grid">
                <div className="four wide column">
                    <div id="chatContent"></div>
                </div>
                <div className="twelve wide column">
                    <div className="row">
                        <div className="ui grid">
                            <div className="two wide column">
                                <User
                                    mode={Config.MODE.GAME_ZONE}
                                    user={adverseUser}
                                />
                            </div>
                            <div className="ten wide column">
                                <CardListGame
                                    cards={adverseCards}
                                    mode={Config.MODE.GAME_ADVERSE}
                                />
                            </div>
                            <div className="four wide column">
                                <div id="fullCardA1"></div>
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
                                <button className="huge ui primary button">
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