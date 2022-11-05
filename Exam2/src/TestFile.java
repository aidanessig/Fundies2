import tester.*;

class testPerson {
  int age;
  String name;
  
  testPerson(int age, String name) {
    this.age = age;
    this.name = name;
  }
  
  int ageAddedFive() {
    return this.age + 5;
  }
}

class ExamplesTestFile {
  testPerson person1 = new testPerson(5, "bob");
  testPerson person2 = new testPerson(20, "sam");
  
  public boolean testAgeAddedFive(Tester t) {
    return t.checkExpect(person1.ageAddedFive(), 10)
        && t.checkExpect(person2.ageAddedFive(), 25);
  }
}