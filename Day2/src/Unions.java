import tester.*;

interface IStation{
  
}

// to represent a subway station
class TStop implements IStation{
  String name;
  String line;
  double price;
  
  TStop(String name, String line, double price){
    this.name = name;
    this.line = line;
    this.price = price;
  }
}

// to represent a stop on commuter line
class CommuterStation implements IStation{
  String name;
  String line; 
  boolean express;
  
  CommuterStation(String name, String line, boolean express){
    this.name = name;
    this.line = line;
    this.express = express;
  }
}

class ExamplesIStation{
  ExamplesIStation(){}
  
  IStation harvard = new TStop("Harvard", "red line", 1.25);
  
  IStation backbay = new CommuterStation("Back Bay", "Framingham", true);
}