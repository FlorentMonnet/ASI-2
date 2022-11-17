import React, { useState, useEffect } from 'react';
import io from 'socket.io-client';
import Config from '../../config';
import chatService from '../../ws/chatService';
function ChatWindow(props) {

    const { user } = props;

    const [messages, setMessages] = useState([]);

    const sendMessage = () => {
        var input = document.getElementById('message_input');


        if (input) {
            if (input.value) {
                chatService.emitMessage(input.value);
                // socket.emit('chat message', input.value);
                input.value = '';
            }
        }
    }

    return (
        <div>
            {user != null ? (
                <div>
                    <div className="ui segment">
                        {messages.map((message) => {
                            return (<div className="ui raised segment">
                                {/* Mettre un test pr voir qui est le sender */}
                                {message[2] == null ? (
                                    <a className="ui blue ribbon label">C moi</a>
                                ) : (
                                    <a className="ui green ribbon label">{user.surName}</a>
                                )}
                                <span> {message[1]}</span>
                                <p>{message[0]}</p>
                            </div>);
                        })}

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
                        onClick={sendMessage}
                        id="send_message_button"
                        className="fluid ui right labeled icon button"
                    >
                        <i className="right arrow icon"></i>
                        Send
                    </button>
                </div>
            ) : (
                <div className="column">
                </div>
            )}
        </div>

    );
}

export default ChatWindow;
