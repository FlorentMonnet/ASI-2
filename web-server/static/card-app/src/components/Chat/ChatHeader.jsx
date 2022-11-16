
export function ChatHeader(props) {
    const {user} = props;
    return (
        <div>
            <h5 className="ui center aligned icon header">

                <div id="test" >
                    {user === null ? (
                           "Adversaire"
                           ) : <div>{user.firstname} {user.lastname}</div>}
                    <div>
                        <i className="circular user icon"></i>
                    </div>
                </div>
            </h5>
        </div>
    );
}
