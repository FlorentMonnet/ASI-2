export const userConnected = (state) => state.userConnected;

export const selectUser = (state) => {
    console.log("dans selector: " +  state.userSelected);
    return state.userSelected;
};

export const selectorUsers = (state) => state.users;
