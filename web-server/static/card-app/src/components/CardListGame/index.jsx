import React from 'react';
import Card from '../Card';

function CardListGame(props) {
    const { cardList } = props;
    return (
        <div className="ui four column grid">
            {cardList.map((card) => (
                <div className="column">
                    <Card
                        card={card}
                        display="short"
                        key={card.id}
                        mode="Game"
                    />
                </div>
            ))}
        </div>
    );
}

export default CardListGame;
