export const UserActions = {
    INIT_USERS: '@@user/INIT_USERS',
    CONNECT: '@@user/CONNECT',
    SELECTED: '@@user/SELECTED'
};

export const userInit = (users) => {
    return {
        type: UserActions.INIT_USERS,
        payload: {
            users,
        },
    };
};

export const connectUserAction = (user) => {
    console.log(user);
    return {
        type: UserActions.CONNECT,
        payload: {
            user,
        },
    };
};

export const setSelectedUser = (user) => {
    console.log(user);
    return {
        type: UserActions.SELECTED,
        payload: {
            user,
        },
    };
};
