import {ChatListItem} from "./ChatListItem";

export function ChatList(props) {
    const {users} = props;

    return (
        <select className="ui dropdown">
            <option value="">Select Friend</option>
            {users.map((user) => (
                <ChatListItem
                    key={user.id}
                    user={user}
                />
            ))}
        </select>
    )
        ;
}
