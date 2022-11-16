import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { cardInit, cardsToSellInit } from '../../core/actions/cards.action';
import {
    selectorCards,
    selectorCardsToSell,
    selectorSelectedCard,
} from '../../core/selectors/card.selector';

import Card from '../Card';
import Config from '../../config';

function CardList(props) {
    const { mode } = props;

    //For redux
    const dispatch = useDispatch();
    const cardsListToBuy = useSelector(selectorCards);
    const cardsListToSell = useSelector(selectorCardsToSell);
    const selectedCard = useSelector(selectorSelectedCard);

    useEffect(() => {
        let urlToFetch =
            mode === 'sell'
                ? Config.API_PATH + 'cards'
                : Config.API_PATH + 'cards';
        fetch(urlToFetch)
            .then((response) => response.json())
            .then((json) => {
                mode === 'sell'
                    ? dispatch(cardsToSellInit(json))
                    : dispatch(cardInit(json));
            });
    }, [dispatch, mode]);

    let cardsList = mode === 'sell' ? cardsListToSell : cardsListToBuy;

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
                    {JSON.stringify(selectedCard) !== '{}' ? (
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
