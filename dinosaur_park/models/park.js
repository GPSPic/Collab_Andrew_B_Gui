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

// alternative (much simpler)
// Park.prototype.findMostAttractiveDinosaur = function () {
//     let mostAttractiveDino = this.dinosaurs[0];
  
//     for (const dino of this.dinosaurs) {
//       if (dino.guestsAttractedPerDay > mostAttractiveDino.guestsAttractedPerDay) {
//         mostAttractiveDino = dino;
//       }
//     }
  
//     return mostAttractiveDino;
//   }


Park.prototype.countDailyVisitors = function () {
    let dailyVisitors = 0;

    for (const dino of this.dinosaurCollection) {
        dailyVisitors += dino.guestsAttractedPerDay;
    }

    return dailyVisitors;
}
// Park.prototype.findDinosaurBySpecies = 
//     function (dinosaurCollection, dinosaur) {
      


Park.prototype.numberOfDinosaursByDiet = function () {
    const numberOfDinosaursByDiet = {};
  
    for (const dinosaur of this.dinosaurs) {
      if (numberOfDinosaursByDiet[dinosaur.diet]) {
        numberOfDinosaursByDiet[dinosaur.diet] += 1;
      }
      else {
        numberOfDinosaursByDiet[dinosaur.diet] = 1;
      }
    }
  //(dinosaur.diet = key, value = 1)
  //  while looping through list, if example of dinosaur diet
  //  occurs then add 1 to total
  // else set total to 1 (so first time it loops will go to else)
  
    return numberOfDinosaursByDiet;
  }



module.exports = Park

