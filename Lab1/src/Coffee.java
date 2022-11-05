import tester.*;

class Coffee{
  String name;
  double price;
  String origin;
  
  Coffee(String name, double price, String origin) {
    this.name = name;
    this.price = price;
    this.origin = origin;
  }
}

class ExampleCoffee{
  Coffee kona = new Coffee("Kona", 5.99, "Brazil");
}
