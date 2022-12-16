import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { cardInit, userCardsToSell } from '../../core/actions/cards.action';
import {
    selectorCardsToBuy,
    selectorCardsToSell,
    selectorSelectedCard,
} from '../../core/selectors/card.selector';

import Card from '../Card';
import Config from '../../config';
import { selectorUserConnected } from '../../core/selectors/user.selector';

function CardList(props) {
    const { mode } = props;

    //For redux
    const dispatch = useDispatch();
    const cardsListToBuy = useSelector(selectorCardsToBuy);
    const cardsListToSell = useSelector(selectorCardsToSell);
    const selectedCard = useSelector(selectorSelectedCard);
    const user = useSelector(selectorUserConnected);

    useEffect(() => {
        let urlToFetch =
            mode === Config.MODE.SELL
                ? Config.API_CARD_PATH + 'cardsToSell/' + user.id
                : Config.API_CARD_PATH + 'cardsToBuy';
        fetch(urlToFetch, {
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                Accept: 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((json) => {
                mode === Config.MODE.SELL
                    ? dispatch(userCardsToSell(json))
                    : dispatch(cardInit(json));
            });
    }, []);

    let cardsList =
        mode === Config.MODE.SELL ? cardsListToSell : cardsListToBuy;

    return (
        <div className="ui grid">
            <div className="ten wide column">
                <h3 className="ui aligned header"> My Card List</h3>
                <table className="ui selectable celled table" id="cardListId">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Family</th>
                            <th>HP</th>
                            <th>Energy</th>
                            <th>Defence</th>
                            <th>Attack</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {cardsList.map((card) => (
                            <Card
                                card={card}
                                display="row"
                                key={card.id}
                                mode={mode}
                            />
                        ))}
                    </tbody>
                </table>
            </div>
            <div className="five wide column">
                <div id="card">
                    {JSON.stringify(selectedCard) !== '{}' &&
                    selectedCard !== null ? (
                        <Card card={selectedCard} display="card" mode={mode} />
                    ) : (
                        ''
                    )}
                </div>
            </div>
        </div>
    );
}

export default CardList;
