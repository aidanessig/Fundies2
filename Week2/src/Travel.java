// to represent a place for players to stay
interface IHousing {}

// to represent a type of transportation
interface ITransportation {}

// to represent a hut housing
class Hut implements IHousing {
  int capacity;
  int population;
  
  Hut(int capacity, int population) {
    this.capacity = capacity;
    this.population = population;
  }
}

// to represent an inn housing
class Inn implements IHousing {
  String name;
  int capacity;
  int population;
  int stalls;
  
  Inn(String name, int capacity, int population, int stalls) {
    this.name = name; 
    this.capacity = capacity;
    this.population = population;
    this.stalls = stalls;
  }
}

// to represent a castle housing
class Castle implements IHousing {
  String name;
  String familyName;
  int population;
  int carriageHouse;
  
  Castle(String name, String familyName, int population, int carriageHouse) {
    this.name = name;
    this.familyName = familyName;
    this.population = population;
    this.carriageHouse = carriageHouse;
  }
}

// to represent a horse transportation
class Horse implements ITransportation {
  IHousing from;
  IHousing to;
  String name;
  String color;
  
  Horse(IHousing from, IHousing to, String name, String color) {
    this.from = from;
    this.to = to;
    this.name = name;
    this.color = color;
  }
}

// to represent a carriage transportation
class Carriage implements ITransportation {
  IHousing from;
  IHousing to; 
  int tonnage;
  
  Carriage(IHousing from, IHousing to, int tonnage) {
    this.from = from; 
    this.to = to; 
    this.tonnage = tonnage;
  }
}

// to represent travel examples
class ExamplesTravel {
  IHousing hovel = new Hut(5,1);
  IHousing winterfell = new Castle("Winterfell", "Stark", 500, 6);
  IHousing crossroads = new Inn("Inn At The Crossroads", 40, 20, 12);
  IHousing steast = new Hut(10, 5);
  IHousing westvillagez = new Castle("West Village Z", "NUin Mars", 1000, 6);
  IHousing isec13 = new Inn("ISEC 13", 100, 50, 10);
  
  ITransportation horse1 = new Horse(crossroads, steast, "Paws", "White");
  ITransportation horse2 = new Horse(hovel, westvillagez, "Sammy", "Green");
  ITransportation carriage1 = new Carriage(winterfell, crossroads, 2);
  ITransportation carriage2 = new Carriage(westvillagez, isec13, 4);
}

