

import java.util.ArrayList;
import tester.Tester;

// Represents a single essay
class Essay {
  String text;

  // starts with some content
  Essay(String text) {
    this.text = text;
  }

  // make an essay have the same text as a given essay
  Essay(Essay other) {
    this.text = other.text;
  }

  // starts with a blank page
  Essay() {
    this("");
  }
 
  // adds to the content of the essay
  // EFFECT: the essay contents have the supplied
  // string appended
  void addContent(String s) {
    this.text = this.text + s;
  }
  
  // combines two essays into one
  Essay combineTwo(Essay s) {
    return new Essay(this.text + s.text);
  }
}


// Represents an essay with the facility to save versions and revert to them
class IncrementalEssay {
  ArrayList<Essay> versions; // version(s) of the essay
  
  IncrementalEssay() {
    this.versions = new ArrayList<Essay>();
    // the default first draft of the essay
    this.versions.add(new Essay());
  }

  // Return the latest version of the essay
  Essay latestVersion() {
    // the last entry in the list is always the latest version
    return this.versions.get(this.versions.size()-1);
  }

  // EFFECT: appends the supplied string to the current essay draft
  void addToCurrentText(String content) {
    versions.get(versions.size()-1).addContent(content);
  }

  // EFFECT: archives the current draft as a new version
  //         that can be retrieved later
  void backup() {
    this.versions.add(this.latestVersion());
  }

  // EFFECT: revert to the most recently
  //         backed up version; nothing should happen 
  //         if there is only one version
  void restore() {
    if (this.versions.size() > 1) {
      this.versions.set(this.versions.size() - 1, new Essay (this.versions.get(this.versions.size() - 2)));
    } 
  }
}


class Examples {
  Essay e1;
  Essay e2;
  Essay e3;
  Essay e4;
  
  IncrementalEssay list;

  void initData() {
    e1 = new Essay("hello");
    e2 = new Essay("hello goodbye");
    e3 = new Essay("hello goodbye!");
    e4 = new Essay(" hello again!");
    
    list = new IncrementalEssay();
  }
  
  // creating a draft, backing it up, starting a new draft,
  // backing it up, starting a new draft, and the restoring
  // then checking to see if backup is functioning
  public boolean tester(Tester t) {
    this.initData();
    list.addToCurrentText("hello");
    list.backup();
    list.addToCurrentText(" goodbye");
    list.backup();
    list.addToCurrentText("!");
    list.backup();
    list.addToCurrentText(" hello again!");
    list.restore();
    Essay newRestore = list.latestVersion();
    return t.checkExpect(newRestore, e3);
  }
}

