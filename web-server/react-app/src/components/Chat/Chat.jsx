import React, { useEffect } from 'react';
import ChatHeader from './ChatHeader';
import ChatList from './ChatList';
import ChatWindow from './ChatWindow';
import { useDispatch, useSelector } from 'react-redux';
import { userInit } from '../../core/actions/user.action';
import { selectorUsers, selectUser } from '../../core/selectors/user.selector';
import Config from '../../config';
import ChatService from '../../ws/chatService';
import { socket } from '../../ws';

function Chat(props) {
    const dispatch = useDispatch();
    const usersList = useSelector(selectorUsers);

    var chatService = new ChatService(socket, dispatch);

    return (
        <div className="ui segment">
                <div className="column">
                    <ChatHeader></ChatHeader>
                    <ChatList></ChatList>
                    <ChatWindow></ChatWindow>
                </div>
        </div>
    );
}

export default Chat;
