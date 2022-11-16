import React from 'react';
import Card from '../Card';

function CardListGame(props) {
    const { cards, mode } = props;
    return (
        <div className="ui four column grid">
            {cards.map((card) => (
                <div className="column">
                    <Card
                        card={card}
                        display="short"
                        key={card.id}
                        mode={mode}
                    />
                </div>
            ))}
        </div>
    );
}

export default CardListGame;
