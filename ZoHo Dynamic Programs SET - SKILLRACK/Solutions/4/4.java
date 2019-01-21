import java.util.*;
import java.math.BigInteger;
class MatrixWaysCount  {
    public static void main(String[] args) {
        		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		System.out.print(count(n,m));
	}
	public static BigInteger count(int n,int m){
	    BigInteger[] arr=new BigInteger[m];
        	    Arrays.fill(arr,BigInteger.ZERO);
        	    arr[0]=BigInteger.ONE;
	    for(int i=0; i<n; i++){
	        for(int j=1; j<m; j++){
	            arr[j]=arr[j].add(arr[j-1]);
	        }
	    }
	    return arr[m-1];
	}
}