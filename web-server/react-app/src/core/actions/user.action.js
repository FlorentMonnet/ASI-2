export const UserActions = {
    INIT_USERS: '@@user/INIT_USERS',
    CONNECT: '@@user/CONNECT',
    SELECTED: '@@user/SELECTED',
    ADD_OPPONENT: '@@user/ADD_OPPONENT',
    UPDATE_GAME: '@@user/UPDATE_GAME',
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
    return {
        type: UserActions.CONNECT,
        payload: {
            user,
        },
    };
};

export const setSelectedUser = (user) => {
    return {
        type: UserActions.SELECTED,
        payload: {
            user,
        },
    };
};

export const setOpponentInGame = (opponent) => {
    return {
        type: UserActions.ADD_OPPONENT,
        payload: {
            opponent,
        },
    };
};
