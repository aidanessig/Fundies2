// to represent an ice cream
interface IIceCream {}

// to represent an empty serving
class EmptyServing implements IIceCream {
  boolean cone;
  
  // constructor
  EmptyServing(boolean cone) {
    this.cone = cone;
  }
}

// to represent a scoop of ice cream
class Scooped implements IIceCream {
  IIceCream more;
  String flavor;
  
  // constructor
  Scooped(IIceCream more, String flavor) {
    this.more = more;
    this.flavor = flavor;
  }
}


// to represent examples of ice cream
class ExamplesIceCream {
  
  // constructor
  ExamplesIceCream() {}
  
  IIceCream cone = new EmptyServing(true);
  IIceCream cup = new EmptyServing(false);
  
  IIceCream mintchip = new Scooped(cup, "mint chip");
  IIceCream coffee = new Scooped(mintchip, "coffee");
  IIceCream blackraspberry = new Scooped(coffee, "black raspberry");
  IIceCream order1 = new Scooped(blackraspberry, "caramel swirl");
  
  
  IIceCream chocolate = new Scooped(cone, "chocolate");
  IIceCream vanilla = new Scooped(chocolate, "vanilla");
  IIceCream order2 = new Scooped(vanilla, "strawberry");
}