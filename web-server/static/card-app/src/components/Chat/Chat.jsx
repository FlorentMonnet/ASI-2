import React, { useEffect } from 'react';
import {ChatHeader} from './ChatHeader';
import {ChatList} from './ChatList';
import {useDispatch, useSelector} from 'react-redux';
import { userInit } from '../../core/actions/user.action';
import {
    selectorUsers,
    selectUser
} from '../../core/selectors/user.selector';
import Config from '../../config';

export function Chat(props) {

    const dispatch = useDispatch();
    const usersList = useSelector(selectorUsers);
    const userSelected = useSelector(selectUser);

    useEffect(() => {
        let urlToFetch = Config.API_PATH + 'users';
        fetch(urlToFetch)
        .then((response) => response.json())
        .then((json) => { dispatch(userInit(json));
        });
        }, [dispatch]);
    console.log("in chat:" + usersList);

    return (
        <div>
            <ChatHeader user={userSelected}></ChatHeader>
            <ChatList users={usersList}></ChatList>
        </div>
    );
}