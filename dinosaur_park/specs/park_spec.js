const assert = require('assert');
const Park = require('../models/park.js');
const Dinosaur = require('../models/dinosaur.js');

describe('Park', function() {
  let park
  let dinosaur1
  let dinosaur2

  beforeEach(function () {
    dinosaur1 = new Dinosaur('t-rex', 'carnivore', 50)
    dinosaur2 = new Dinosaur('triceratops', 'herbivore', 40)
    dinosaur3 = new Dinosaur('ankylosaurus', 'herbivore', 30)
    park = new Park("Jurrasic Park", 20, [dinosaur1, dinosaur2])
  })

  // declare all dinosaurs here so their scope is thru whole doc

  it('should have a name', function () {
    const actual = park.name
    assert.strictEqual(actual, "Jurrasic Park")
  });
  
  it('should have a ticket price', function () {
    const actual = park.ticketPrice
    assert.strictEqual(actual, 20)
  });
  
  it('should have a collection of dinosaurs', function () {
    const actual = park.dinosaurCollection
    assert.deepStrictEqual(actual, [dinosaur1, dinosaur2])
  });

  it('should be able to add a dinosaur to its collection', function () {
    park.addDinosaur(dinosaur3)
    const actual = park.dinosaurCollection.length
    assert.strictEqual(actual, 3)
  });

  it('should be able to remove a dinosaur from its collection', function () {
    park.removeDinosaur(dinosaur1)
    const actual = park.dinosaurCollection.length
    assert.strictEqual(actual, 1)
  });
// alternative:  const actual = park.dinosaurs;
    // assert.deepStrictEqual(actual, [trex1]);

  it('should be able to find the dinosaur that attracts the most visitors', function () {
    const actual = park.mostPopularAttraction(park.name)
    assert.deepStrictEqual(actual, dinosaur1)
  });


  it('should be able to find all dinosaurs of a particular species');
    // const actual = park.findDinosaurBySpecies(dinosaur1)
    // assert.deepStrictEqual(actual, [0])

  // in dinosaur collection, find dinosaur based on species, so if
// we are looking for t-rex we'd get dinosaur 1 or index 0

  it('should be able to calculate the total number of visitors per day');
  const actual = park.countDailyVisitors()
  assert.strictEqual(actual, 120)



  it('should be able to calculate the total number of visitors per year');
    
// multiply daily visitor number by 365 (ignore holidays/irl schedule)

  it('should be able to calculate total revenue for one year');


  // multiply yearly visitor number by park ticket price
});

