import React from 'react';
import { useSelector } from 'react-redux';
import { userConnected } from '../../core/selectors/user.selector';
import { Link } from 'react-router-dom';

function User() {
    const user = useSelector(userConnected);
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

export default User;
