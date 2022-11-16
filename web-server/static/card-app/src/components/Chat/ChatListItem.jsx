
import {useDispatch} from 'react-redux';
import {setSelectedUser} from '../../core/actions/user.action';

function ChatListItem(props) {
    const {user} = props;
    const dispatch = useDispatch();
    const selectedUser = () => {
        console.log("toto");
        console.log(selectedUser);
        dispatch(setSelectedUser(user));
    };

    return (
        <div onClick={selectedUser} key={user.id} data-value="jd"><i className="item jd user circle icon"></i>
            {user.surName} {user.lastName}
        </div>
    );
}

export default ChatListItem;