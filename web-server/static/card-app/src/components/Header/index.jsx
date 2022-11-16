import React from 'react';
import { Link } from 'react-router-dom';
import User from '../User/Index';

function Header(props) {
    const { iconHeader, title, subTitle } = props;

    return (
        <>
            <div className="ui clearing segment">
                <h3 className="ui right floated header">{<User />}</h3>

                <Link className="ui left floated header" to="/">
                    <i className={iconHeader + ' icon'}></i>
                    <div className="content">
                        {title}
                        <div className="sub header">{subTitle}</div>
                    </div>
                </Link>
            </div>
        </>
    );
}

export default Header;
