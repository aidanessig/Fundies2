import tester.*;

// to represent a list of Strings
interface ILoString {
  // combine all Strings in this list into one
  String combine();

  // sorts all Strings in this list alphabetically
  ILoString sort();

  // helper function for sort method that functions as insert
  ILoString sortHelper(String input);

  // checks if a lists is in alphabetical order
  boolean isSorted();

  // helper function for the isSorted() method
  boolean isSortedHelper(String check);

  // returns a list of with alternative Strings from each lists
  ILoString interleave(ILoString that);

  // returns a list containing Strings only seen in each list
  ILoString merge(ILoString that);

  // determines if that is before first in this
  boolean mergeHelper(String that);

  // reverses a list of Strings
  ILoString reverse();

  // helper function for reverse method
  ILoString reverseHelper(String that);

  // determines if the lists is made of pairs
  boolean isDoubledList();

  // helper function for isDoubledList
  boolean isDoubledListHelper(String test);

  // determines if a list is a palindrome
  boolean isPalindromeList();
}

// to represent an empty list of Strings
class MtLoString implements ILoString {
  MtLoString() {
  }

  /*- TEMPLATE
   * Fields:
   * 
   * Methods:
   * ... this.combine() ... -- String
   * ... this.sort() ... -- ILoString
   * ... this.sortHelper(String) ... -- ILoString
   * ... this.isSorted() ... -- boolean
   * ... this.isSortedHelper(String) ... -- boolean
   * ... this.interleave(ILoString) ... -- ILoString
   * ... this.merge(ILoString) ... -- ILoString
   * ... this.mergeHelper(String) ... -- boolean
   * ... this.reverse() ... -- ILoString
   * ... this.reverseHelper(String) ... -- ILoString
   * ... this.isDoubledList() ... -- boolean
   * ... this.isDoubledListHelper(String) ... -- boolean
   * ... this.isPalindromeList() ... -- boolean
   * 
   * 
   * Methods for Fields:
   * 
   */

  // combine all Strings in this list into one
  public String combine() {
    return "";
  }

  // sorts all Strings in this list alphabetically
  public ILoString sort() {
    return this;
  }

  // helper function for sort method that functions as insert
  public ILoString sortHelper(String input) {
    return new ConsLoString(input, this);
  }

  // checks if a lists is in alphabetical order
  public boolean isSorted() {
    return true;
  }

  // helper function for the isSorted() method
  public boolean isSortedHelper(String check) {
    return true;
  }

  // returns a list of with alternative Strings from each lists
  public ILoString interleave(ILoString that) {
    return that;
  }

  // returns a list containing Strings only seen in each list
  public ILoString merge(ILoString that) {
    return that;
  }

  // determines if that is before first in this
  public boolean mergeHelper(String that) {
    return true;
  }

  // reverses a list of Strings
  public ILoString reverse() {
    return new MtLoString();
  }

  // helper function for the reverse method
  public ILoString reverseHelper(String that) {
    return new ConsLoString(that, this);
  }

  // determines if the lists is made of pairs
  public boolean isDoubledList() {
    return true;
  }

  // helper function for isDoubledList
  public boolean isDoubledListHelper(String that) {
    return false;
  }

  // determines if a list is a palindrome
  public boolean isPalindromeList() {
    return true;
  }
}

// to represent a nonempty list of Strings
class ConsLoString implements ILoString {
  String first;
  ILoString rest;

  // combine all Strings in this list into one
  ConsLoString(String first, ILoString rest) {
    this.first = first;
    this.rest = rest;
  }

  /*-
   TEMPLATE
   Fields:
   ... this.first ... -- String
   ... this.rest ... -- ILoString
   
   Methods:
   ... this.combine() ... -- String
   ... this.sort() ... -- String
   ... this.sortHelper(String) -- ILoString
   ... this.isSorted() ... -- boolean
   ... this.isSortedHelper(String) -- boolean
   ... this.interleave(ILoString) -- ILoString
   ... this.merge(ILoString) -- ILoString
   ... this.mergeHelper(String) -- boolean
   ... this.reverse() ... -- ILoString
   ... this.reverseHelper(String) ... -- ILoString
   ... this.isDoubledList() ... -- boolean
   ... this.isDoubledListHelper(String) ... -- boolean
   ... this.isPalindromeList() ... -- boolean
   
   Methods for Fields:
   ... this.first.concat(String) ... -- String
   ... this.first.compareTo(String) ... -- int
   ... this.rest.combine() ... -- String
   ... this.rest.sort() ... -- ILoString
   ... this.rest.sortHelper(String) ... -- ILoString
   ... this.rest.isSorted() ... -- boolean
   ... this.rest.isSortedHelper(String) ... -- boolean
   ... this.rest.interleave(ILoString) ... -- ILoString
   ... this.rest.merge(ILoString) ... -- ILoString
   ... this.rest.mergeHelper(String) ... -- boolean
   ... this.rest.reverse() ... -- ILoString
   ... this.rest.reverseHelper(String) ... -- ILoString
   ... this.rest.isDoubledList() ... -- boolean
   ... this.rest.isDoubledListHelper(String) ... -- boolean
   ... this.rest.isPalindromeList() ... -- boolean
   */

