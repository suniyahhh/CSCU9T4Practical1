// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   
   // look up all entries of a given day and month
   public String lookupAll (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result += current.getEntry();
            }
       if (result.equals("")) {result = "No entries found";};
       return result;
   } // lookupAll
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
   // check if entry with same name+date and time has been added before
   public boolean checkDuplicate (String n, int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       boolean result = false;
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
        	  result = true;
        	  return result;
          }  
       }
       return result;
   } // checkDuplicate
   
   
   public String removeRec(String n, int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       Entry found = null;
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
        	  found = current;
        	  result = "Record successfully removed.";
          }
       }
       tr.remove(found);
       return result;

   }

   
} // TrainingRecord