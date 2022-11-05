import tester.Tester;
import java.util.ArrayList;
import java.util.Arrays;

class CollegeMajorInfo {
  String major; 
  int startYear;
  int endYear;

  // standard constructor 
  CollegeMajorInfo(String major, int startYear, int endYear) {
    this.major = major;
    this.startYear = startYear;
    this.endYear = endYear;
  }
  
  // compares this major to a list of a majors and returns the one in the list 
  // if they match and this major if they dont
  CollegeMajorInfo compare(ArrayList<CollegeMajorInfo> list) {
    for (CollegeMajorInfo c : list) {
      if (this.major.equals(c.major) && this.startYear == c.startYear && this.endYear == c.endYear) {
        return c;
      }
    }
    return this;
  }
}

class CollegeMajorDatabase {
  ArrayList<CollegeMajorInfo> list;
  
  // standard constructor
  CollegeMajorDatabase() {
    this.list = new ArrayList<CollegeMajorInfo>();
  }
  
  // adds the provide college major info to the database list
  void add(CollegeMajorInfo c) {
    this.list.add(c);
  }
  
  // determines whether the provided college major is in the database list
  boolean contains(CollegeMajorInfo c) {
    return this.list.contains(c.compare(this.list));
  }
}

class ExamplesCollegeMajorDatabase {
  CollegeMajorDatabase majorInfoDatabase = new CollegeMajorDatabase();
  
  
  CollegeMajorInfo c1 = new CollegeMajorInfo("CS",2019,2023);            
  CollegeMajorInfo c2 = new CollegeMajorInfo("CE",2020,2024);
  CollegeMajorInfo c3 = new CollegeMajorInfo("ME",2018,2022);            
  CollegeMajorInfo c4 = new CollegeMajorInfo("CHE",2021,2025);
  CollegeMajorInfo c1copy = new CollegeMajorInfo("CS", 2019, 2023);
  
  // tests the add method and contains method
  public boolean testAddAndContain(Tester t) {
    this.majorInfoDatabase.add(c1);
    this.majorInfoDatabase.add(c2);
    
    return t.checkExpect(this.majorInfoDatabase.contains(c1), true)
        && t.checkExpect(this.majorInfoDatabase.contains(c2), true)
        && t.checkExpect(this.majorInfoDatabase.contains(c3), false)
        && t.checkExpect(this.majorInfoDatabase.contains(c4), false)
        && t.checkExpect(this.majorInfoDatabase.contains(c1copy), true);
  }
}
