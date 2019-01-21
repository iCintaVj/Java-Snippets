import java.util.*;
class MaxSumArr {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),arr[]=new int[n],max=0,sum=0;
        for(int i=0; i<n; i++) {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int tempSum=Integer.MIN_VALUE;
                for(int k=i; k<=j; k++)  tempSum+= arr[k];
                if(tempSum>=max) max=tempSum;
	  System.out.println(tempSum);
            }

        }
        System.out.print(max);
    }
}