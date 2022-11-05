import tester.*;

// represents a deli's menu
interface IDeliMenu {}

// to represent soup item
class Soup implements IDeliMenu{
  String name;
  int price;
  boolean vegetarian;
  
  Soup(String name, int price, boolean vegetarian){
    this.name = name;
    this.price = price;
    this.vegetarian = vegetarian;
  }
}

// to represent salad item
class Salad implements IDeliMenu{
  String name;
  int price;
  String dressing;
  boolean vegetarian;
  
  Salad(String name, int price, String dressing,boolean vegetarian){
    this.name = name; 
    this.price = price;
    this.dressing = dressing;
    this.vegetarian = vegetarian;
  }
}

// to represent sandwich item
class Sandwich implements IDeliMenu{
  String name;
  int price;
  String bread;
  String fillings;
  
  Sandwich(String name, int price, String bread, String fillings){
    this.name = name;
    this.price = price;
    this.bread = bread;
    this.fillings = fillings;
  }
}

// to represent deli orders
class ExamplesDeli {
  IDeliMenu soupChickenNoodle = new Soup("Chicken Noodle", 150, false);
  IDeliMenu soupTomato = new Soup("Tomato", 99, true);
  
  IDeliMenu saladCaesar = new Salad("Caesar", 250, "Caesar Dressing",true);
  IDeliMenu saladGreek = new Salad("Greek", 300, "Vinaigrette", true);
  
  IDeliMenu sandwichItalian = new Sandwich("Italian", 650, "Sub Roll", "Ham and Cheese");
  IDeliMenu sandwichPBJ = new Sandwich("PB & J", 399, "Wheat", "Peanut Butter and Jelly");
}







