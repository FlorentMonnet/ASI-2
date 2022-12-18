import React from 'react';
import { useSelector } from 'react-redux';
import ChatService from '../../ws/chatService';
import { selectorMessages } from '../../core/selectors/chat.selector';
function ChatWindow() {

    const messages = useSelector(selectorMessages);

    function sendMessage() {
        const chatService = ChatService.getInstance();
        var input = document.getElementById('message_input');
        if (input) {
            if (input.value) {
                chatService.emitMessage(input.value);
                input.value = '';
            }
        }
    }

    return (
        <div>
            <div>
                <div className="ui segment">
                    {messages == null ? (
                        <span>No messages</span>
                    ) : (
                        messages.map((message) => {
                            return (<div className="ui raised segment">
                                {/* <a className="ui green ribbon label">You</a> */}
                                {/* <a className="ui blue ribbon label">Opponent</a> */}
                                <p>{message}</p>
                            </div>);
                        })
                    )}


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
                    onClick={() => sendMessage()}
                    id="send_message_button"
                    className="fluid ui right labeled icon button"
                >
                    <i className="right arrow icon"></i>
                    Send
                </button>
            </div>
        </div>

    );
}

export default ChatWindow;
