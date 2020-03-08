import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.*; 

public class RandomNumbers {
  public static void main(String[] args) {
    try {

    	Long a = new Long("9999999999"), b = new Long("99999999999");

    	Set<Long> set = new HashSet<Long>();
	   
	   	for(int i=0; i<1000; i++)   set.add( ThreadLocalRandom.current().nextLong(a,b));
            
        List<Long> aList = set.stream().collect(Collectors.toList()); 
            
        Collections.sort(aList);

      	FileWriter myWriter = new FileWriter("filename.txt");
      
      	for(int i=0; i<aList.size(); i++) {
      		String[] rowArr = ((aList.get(i))+"\n").split("");
      		String rowString = String.join(",",rowArr);
      		myWriter.write(rowString);
      }

      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}


//   String.format("%013d",aList.get(i))