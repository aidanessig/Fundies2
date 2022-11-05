// to represent a dog
class Dog {
  String name;
  String breed;
  int yob;
  String state;
  boolean hypoallergenic;
  
  // constructor
  Dog(String name, String breed, int yob, String state, boolean hypoallergenic) {
    this.name = name;
    this.breed = breed;
    this.yob = yob;
    this.state = state;
    this.hypoallergenic = hypoallergenic;
  }
}

// to represent examples of dogs
class ExamplesDog {
  Dog huffle = new Dog("Hufflepuff", "Wheaten Terrier", 2012, "TX", true);
  Dog pearl = new Dog("Pearl", "Labrador Retriever", 2016, "MA", false);
  Dog bailey = new Dog("Bailey", "Golden Retriever", 2003, "CT", false);
}