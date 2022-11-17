import React, { useEffect } from 'react';
import ChatListItem from './ChatListItem';
import { Dropdown } from 'semantic-ui-react';
import { useDispatch } from 'react-redux';
import { setSelectedUser } from '../../core/actions/user.action';

function ChatList(props) {
    const { users } = props;

    const findUserById = (userId) => {
        var usersEntries = Object.entries(users);
        for (const [key, value] of usersEntries) {
            if (value['id'] == userId) {
                return value;
            }
        }
        return null;
    };

    // const toto = () => {
    //     var childs = document.getElementsByClassName('menu')[0].children; //returns a HTMLCollection
    //     for (var i = 0; i < childs.length; i++) {
    //         // iterate over it
    //         console.log("toto: " + childs[i]);

    //         childs[i].onclick = function () {
    //             // attach event listener individually
    //             console.log("toto: " + childs[i]);
    //         };
    //     }
    // };

    const dispatch = useDispatch();

    // const selectedUser = () => {
    //     var dropdown = document.getElementsByClassName('selected');
    //     var userId = dropdown[0].id;
    //     console.log(dropdown[0].textContent);
    //     dispatch(setSelectedUser(findUserById(userId)));
    // };

    const selectedUser = () => {
        let selectBox = document.getElementById("dropdown");
        let selectedOption = selectBox.options[selectBox.selectedIndex];
        console.log(selectedOption.value);
        let userId = selectedOption.value;
        dispatch(setSelectedUser(findUserById(userId)));
    };

    const userOptions = users.map((user) => {   
        return {
            id: user.id,
            key: user.id,
            text: user.surName + ' ' + user.lastName,
            value: user.surName + ' ' + user.lastName,
        };
    });

    // const DropdownExampleSelection = () => (
    //     <Dropdown
    //         id="user_dropdown_list"
    //         onchange={selectedUser}
    //         placeholder="Select Friend"
    //         fluid
    //         selection
    //         options={userOptions}
    //     />
    // );

    // useEffect(() => {
    //     toto();
    // }, []);

    // return <DropdownExampleSelection></DropdownExampleSelection>;

    return (
        <div>
            <select id="dropdown" onChange={selectedUser} className="ui dropdown">
                <option value="">Choose a user</option>
                {users.map((user) => (
                    <ChatListItem
                        key={user.id}
                        user={user}
                    />
                ))}

                {/* <option value="">Gender</option>
                <option value="1">Male</option>
                <option value="0">Female</option> */}
            </select>
        </div>
    );
}

export default ChatList;
