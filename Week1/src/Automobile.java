import tester.*;

// information about an automobile
class Automobile{
  String model;
  int price;
  double mileage;
  boolean used;
  
  Automobile(String model, int price, double mileage, boolean used){
    this.model = model;
    this.price = price;
    this.mileage = mileage;
    this.used = used;
  }
}

class ExamplesAutomobile{
  Automobile Miata = new Automobile("Mazda Miata", 7500, 19.2, true);
  Automobile GLC = new Automobile("Mercedes GLC", 14500, 23.4, true);
}