  // combine all Strings in this list into one
  public String combine() {
    return this.first.concat(this.rest.combine());
  }

  // sorts all Strings in this list alphabetically
  public ILoString sort() {
    return this.rest.sort().sortHelper(this.first);
  }

  // helper function for sort method that functions as insert
  public ILoString sortHelper(String input) {
    if (this.first.compareToIgnoreCase(input) < 0) {
      return new ConsLoString(this.first, this.rest.sortHelper(input));
    }
    else {
      return new ConsLoString(input, this);
    }
  }

  // checks if a lists is in alphabetical order
  public boolean isSorted() {
    return this.rest.isSortedHelper(this.first);
  }

  // helper function for the isSorted() method
  public boolean isSortedHelper(String test) {
    if (test.compareToIgnoreCase(this.first) <= 0) {
      return this.isSorted();
    }
    else {
      return false;
    }
  }

  // returns a list of with alternative Strings from each lists
  public ILoString interleave(ILoString that) {
    return new ConsLoString(this.first, that.interleave(this.rest));
  }

  // returns a list containing Strings only seen in each list
  public ILoString merge(ILoString that) {
    if (that.mergeHelper(this.first)) {
      return new ConsLoString(this.first, that.merge(this.rest));
    }
    else {
      return that.merge(this);
    }
  }

  // determines if that is before first in this
  public boolean mergeHelper(String that) {
    return that.compareToIgnoreCase(this.first) <= 0;
  }

  // reverses a list of strings
  public ILoString reverse() {
    return this.rest.reverse().reverseHelper(this.first);
  }

  // helper function for the reverse method
  public ILoString reverseHelper(String that) {
    return new ConsLoString(this.first, this.rest.reverseHelper(that));
  }

  // determines if the lists is made of pairs
  public boolean isDoubledList() {
    return this.rest.isDoubledListHelper(this.first);
  }

  // helper function for isDoubledList
  public boolean isDoubledListHelper(String that) {
    return this.first.equals(that) && this.rest.isDoubledList();
  }

  // determines if a list is a palindrome
  public boolean isPalindromeList() {
    return this.interleave(this.reverse()).isDoubledList();
  }

}

// to represent examples for lists of strings
class ExamplesStrings {

  ILoString mary = new ConsLoString("Mary ", new ConsLoString("had ", new ConsLoString("a ",
      new ConsLoString("little ", new ConsLoString("lamb.", new MtLoString())))));

  ILoString alphabetUnsorted = new ConsLoString("d", new ConsLoString("e",
      new ConsLoString("a", new ConsLoString("c", new ConsLoString("b", new MtLoString())))));

  ILoString beeMovie = new ConsLoString("The ", new ConsLoString("bee, ",
      new ConsLoString("of course, ", new ConsLoString("flies anyways.", new MtLoString()))));

  ILoString shortList1 = new ConsLoString("a",
      new ConsLoString("c", new ConsLoString("e", new MtLoString())));

  ILoString shortList2 = new ConsLoString("b", new ConsLoString("d", new MtLoString()));

  ILoString shortList3 = new ConsLoString("a",
      new ConsLoString("b", new ConsLoString("f", new MtLoString())));

  ILoString doubleList = new ConsLoString("a",
      new ConsLoString("a", new ConsLoString("b", new ConsLoString("b", new MtLoString()))));

  ILoString notDoubleList = new ConsLoString("a", new ConsLoString("a",
      new ConsLoString("b", new ConsLoString("b", new ConsLoString("z", new MtLoString())))));

  ILoString palindrome = new ConsLoString("a", new ConsLoString("b",
      new ConsLoString("c", new ConsLoString("b", new ConsLoString("a", new MtLoString())))));

  // test the method combine for the lists of Strings
  boolean testCombine(Tester t) {
    return t.checkExpect(this.mary.combine(), "Mary had a little lamb.")
        && t.checkExpect(this.alphabetUnsorted.combine(), "deacb")
        && t.checkExpect(this.beeMovie.combine(), "The bee, of course, flies anyways.");
  }

