export const GameActions = {
    UPDATE_GAME: '@@game/UPDATE_GAME',
    END_GAME: '@@game/END_GAME',
};

export const updateGame = (
    user,
    adverseUser,
    cards,
    adverseCards,
    currentPoint,
    turnGameUserId
) => {
    return {
        type: GameActions.UPDATE_GAME,
        payload: {
            user,
            adverseUser,
            cards,
            adverseCards,
            currentPoint,
            turnGameUserId,
        },
    };
};

export const endGame = () => {
    return {
        type: GameActions.END_GAME,
        payload: {},
    };
};
