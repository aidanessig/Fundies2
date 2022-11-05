import tester.*;

interface IBeverage{
  double discountPrice(double discount);
}

class Tea implements IBeverage{
  int temp;
  String color;
  double price;
  
  Tea(int temp, String color, double price){
    this.temp = temp;
    this.color = color;
    this.price = price;
  }
  
  /* TEMPLATE:
   * Fields:
   * ... this.temp ... -- integer
   * ... this.color ... -- String
   * ... this.price ... -- double
   * 
   * Methods:
   * ... this.discountPrice(double) ... -- double
   * 
   */
  
  public double discountPrice(double discount) {
    return ((100 - (discount * 2)) * this.price) / 100;
  }
}

class Coffee implements IBeverage{
  String name;
  double price;
  String origin;
  
  Coffee(String name, double price, String origin) {
    this.name = name;
    this.price = price;
    this.origin = origin;
  }
  
  /* TEMPLATE:
   * Fields:
   * ... this.name ... -- String
   * ... this.price ... -- double
   * ... this.origin ... -- String
   * 
   * Methods:
   * ... this.discountPrice(double) ... -- double
   * ... this.sameCoffee(Coffee) ... -- boolean
   * 
   * Methods for Fields:
   * 
   */
  
  // given a percent discount, compute the discounted price of this coffee
  // X is to price as (100 - discount) is to 100
  // X is (price * (100 - discount)) / 100
  public double discountPrice(double discount) {
    return ((100 - discount) * this.price) / 100;
  }
  
  // determine if that coffee is the same as this coffee
  boolean sameCoffee(Coffee that) {
    return this.name.equals(that.name) &&
        this.origin.equals(that.origin) &&
        this.price == that.price;
  }
  
  // determines if that IBeverage is cheaper than that IBeverage
  boolean cheaperThan(Coffee that, double discount) {
    return that.discountPrice(discount) <
        this.discountPrice(discount);
  }
}

class ExamplesCoffee{
  Coffee kona = new Coffee("Kona", 3.99, "Brazil");
  Coffee icedC = new Coffee("Iced Coffee", 4.59, "USA");
  IBeverage icedT = new Tea(0, "Black", 1.99);
  IBeverage konaIBev = new Coffee("Kona", 3.99, "Brazil");
  
  // constructor
  ExamplesCoffee(){}
  
  boolean testDiscountPrice(Tester t) {
    return t.checkExpect(this.kona.discountPrice(5.0), 3.7905) &&
           t.checkExpect(this.kona.discountPrice(10.0), 3.591);
  }
  
  boolean  testSameCoffee(Tester t) {
    return t.checkExpect(this.kona.sameCoffee(icedC), false);
  }
  
  boolean testCheaperThan(Tester t) {
    return t.checkExpect(this.kona.cheaperThan(icedC, 5.0), false);
  }
}

/*
class Blend implements IBeverage{
  IBeverage firstHalf;
  IBeverage secondHalf;
  
  Blend(IBeverage firstHalf, IBeverage secondHalf) {
    this.firstHalf = firstHalf;
    this.secondHalf = secondHalf;
  }
}*/
