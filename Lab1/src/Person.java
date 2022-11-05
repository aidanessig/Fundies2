import tester.*;

// to represent an ancestor tree
interface IAT {}

// to represent an unknown person
class Unknown implements IAT{
  Unknown(){}
}

// to represent a person's ancestor tree
class PersonIAT implements IAT{
  Person p1;
  IAT mom;
  IAT dad;
  
  PersonIAT(Person p1, IAT mom, IAT dad){
    this.p1 = p1;
    this.mom = mom;
    this.dad =dad;
  }
}

// to represent a person
class Person{
  String name;
  int age;
  String gender;
  Address place;
  
  Person(String name, int age, String gender, Address place){
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.place = place;
  }
}

// to represent a person's address
class Address{
  String city;
  String state; 
  
  Address(String city, String state){
    this.city = city;
    this.state = state;
  }
}

// to represent people
class ExamplesPerson{
  ExamplesPerson(){}
  
  Address atim = new Address("Boston", "MA");
  Address akate = new Address("Warwick", "RI");
  Address arebecca = new Address("Nashua", "NH");
  
  Person tim = new Person("Tim", 23, "Male", atim);
  Person kate = new Person("Kate", 22, "Female", akate);
  Person rebecca = new Person("Rebecca", 31, "Non-binary", arebecca);
  
  IAT unknown = new Unknown();
  
  IAT itim = new PersonIAT(tim, unknown, unknown);
  IAT ikate = new PersonIAT(kate, unknown, unknown);
  IAT irebecca = new PersonIAT(rebecca, ikate, itim);
}