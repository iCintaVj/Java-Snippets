//this program is to find the sum of consecutive elements in the array recursively untile single sum is obtained
import java.util.*;
public class Hello {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), arr[]=new int[n];
		for(int i=0; i<n; i++)  arr[i]=sc.nextInt();
		arr=sum(arr);
		System.out.print(arr[0]+" ");
	}
	public static int[] sum(int[] arr){
	    if(arr.length==1)   return arr;
	    int[] temp=new int[arr.length-1];
	    for(int i=0; i+1<arr.length; i++){
	        temp[i]=arr[i]+arr[i+1];
	    }
	    return sum(temp);
	}
}
