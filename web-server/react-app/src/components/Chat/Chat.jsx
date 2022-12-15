import React, { useEffect } from 'react';
import ChatHeader from './ChatHeader';
import ChatList from './ChatList';
import ChatWindow from './ChatWindow';
import { useDispatch, useSelector } from 'react-redux';
import { userInit } from '../../core/actions/user.action';
import { selectorUsers, selectUser } from '../../core/selectors/user.selector';
import Config from '../../config';

function Chat(props) {
    const dispatch = useDispatch();
    const usersList = useSelector(selectorUsers);
    const userSelected = useSelector(selectUser);
    const messages = null;

    useEffect(() => {
        let urlToFetch = Config.API_PATH + 'users';
        fetch(urlToFetch)
            .then((response) => response.json())
            .then((json) => {
                dispatch(userInit(json));
            });
    }, []);

    return (
        <div className="ui segment">
            <div className="ui five column grid">
                <div className="column">
                    <ChatHeader user={userSelected}></ChatHeader>
                    <ChatList users={usersList}></ChatList>
                    <ChatWindow
                        user={userSelected}
                        messages={messages}
                    ></ChatWindow>
                </div>
            </div>
        </div>
    );
}

export default Chat;
