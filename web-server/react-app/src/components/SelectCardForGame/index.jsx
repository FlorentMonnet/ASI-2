import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import Config from '../../config';
import {
    resetCardForGame,
    userCardsToSell,
} from '../../core/actions/cards.action';
import {
    selectorUserCards,
    selectorUserCardsToPlay,
} from '../../core/selectors/card.selector';
import Card from '../Card';
import GameService from '../../ws/gameService';
import { selectorUserConnected } from '../../core/selectors/user.selector';
import { socket } from '../../ws';

function SelectCardForGame() {
    const navigate = useNavigate();

    //For redux
    const dispatch = useDispatch();
    const cardList = useSelector(selectorUserCards);
    const cardListToPlay = useSelector(selectorUserCardsToPlay);
    const user = useSelector(selectorUserConnected);

    //Call
    var gameService = new GameService(socket, navigate, dispatch, user);

    useEffect(() => {
        dispatch(resetCardForGame());

        fetch(Config.API_CARD_PATH + 'cards', {
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                Accept: 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => {
                dispatch(userCardsToSell(json));
            });
    }, []);

    function goToGame() {
        if (cardListToPlay.length === 4) {
            //navigate('/play');
            const data = {
                user: user,
                cards: cardListToPlay,
            };
            gameService.addOnWaitingList(JSON.stringify(data));
            navigate('/loading-game');
        } else {
            alert('Select 4 card');
        }
    }

    return (
        <>
            <div className="ui segment">
                <div className={'ui four column grid'}>
                    {cardList.map((card, index) => {
                        return (
                            <div className="column">
                                <Card
                                    card={card}
                                    display="short"
                                    key={card.id}
                                    mode={Config.MODE.SELECT_CARD}
                                />
                            </div>
                        );
                    })}
                </div>
            </div>
            <div className="ui segment center aligned">
                <button
                    className="ui inverted teal button"
                    onClick={() => goToGame()}
                >
                    Launch game
                </button>
            </div>
        </>
    );
}

export default SelectCardForGame;
