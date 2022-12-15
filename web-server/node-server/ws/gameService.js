const { Config } = require('../config');
const socketServerUtil = require('../model/socketServer');
const utils = require('../model/utils');
const Game = require('../model/game');

const socketServer = socketServerUtil.getServer();

let userOnWaitingList = [];
let roomsCreated = [];
let gamesCreated = [];
let userCards = [];

const connection = (socket) => {
    const addOnWaitingList = (data) => {
        data = JSON.parse(data);
        user = data.user;
        cards = data.cards;
        userCards[user.id] = cards;
        if (userOnWaitingList.length === 0) {
            console.log('User is added to waiting list');

            userOnWaitingList.push(user);
            //Création de la room
            let roomName = utils.getRoomName();
            roomsCreated[user.id] = roomName;
            socket.join(roomName);
            console.log('Creating room ' + roomName);
        } else {
            console.log('Opponent mode : ');
            let opponent = userOnWaitingList.shift();
            // Join opponent room
            let opponentRoom = roomsCreated[opponent.id];
            console.log('Joined room ' + opponentRoom);
            socket.join(opponentRoom);
            // Le serveur envoie dans la room partager avec l'opposant l'utilisateur actuel
            socket
                .to(opponentRoom)
                .emit(Config.SOCKET_EVENT.OPPONENT_FOUND, user);
            socket.emit(Config.SOCKET_EVENT.ROOM_JOINED, opponentRoom);
            //Le serveur envoie a l'utilisateur sont opposant
            socket.emit(Config.SOCKET_EVENT.OPPONENT_FOUND, opponent);

            //Create game
            let game = new Game(
                opponent,
                user,
                userCards[opponent.id],
                userCards[user.id]
            );
            gamesCreated[opponentRoom] = game;

            game.getInitConfig(updateGame);
        }
    };

    const updateGame = (update) => {
        var roomName = roomsCreated[update.users[0].id]
            ? roomsCreated[update.users[0].id]
            : roomsCreated[update.users[1].id];

        socket
            .to(roomName)
            .emit(Config.SOCKET_EVENT.UPDATE_GAME, JSON.stringify(update));
        socket.emit(Config.SOCKET_EVENT.UPDATE_GAME, JSON.stringify(update));
    };

    const endGame = (end) => {
        var roomIndex = roomsCreated[end.users[0].id]
            ? end.users[0].id
            : end.users[1].id;

        var roomName = roomsCreated[roomIndex];

        // Suppression des valeurs
        roomsCreated.splice(roomIndex, 1);
        userCards.splice(end.users[0].id, 1);
        userCards.splice(end.users[1].id, 1);
        delete gamesCreated[roomName];
        console.log('Element supprimer');

        socket
            .to(roomName)
            .emit(Config.SOCKET_EVENT.END_GAME, JSON.stringify(end));
        socket.emit(Config.SOCKET_EVENT.END_GAME, JSON.stringify(end));
    };

    const attack = (attackParam) => {
        //Recuperation de la room && la game
        var roomName = roomsCreated[attackParam.user.id]
            ? roomsCreated[attackParam.user.id]
            : roomsCreated[attackParam.opponent.id];
        var game = gamesCreated[roomName];

        game.attackUser(attackParam, updateGame, endGame);
    };

    socket.on(Config.SOCKET_EVENT.ADD_WAITING_LIST, addOnWaitingList);
    socket.on(Config.SOCKET_EVENT.GAME_ATTACK, attack);
};

socketServer.on(Config.SOCKET_EVENT.CONNECT, connection);
