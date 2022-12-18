import React from 'react';

function ChatList() {

    const selectedUser = () => {
        let selectBox = document.getElementById("dropdown");
        let selectedOption = selectBox.options[selectBox.selectedIndex];
        console.log(selectedOption.value);
        if (selectedOption.value === "all") {
            console.log("all");
        } else if (selectedOption.value === "opponent") {
            console.log("opponent");
        }
    };

    return (
        <div>
            <select id="dropdown" onChange={selectedUser} className="ui dropdown">
                <option value="all">All</option>
                <option value="opponent">Opponent</option>
            </select>
        </div>
    );
}

export default ChatList;
