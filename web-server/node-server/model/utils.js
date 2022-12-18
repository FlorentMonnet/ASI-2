function addZero(i) {
    if (i < 10) {
        i = '0' + i;
    }
    return i;
}

module.exports = {
    getRoomName: () => {
        const d = new Date();
        let h = addZero(d.getHours());
        let m = addZero(d.getMinutes());
        let s = addZero(d.getSeconds());
        let roomName = 'roo-' + h + '-' + m + '-' + s;
        return roomName;
    },
    initListCard: (cards) => {
        let tabCards = [];
        cards.map((card) => {
            tabCards[card.id] = card;
        });
        return tabCards;
    },
};
