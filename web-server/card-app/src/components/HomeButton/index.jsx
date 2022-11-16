import React from 'react';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { selectorUserConnected } from '../../core/selectors/user.selector';

function HomeButton(props) {
    const { link, icon, label, classElem } = props;
    const user = useSelector(selectorUserConnected);

    return (
        <div className="column">
            <div className="ui segment fluid">
                <Link
                    to={user !== null ? link : '/login'}
                    className={classElem + ' massive fluid ui button'}
                >
                    <i className={icon + ' icon'}></i>
                    <p>{label}</p>
                </Link>
            </div>
        </div>
    );
}

export default HomeButton;
