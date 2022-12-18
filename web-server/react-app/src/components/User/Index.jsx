import React from 'react';
import { Link } from 'react-router-dom';
import { Progress } from 'semantic-ui-react';
import Config from '../../config';

function User(props) {
    const { mode, user, point } = props;

    function displayInHeader() {
        if (user === null) {
            return (
                <Link className="ui teal button" to="/login">
                    login
                </Link>
            );
        } else {
            return (
                <>
                    <i className="user circle outline icon"></i>
                    <div className="content">
                        <span id="userNameId">{user.name}</span>
                        <div className="sub header">
                            <span>{user.money}</span>$
                        </div>
                    </div>
                </>
            );
        }
    }

    function displayInGameZone() {
        return (
            <div className="ui one  column centered grid">
                <div className="row">
                    <div className="column">
                        {' '}
                        <i className="user circle huge icon "></i>
                    </div>
                </div>
                <div className="row">
                    <div className=" column">{user.name}</div>
                </div>

                <div className="row">
                    <div className="column">
                        <Progress percent={point} color="teal" progress>
                            Action Points
                        </Progress>
                    </div>
                </div>
            </div>
        );
    }

    if (mode === Config.MODE.HEADER) {
        return displayInHeader();
    } else if (mode === Config.MODE.GAME_ZONE) {
        return displayInGameZone();
    }
}

export default User;
