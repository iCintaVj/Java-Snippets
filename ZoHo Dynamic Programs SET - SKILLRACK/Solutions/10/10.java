import java.util.*;
public class MinTrianglePath {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),l=0;
		sc.nextLine();
		int[][] arr=new int[n][n];
		for(int i=0; i<n; i++)  {
		    for(int j=0; j<n-i; j++) {
		            arr[i][j]=sc.nextInt();
		    }
		    sc.nextLine();
		}
        System.out.print(sum(arr));
    }   
    public static int sum(int[][] arr){
        int l=0,n=arr[0].length;
        int[] result=arr[0];
        for(int i=1; i<n; i++){
            for(int j=0; j<n-1; j++){
                result[j]=arr[i][j]+Math.min(result[j],result[j+1]);
            }
        }
        return result[0];
    }
}