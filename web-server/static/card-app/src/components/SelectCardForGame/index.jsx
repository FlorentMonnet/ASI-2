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

function SelectCardForGame() {
    const navigate = useNavigate();

    //For redux
    const dispatch = useDispatch();
    const cardList = useSelector(selectorUserCards);
    const cardListToPlay = useSelector(selectorUserCardsToPlay);

    useEffect(() => {
        dispatch(resetCardForGame());

        fetch(Config.API_PATH + 'cards')
            .then((response) => response.json())
            .then((json) => {
                dispatch(userCardsToSell(json));
            });
    }, []);

    function goToGame() {
        if (cardListToPlay.length === 4) {
            navigate('/');
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
                                    mode="Game"
                                />
                            </div>
                        );
                    })}
                </div>
            </div>
            <div className="ui segment">
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
