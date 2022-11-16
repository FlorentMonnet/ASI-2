import React from 'react';
import { Link } from 'react-router-dom';

function User(props) {
    const { mode, user } = props;

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
                        <span id="userNameId">{user.login}</span>
                        <div className="sub header">
                            <span>{user.account}</span>$
                        </div>
                    </div>
                </>
            );
        }
    }

    function displayInGameZone() {
        <div class="ui one  column centered grid">
            <div class="row">
                <div class="column">
                    {' '}
                    <i class="user circle huge icon "></i>
                </div>
            </div>
            <div class="row">
                <div class=" column">{user.login}</div>
            </div>

            <div class="row">
                <div class="column">
                    <div
                        class="ui teal progress"
                        data-percent="74"
                        id="progressBarId1"
                    >
                        <div class="bar"></div>
                        <div class="label">Action Points</div>
                    </div>
                </div>
            </div>
        </div>;
    }

    if (mode === 'Header') {
        return displayInHeader();
    } else if (mode === 'GameZone') {
        return displayInGameZone();
    }
}

export default User;
