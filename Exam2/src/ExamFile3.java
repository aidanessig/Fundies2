import tester.*;
import java.util.*;

class DuplicateUtils {
  void removeDuplicates(ArrayList<String> list) {
    int i,j;
    
    for (i=0;i<list.size();i=i+1) {
      for (j=i+1;j<list.size();j=j+1) {
        if (list.get(j).equals(list.get(i))) {
          list.remove(j);
        }
      }
    }
  }
  
  // correctly removes duplicates from an arraylist
  void removeDuplicatesCorrect(ArrayList<String> list) {
    int i,j;
    
    for (i=0;i<list.size();i=i+1) {
      for (j=i+1;j<list.size();j=j+1) {
        if (list.get(j).equals(list.get(i))) {
          list.remove(j);
          j = j - 1;
        }
      }
    }
  }
  
}

class ExamplesDuplicates {
  ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("b", "b", "b", "a"));
  ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("b", "a"));
  ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("a", "c", "c", "c", "c"));
  ArrayList<String> list4 = new ArrayList<String>(Arrays.asList("a", "c"));
  ArrayList<String> list5 = new ArrayList<String>(Arrays.asList("a", "a", "a", "a"));
  ArrayList<String> list6 = new ArrayList<String>(Arrays.asList("a"));
  
  DuplicateUtils util = new DuplicateUtils();
  
  // tests the remove duplicates INCORRECT method
//  public boolean testDuplicateUtils(Tester t) {
//    util.removeDuplicates(list1);
//    util.removeDuplicates(list3);
//    return t.checkExpect(list1, list2)
//        && t.checkExpect(list3, list4);
//  }
  
  // tests the remove duplicates CORRECT method
  public boolean testRemoveDuplicatesCorrect(Tester t) {
    util.removeDuplicatesCorrect(list1);
    util.removeDuplicatesCorrect(list3);
    util.removeDuplicatesCorrect(list5);
    return t.checkExpect(list1, list2) && t.checkExpect(list3, list4)
        && t.checkExpect(list5, list6);
  }
}

