export const ChatActions = {
    CHAT_MESSAGE: '@@game/CHAT_MESSAGE',
};

export const addChatMessage = (message) => {
    return {
        type: ChatActions.CHAT_MESSAGE,
        payload: message,
    };
};