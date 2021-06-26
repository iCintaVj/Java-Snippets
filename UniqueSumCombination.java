import java.util.*;

public class UniqueSumCombination {
    public static void main(String args[]) {
        int[] arr = {1,1,2,5,6,7,10};
        int sum = 8;
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        findCombinations(0,arr,0,sum,tempResult,result);
        System.out.println(result);
    }
    
    private static void findCombinations(int currIndex,int[] arr, int currSum, int actualSum, ArrayList<Integer> tempResult, ArrayList<ArrayList<Integer>> result) {
        if(actualSum == currSum) {
            result.add(new ArrayList<Integer>(tempResult));
            return;
        }
        
        for(int i=currIndex; i<arr.length; i++) {
            if(currSum+arr[i] > actualSum){
                break;
            }
                
            if(i>currIndex && arr[i-1] == arr[i]){
                continue;
            }
                
            tempResult.add(arr[i]);
            
            findCombinations(i+1,arr,arr[i]+currSum,actualSum,tempResult,result);
            
            tempResult.remove(tempResult.size()-1);
        }
        
    }
}
