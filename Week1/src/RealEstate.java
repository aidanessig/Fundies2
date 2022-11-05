import tester.*;

class House{
  String kind;
  int rooms;
  Address a;
  int price;
  
  House(String kind, int rooms, Address a, int price){
    this.kind = kind;
    this.rooms = rooms;
    this.a = a;
    this.price = price;
  }
}

class Address{
  int number;
  String street;
  String city;
  
  Address(int number, String street, String city){
    this.number = number;
    this.street = street;
    this.city = city;
  }
}

class ExamplesRealEstate{
  Address a1 = new Address(23, "Maple Street", "Brookline");
  Address a2 = new Address(5, "Joye Road", "Newton");
  Address a3 = new Address(83, "Winslow Road", "Waltham");
  
  House h1 = new House("Ranch", 7, a1, 375000);
  House h2 = new House("Colonial", 9, a2, 450000);
  House h3 = new House("Cape", 6, a3, 235000);
}


