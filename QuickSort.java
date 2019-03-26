import java.util.*;
class GFG{
	public static void main (String[] args){
	   Scanner sc = new Scanner(System.in);
	   int t=sc.nextInt();
	   while(t>0){
	       t--;
	       int n=sc.nextInt(),arr[]=new int[n];
	       for(int i=0; i<n; i++){
	           arr[i]=sc.nextInt();
	       }
	       sort(arr,0,n-1);
	       for(int i=0; i<n; i++){
	           System.out.print(arr[i]+" ");
	       }
	       System.out.println();
	       
	   }
	   
	 }
	 public static void sort(int[] arr, int start, int end){
	     if(start<end){
	         int pivot=partition(arr,start,end);
	         sort(arr,start,pivot-1);
	         sort(arr,pivot+1,end);
	     }
	 }
	 public static int partition(int[] arr, int start, int end){
	     int pivot=arr[end];
	     int pos=start-1;
	     for(int i=start; i<end; i++){
	         if(arr[i]<=pivot){
	            pos++;
	            int temp=arr[pos];
	            arr[pos]=arr[i];
	            arr[i]=temp;
	         }
	     }
	         int temp=arr[pos+1];
	         arr[pos+1]=arr[end];
	         arr[end]=temp;
	         return pos+1;
	 }
}
