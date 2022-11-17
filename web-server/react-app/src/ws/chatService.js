import Config from '../config';
import { socket } from './index';
import React, { useState, useEffect } from 'react';

// socket.on(Config.SOCKET_EVENT.OPPONENT_FOUND, (userIdFound) => {
//     alert('Opponent found ' + userIdFound);
// });
const [messages, setMessages] = useState([]);

socket.on('chat message', function (msg) {
    var current_date = new Date();
    var hh = String(current_date.getHours()).padStart(2, '0');
    var mm = String(current_date.getMinutes() + 1).padStart(2, '0');
    var ss = String(current_date.getSeconds() + 1).padStart(2, '0');
    current_date = hh + ':' + mm + ':' + ss;
    setMessages([...messages, [msg, current_date, socket.id]])
});

export default {
    emitMessage(message) {
        socket.emit(Config.SOCKET_EVENT.CHAT_MESSAGE, message);
    }
}