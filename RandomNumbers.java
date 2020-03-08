/**
 * This programs creates a file and write random integers from 99999999999 to 9999999999999 with delimiter ','
 * 
 * We can use this as a data set for testing in machine learning algorithms such as Knn
 * 
 * each row will contain data as below
 * 
 * eg.    ->   1,2,3,4,5,6,7,8,9,0,1
 */



import java.io.FileWriter;   
import java.io.IOException;  
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