  // test the method sort for the lists of Strings
  boolean testSort(Tester t) {
    return t.checkExpect(this.alphabetUnsorted.sort(), new ConsLoString("a",
        new ConsLoString("b",
            new ConsLoString("c", new ConsLoString("d", new ConsLoString("e", new MtLoString()))))))
        && t.checkExpect(this.mary.sort(),
            new ConsLoString("a ", new ConsLoString("had ", new ConsLoString("lamb.",
                new ConsLoString("little ", new ConsLoString("Mary ", new MtLoString()))))));
  }

  // test the method sortHelper
  boolean testSortHelper(Tester t) {
    return t.checkExpect(this.beeMovie.sortHelper("Zebra"),
        new ConsLoString("The ", new ConsLoString("bee, ",
            new ConsLoString("of course, ",
                new ConsLoString("flies anyways.", new ConsLoString("Zebra", new MtLoString()))))))
        && t.checkExpect(this.mary.sortHelper("alpha"), new ConsLoString("alpha", mary));
  }

  // test the method isSorted
  boolean testIsSorted(Tester t) {
    return t.checkExpect(this.alphabetUnsorted.isSorted(), false)
        && t.checkExpect(this.mary.isSorted(), false)
        && t.checkExpect((new ConsLoString("A",
            new ConsLoString("B",
                new ConsLoString("C",
                    new ConsLoString("d", new ConsLoString("z", new MtLoString()))))).isSorted()),
            true);
  }

  // test the method isSortedHelper
  boolean testIsSortedHelper(Tester t) {
    return t.checkExpect(this.alphabetUnsorted.isSortedHelper("a"), false)
        && t.checkExpect(this.beeMovie.isSortedHelper("Zed Leppelin"), false);
  }

  // tests the interleave method
  boolean testInterleave(Tester t) {
    return t.checkExpect(this.shortList1.interleave(shortList2), new ConsLoString("a",
        new ConsLoString("b",
            new ConsLoString("c", new ConsLoString("d", new ConsLoString("e", new MtLoString()))))))
        && t.checkExpect(this.shortList2.interleave(shortList1),
            new ConsLoString("b", new ConsLoString("a", new ConsLoString("d",
                new ConsLoString("c", new ConsLoString("e", new MtLoString()))))));
  }

  // tests the merge method
  boolean testMerge(Tester t) {
    return t.checkExpect(this.shortList2.merge(shortList3), new ConsLoString("a",
        new ConsLoString("b",
            new ConsLoString("b", new ConsLoString("d", new ConsLoString("f", new MtLoString()))))))
        && t.checkExpect(this.shortList1.merge(shortList2),
            new ConsLoString("a", new ConsLoString("b", new ConsLoString("c",
                new ConsLoString("d", new ConsLoString("e", new MtLoString()))))));

  }

  // tests the mergeHelper method
  boolean testMergeHelper(Tester t) {
    return t.checkExpect(this.mary.mergeHelper("apple"), true)
        && t.checkExpect(this.beeMovie.mergeHelper("warrior"), false);
  }

  // tests the reverse method
  boolean testReverse(Tester t) {
    return t.checkExpect(this.shortList1.reverse(),
        new ConsLoString("e", new ConsLoString("c", new ConsLoString("a", new MtLoString()))))
        && t.checkExpect(this.alphabetUnsorted.reverse(),
            new ConsLoString("b", new ConsLoString("c", new ConsLoString("a",
                new ConsLoString("e", new ConsLoString("d", new MtLoString()))))));
  }

  // tests the reverseHelper method
  boolean testReverseHelper(Tester t) {
    return t
        .checkExpect(this.mary.reverseHelper("hello"),
            new ConsLoString("Mary ",
                new ConsLoString("had ", new ConsLoString("a ",
                    new ConsLoString("little ",
                        new ConsLoString("lamb.", new ConsLoString("hello", new MtLoString())))))))
        && t.checkExpect(this.beeMovie.reverseHelper("buzz"),
            new ConsLoString("The ", new ConsLoString("bee, ", new ConsLoString("of course, ",
                new ConsLoString("flies anyways.", new ConsLoString("buzz", new MtLoString()))))));
  }

  // tests the isDoubledList method
  boolean testIsDoubledList(Tester t) {
    return t.checkExpect(this.mary.isDoubledList(), false)
        && t.checkExpect(this.doubleList.isDoubledList(), true)
        && t.checkExpect(this.notDoubleList.isDoubledList(), false);
  }

  // tests the isDoubledListHelper method
  boolean testIsDoubledListHelper(Tester t) {
    return t.checkExpect(this.doubleList.isDoubledListHelper("test"), false)
        && t.checkExpect(this.shortList1.isDoubledListHelper("hello"), false);
  }

  // tests the isPalindromeList method
  boolean testIsPalindromeList(Tester t) {
    return t.checkExpect(this.palindrome.isPalindromeList(), true)
        && t.checkExpect(this.mary.isPalindromeList(), false);
  }
}