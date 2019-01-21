import java.util.*;
public class MaxGain {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),gain=0,month=1;
		int[] arr=new int[n];
		start=0;end=n-1;
		for(int i=0; i<n; i++) arr[i]=sc.nextInt();
		for(int i=0; i<n; i++){
		    int start=0,end=n-1;
		    while(arr[start]==-1)    start++;
		    while(arr[end]==-1)  end--;
		    if(arr[start]*month <= arr[end]*month) {
		        gain+=arr[start]* month;
				arr[start]=-1;
				start++;
		    }
		    else{
		        gain+=arr[end]*month;
				arr[end]=-1;
				end--;
		    }
		    month++;
		}
		System.out.println(gain);
	}
}