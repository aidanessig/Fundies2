import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import tester.*;

class BackAndForthIterator<T> implements Iterator<T> {

  ArrayList<T> items;
  int leftIdx;
  int rightIdx;
  int checkNum;
  boolean direction;
  
  BackAndForthIterator(ArrayList<T> items) {
    this.items = items;
    leftIdx = 0;
    rightIdx = items.size() - 1;
    checkNum = 0;
    direction = true;
  }
  
  
  public boolean hasNext() {
    return checkNum < items.size();
  }

  public T next() {
    T answer;
    
    if (direction) {
      answer = items.get(this.leftIdx);
      this.leftIdx = this.leftIdx + 1;
      direction = false;
    } else {
      answer = items.get(this.rightIdx);
      this.rightIdx = this.rightIdx - 1;
      direction = true;
    }
    
    checkNum = checkNum + 1;
    
    return answer;
  }
  
}

class ExamplesIterator {
  ArrayList<String> listS = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f"));
  ArrayList<String> listSResult = new ArrayList<String>(Arrays.asList("a", "f", "b", "e", "c", "d"));
  
  ArrayList<Integer> listN = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
  ArrayList<Integer> listNResult = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 4, 3));
  
  ArrayList<String> twoElem = new ArrayList
  
  // tests the BackAndForthIteator class and methods
  public boolean testBackAndForthIterator(Tester t) {
    Iterator<String> testListS = new BackAndForthIterator<String>(listS);
    
    ArrayList<String> toCheckS = new ArrayList<String>();
    
    String toAddS;
    
    while(testListS.hasNext()) {
      toAddS = testListS.next();
      toCheckS.add(toAddS);
    }
    
    Iterator<Integer> testListN = new BackAndForthIterator<Integer>(listN);
    
    ArrayList<Integer> toCheckN = new ArrayList<Integer>();
    
    int toAddN;
    
    while(testListN.hasNext()) {
      toAddN = testListN.next();
      toCheckN.add(toAddN);
    }
    
    return t.checkExpect(toCheckS, listSResult) && t.checkExpect(toCheckN, listNResult);
  }
}