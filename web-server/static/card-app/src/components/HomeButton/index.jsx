import React from 'react';
import { Link } from 'react-router-dom';

function HomeButton(props) {
    const { link, icon, label, classElem } = props;

    return (
        <div className="column">
            <div className="ui segment fluid">
                <Link
                    to={link}
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
