function ChatHeader(props) {
    const { user } = props;
    return (
        <div className="ui segment">
            <div className="ui top attached label">
                <div className="ui two column grid">
                    <div className="column">Chat</div>
                    <div className="column">
                        <div className="ui two column grid">
                            {user === null ? (
                                <div className="column">
                                'Adversaire'
                                </div>
                            ) : (
                                <div className="column">
                                    {user.surName} {user.lastName}
                                </div>
                            )}
                            <div className="column">
                                <i className="user circle icon"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ChatHeader;
