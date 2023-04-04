const Park = function (name, ticketPrice, dinosaurCollection) {
    this.name = name
    this.ticketPrice = ticketPrice
    this.dinosaurCollection = dinosaurCollection
}

Park.prototype.addDinosaur = function (dinosaur) {
    this.dinosaurCollection.push(dinosaur)
};

Park.prototype.removeDinosaur = function (dinosaur) {
    const indexOfDinosaur = this.dinosaurCollection.indexOf(dinosaur)
    this.dinosaurCollection.splice(indexOfDinosaur, 1)
};

Park.prototype.mostPopularAttraction = function () {
    let mostPopular = []
    for (dinosaur of this.dinosaurCollection) {
        mostPopular.push(dinosaur.guestsAttractedPerDay)
    }
    const index = mostPopular.indexOf(Math.max(...mostPopular))
    const mostPopularDinosaur = this.dinosaurCollection[index]
    return mostPopularDinosaur
}

module.exports = Park