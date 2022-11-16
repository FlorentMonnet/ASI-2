
import {useDispatch} from 'react-redux';
import {setSelectedUser} from '../../core/actions/user.action';

export function ChatListItem(props) {
    const {user} = props;
    const dispatch = useDispatch();
    const selectedUser = () => {
        console.log('tes');
        //console.log(selectedUser);
        dispatch(setSelectedUser(user));
    };

    return (
            <option onClick={selectedUser} key={user.id} className="item" value={user.id}>
            {user.firstname} {user.lastname}
        </option>
    );
}
