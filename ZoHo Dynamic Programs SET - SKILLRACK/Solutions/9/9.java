import java.util.*;
public class  MinJumpsToCross{
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=sc.nextInt();
		int t=minJumps(arr,n);
		System.out.print(t>n ? "-1":t);
	}
	public static int minJumps(int[] arr, int n){
	    int[] jumps=new int[n+1];
	    if(n==0 || arr[0]==0) return -1;
	    jumps[0]=0;
	    for(int i=1; i<n+1; i++){
	        jumps[i]=Integer.MAX_VALUE;
	        for(int j=0; j<i; j++){
	            if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE){
	                jumps[i]=Math.min(jumps[i],jumps[j]+1);
	            }
	        }
for(int k=0; k<n+1; k++) System.out.print(jumps[k]+" ");
System.out.println();
	    }
	    return jumps[n];
	}
}