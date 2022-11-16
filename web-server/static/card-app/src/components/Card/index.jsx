import React from 'react';
import { useDispatch } from 'react-redux';
import { selectCard } from '../../core/actions/cards.action';
import { useSelector } from 'react-redux';
import { userConnected } from '../../core/selectors/user.selector';
import Config from '../../config';
import { connectUserAction } from '../../core/actions/user.action';

function Card(props) {
    const { card, display, mode } = props;
    const dispatch = useDispatch();

    const user = useSelector(userConnected);

    function displayInRow() {
        return (
            <tr
                onClick={() => {
                    dispatch(selectCard(card));
                }}
            >
                <td>
                    <img className="ui avatar image" src={card.imgUrl} />{' '}
                    <span>{card.name}</span>
                </td>
                <td>{card.description}</td>
                <td>{card.family}</td>
                <td>{card.hp}</td>
                <td>{card.energy}</td>
                <td>{card.defence}</td>
                <td>{card.attack}</td>
                <td>{card.price}$</td>
                <td>
                    <div className="ui vertical animated button" tabIndex="0">
                        <div className="hidden content">
                            {mode === 'sell' ? 'Sell' : 'Buy'}
                        </div>
                        <div className="visible content">
                            <i className="shop icon"></i>
                        </div>
                    </div>
                </td>
            </tr>
        );
    }

    function displayInCard() {
        return (
            <div className="ui segment">
                <div className="ui special cards">
                    <div className="card">
                        <div className="content">
                            <div className="ui grid">
                                <div className="three column row">
                                    <div className="column">
                                        <i className="heart outline icon"></i>
                                        <span id="cardHPId">{card.hp}</span>
                                    </div>
                                    <div className="column">
                                        <h5>{card.name}</h5>
                                    </div>
                                    <div className="column">
                                        <span id="energyId">{card.energy}</span>{' '}
                                        <i className="lightning icon"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="image imageCard">
                            <div className="blurring dimmable image">
                                <div className="ui inverted dimmer">
                                    <div className="content">
                                        <div className="center">
                                            <div className="ui primary button">
                                                Add Friend
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="ui fluid image">
                                    <a className="ui left corner label">
                                        {card.name}
                                    </a>
                                    <img
                                        id="cardImgId"
                                        className="ui centered image"
                                        src={card.imgUrl}
                                        alt="img"
                                    />
                                </div>
                            </div>
                        </div>
                        <div className="content">
                            <div className="ui form tiny">
                                <div className="field">
                                    <label id="cardNameId"></label>
                                    <textarea
                                        id="cardDescriptionId"
                                        className="overflowHiden"
                                        readOnly=""
                                        rows="5"
                                        defaultValue={card.description}
                                    ></textarea>
                                </div>
                            </div>
                        </div>
                        <div className="content">
                            <i className="heart outline icon"></i>
                            <span id="cardHPId"> HP {card.hp}</span>
                            <div className="right floated ">
                                <span id="cardEnergyId">
                                    Energy {card.energy}
                                </span>
                                <i className="lightning icon"></i>
                            </div>
                        </div>
                        <div className="content">
                            <span className="right floated">
                                <span id="cardAttackId">
                                    {' '}
                                    Attack {card.attack}
                                </span>
                                <i className=" wizard icon"></i>
                            </span>
                            <i className="protect icon"></i>
                            <span id="cardDefenceId">
                                Defense {card.defence}
                            </span>
                        </div>
                        <button
                            className="ui bottom attached button"
                            onClick={() => makeTransaction()}
                        >
                            <i className="money icon"></i>
                            {mode === 'sell' ? 'Sell for ' : 'Buy for '}
                            <span id="cardPriceId"> {card.price}$</span>
                        </button>
                    </div>
                </div>
            </div>
        );
    }

    function displayInShort() {
        return (
            <div className="ui segment">
                <div className="ui special cards">
                    <div className="card">
                        <div className="content">
                            <div className="ui grid">
                                <div className="three column row">
                                    <div
                                        className="column"
                                        style={{ textAlign: 'center' }}
                                    >
                                        <a className="ui red circular label">
                                            {card.hp}
                                        </a>
                                    </div>
                                    <div className="column">
                                        <h5>{card.name}</h5>
                                    </div>
                                    <div
                                        className="column"
                                        style={{ textAlign: 'center' }}
                                    >
                                        <a className="ui yellow circular label">
                                            {card.energy}
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="image imageCard">
                            <div className="ui fluid image">
                                <img
                                    id="cardImgId"
                                    className="ui centered image"
                                    src={card.smallImgUrl}
                                    alt="img"
                                />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

    function makeTransaction() {
        let urlToFetch =
            mode === 'sell'
                ? Config.API_PATH + 'store/sell'
                : Config.API_PATH + 'store/buy';

        let transaction = {
            user_id: user.id,
            card_id: card.id,
        };

        fetch(urlToFetch, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
            body: JSON.stringify(transaction),
        })
            .then((response) => response.json())
            .then((json) => {
                console.log(json);
                if (json) {
                    // for refresh user
                    fetch(Config.API_PATH + 'user/' + user.id)
                        .then((response) => response.json())
                        .then((json) => {
                            dispatch(connectUserAction(json));
                        });
                }
            });
    }

    if (display === 'short') {
        return displayInShort();
    } else if (display === 'card') {
        return displayInCard();
    } else if (display === 'row') {
        return displayInRow();
    }
}

export default Card;
