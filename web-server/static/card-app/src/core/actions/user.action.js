export const UserActions = {
    CONNECT: '@@user/CONNECT',
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
