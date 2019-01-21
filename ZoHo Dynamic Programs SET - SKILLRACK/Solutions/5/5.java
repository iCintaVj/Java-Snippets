import java.util.*;
import java.math.BigInteger;
public class Hello {
    public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt(),m=in.nextInt();
		int[][] arr=new int[n][m];
		for(int i=0; i<n; i++)
		    for(int j=0; j<m; j++)
		        arr[i][j]=in.nextInt();
		System.out.print(count(arr));
	}
	public static BigInteger count(int[][] arr){
	    if(arr[0][0]%2==0) return 0;
	    BigInteger[][] mat=new BigInteger[arr.length][arr[0].length];
	    
	    for(int i=0;i<arr.length;i++)
	        for(int j=0; j<arr[0].length;j++)
	            if(arr[i][j]%2!=0)  mat[i][j]=BigInteger.ONE;
	            else    mat[i][j]=BigInteger.ZERO;
	    for(int i=1; i<arr.length; i++)
	        for(int j=1; j<arr[0].length; j++)
	            if(arr[i][j]%2!=0){
	                mat[i][j]=mat[i][j-1].add(mat[i-1][j]);
	            }
	    return mat[arr.length-1][arr[0].length-1];         
	}
}