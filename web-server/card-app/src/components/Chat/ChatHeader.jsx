
function ChatHeader(props) {
    const {user} = props;
    console.log("In ChatHeader: " + user)
    return (
        <div>
            <h5 className="ui center aligned icon header">

                <div id="test" >
                    {user === null ? (
                           "Adversaire"
                           ) : <div>{user.surName} {user.lastName}</div>}
                    <div>
                        <i className="circular user icon"></i>
                    </div>
                </div>
            </h5>
        </div>
    );
}

export default ChatHeader;
