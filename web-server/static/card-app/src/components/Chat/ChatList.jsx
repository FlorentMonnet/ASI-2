import ChatListItem from './ChatListItem';
import { Dropdown } from 'semantic-ui-react';

function ChatList(props) {
    const { users } = props;

    const DropdownExampleSelection = () => (
        <Dropdown placeholder="Select Friend" fluid selection options={users} />
    );

    return (
        <DropdownExampleSelection></DropdownExampleSelection>
    );
}

export default ChatList;
