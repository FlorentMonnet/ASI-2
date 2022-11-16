import React, { useState, useEffect } from 'react';
import io from 'socket.io-client';

function ChatWindow(props) {

    const { user } = props;
    var messages = [];
  
    // var messages = document.getElementById('messages');
    // var form = document.getElementById('form');

    const sendMessage = () => {
        var input = document.getElementById('message_input');
        var socket = io();

        if (input.value) {
            socket.emit('chat message', input.value);
            input.value = '';
        }

        socket.on('chat message', function(msg) {
            messages.push(msg);
        });
    }
      
    return (
        <div>
            <div className="ui segment">
                {/* {messages.map((message) => ( */}
                    <div className="ui raised segment">
                        <a className="ui blue ribbon label">Eric</a>
                        <span> 10:00:01</span>
                        <p>good luck!</p>
                    </div>
                {/* ))} */}
            </div>

            <div className="ui form">
                <div className="field">
                    <textarea
                        id="message_input"
                        placeholder="Send a message"
                        rows="2"
                    ></textarea>
                </div>
            </div>

            <button
                // onclick={sendMessage()}
                id="send_message_button"
                className="fluid ui right labeled icon button"
            >
                <i className="right arrow icon"></i>
                Send
            </button>
        </div>
    );
}

export default ChatWindow;
