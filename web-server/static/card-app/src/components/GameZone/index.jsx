import React from 'react';
import { useSelector } from 'react-redux';
import {
    selectorAdverseUserCards,
    selectorUserCards,
} from '../../core/selectors/card.selector';
import {
    selectorUserConnected,
    selectorAdverseUser,
} from '../../core/selectors/user.selector';
import CardListGame from '../CardListGame';
import User from '../User/Index';
import Chat from '../Chat/Chat';

function GameZone() {
    const user = useSelector(selectorUserConnected);
    const adverseUser = useSelector(selectorAdverseUser);

    const cards = useSelector(selectorUserCards);
    const adverseCards = useSelector(selectorAdverseUserCards);

    return (
        <div className="ui segment">
            <div className="ui grid">
                <div className="four wide column">
                    <div id="chatContent">
                        <Chat></Chat>
                    </div>
                </div>
                <div className="twelve wide column">
                    <div className="row">
                        <div className="ui grid">
                            <div className="two wide column">
                                <User mode="GameZone" user={adverseUser} />
                            </div>
                            <div className="ten wide column">
                                <CardListGame
                                    cards={adverseCards.slice(0, 4)}
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
                                <User mode="GameZone" user={user} />
                            </div>
                            <div className="ten wide column">
                                <div className="ui four column grid">
                                    <CardListGame cards={cards.slice(0, 4)} />
                                </div>
                            </div>
                            <div className="four wide column">
                                <div id="fullCardB1"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default GameZone;
