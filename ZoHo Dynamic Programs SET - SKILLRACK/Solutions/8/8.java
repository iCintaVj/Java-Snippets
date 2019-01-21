import java.util.*;
public class MinimumTimeinTwoAssemblyLine {
    public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);  
	    int n=sc.nextInt(),time=0,changed=0;
	    int[] a=new int[n];
	    int[] b=new int[n];
	    int[] c=new int[n];
	    for(int i=0; i<n; i++) a[i]=sc.nextInt();
	    sc.nextLine();
	    for(int i=0; i<n; i++) b[i]=sc.nextInt();
	    sc.nextLine();
	    for(int i=0; i<n; i++) c[i]=sc.nextInt();
	    sc.nextLine();
	    for(int i=0; i<n; i++)  {
	        int min=0,flag=0;
	        if(a[i]<b[i]){
	            min=a[i];
	            flag=1;
	        }
	        else if(a[i]>b[i]){
	            min=b[i];
	            flag=2;
	        }
	        else if(a[i]==b[i]){
	            if(changed==1){
	                min=a[i];
	                flag=1;
	            }
	            else if(changed==2){
	                min=b[i];
	                flag=2;
	            }
	            else if(changed==0){
	                min=a[i];
	                flag=1;
	            }
	        }
	        if( i != 0 ){
	            if(flag != changed ){
	                min+=c[i];
	            }
	        }
	        else if(i==0){
	            min+=c[0];
	        }
	        changed=flag;
	        time+=min;
	    }
	    System.out.print(time);
	}
}   