import tester.*;

interface IAT{
   
}

class Unknown implements IAT{
  Unknown(){}
}

class Person implements IAT{
  String name;
  IAT mom;
  IAT dad;
  
  Person(String name, IAT mom, IAT dad){
    this.name = name;
    this.mom = dad;
    this.dad = dad;
  }
}

class ExamplesIAT{
  ExamplesIAT(){}
  
  IAT unknown = new Unknown();
  
  IAT mary = new Person("Mary", this.unknown, this.unknown);
  IAT robert = new Person("robert", this.unknown, this.unknown);
  IAT john = new Person("John", this.unknown, this.unknown);
  
  IAT jane = new Person("Jane", this.mary, this.robert);
  IAT dan = new Person("Dan", this.jane, this.john);
}