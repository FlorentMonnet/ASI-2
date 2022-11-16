import React, { useState, useEffect } from 'react';
import io from 'socket.io-client';
import Config from '../../config';

function ChatWindow(props) {

    const { user } = props;

    const [messages, setMessages] = useState([]);

    const sendMessage = () => {
        var input = document.getElementById('message_input');
        const io = require("socket.io-client");

        const socket = io(Config.SOCKET_PATH, {
            cors: {
                origin: Config.SOCKET_PATH,
                methods: ["GET", "POST"],
            }
        });

        if (input) {
            if (input.value) {
                socket.emit('chat message', input.value);
                input.value = '';
            }
        }

        socket.on('chat message', function (msg) {
            var current_date = new Date();
            var hh = String(current_date.getHours()).padStart(2, '0');
            var mm = String(current_date.getMinutes() + 1).padStart(2, '0');
            var ss = String(current_date.getSeconds() + 1).padStart(2, '0');
            current_date = hh + ':' + mm + ':' + ss;
            setMessages([...messages, [msg, current_date, socket.id]])
        });
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
