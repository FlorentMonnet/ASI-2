const utils = require('../model/utils');
class Game {
    cardsUsers = [];

    constructor(user1, user2, cardsUser1, cardsUser2) {
        this.users = [user1, user2];
        this.cardsUsers[user1.id] = utils.initListCard(cardsUser1);
        this.cardsUsers[user2.id] = utils.initListCard(cardsUser2);
        this.indexAttaquant = Math.floor(Math.random() * 100) % 2;
        this.currentAttanquantEnergyPoint = 100;
        // console.log(' ======= Game ======= ');
        // console.log(this.users);
        // console.log(this.cardsUsers);
        // console.log(this.indexAttaquant);

        // console.log(' ======= Cards ======= ');
        // console.log(this.cardsUsers[user1.id]);
        // console.log(this.cardsUsers[user2.id]);

        // console.log(' ======= End Game ======= ');
    }

    attackUser(attack, callback, callbackEndGame) {
        console.log(
            "Attaque de l'utilisateur " +
                this.getTurnUser().name +
                " sur la carte de l'utilisateur " +
                this.getDefenseUser().name
        );
        //Recuper les cards attanquant et defense
        var attackCard = this.cardsUsers[this.getTurnUser().id][attack.card.id];
        var defenseCard =
            this.cardsUsers[this.getDefenseUser().id][attack.attackedCard.id];

        if (attackCard && defenseCard) {
            //Execution de l'attaque
            this.currentAttanquantEnergyPoint -= attackCard.energy;
            defenseCard.hp -= attackCard.attack;

            //Suppresion de la carte si elle est détruite
            if (defenseCard.hp <= 0) {
                console.log('La carte à été détruite !');
                this.cardsUsers[this.getDefenseUser().id].splice(
                    defenseCard.id,
                    1
                );
            }

            // Change turn verification
            if (this.currentAttanquantEnergyPoint <= 0) {
                console.log('Change turn');
                this.changeTurn();
            }

            console.log(this.cardsUsers[this.getDefenseUser().id]);
            const cardsDefenseurRestante = this.cardsUsers[
                this.getDefenseUser().id
            ].filter((c) => c !== null);
            if (cardsDefenseurRestante.length === 0) {
                console.log('Partie terminé');
                //finish game
                const end = {
                    users: this.users,
                    winnerUserId: this.getTurnUser().id,
                };

                callbackEndGame(end);
            } else {
                //update affichage
                const update = {
                    users: this.users,
                    cardsUsers: this.cardsUsers,
                    currentAttanquantEnergyPoint:
                        this.currentAttanquantEnergyPoint,
                    currentUserTurn: this.getTurnUser().id,
                };

                callback(update);
            }
        } else {
            console.error(defenseCard);
            console.error(attackCard);
            console.error('Les cartes ne sont pas reconnue');
        }
    }

    changeTurn() {
        this.currentAttanquantEnergyPoint = 100;
        if (this.indexAttaquant) {
            this.indexAttaquant = 0;
        } else {
            this.indexAttaquant = 1;
        }
    }

    getTurnUser() {
        return this.users[this.indexAttaquant];
    }

    getDefenseUser() {
        if (this.indexAttaquant) {
            return this.users[0];
        } else {
            return this.users[1];
        }
    }
    getInitConfig(callback) {
        const init = {
            users: this.users,
            cardsUsers: this.cardsUsers,
            currentAttanquantEnergyPoint: this.currentAttanquantEnergyPoint,
            currentUserTurn: this.getTurnUser().id,
        };
        callback(init);
    }
}

module.exports = Game;
