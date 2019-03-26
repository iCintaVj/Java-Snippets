/*

Given a chess board having  cells, you need to place N queens on the board in such a way that no queen attacks any other queen.

Input:
The only line of input consists of a single integer denoting N.

Output:
If it is possible to place all the N queens in such a way that no queen attacks another queen, then print "YES" (without quotes) in first line, then print N lines having N integers. The integer in  line and  column will denote the cell  of the board and should be 1 if a queen is placed at  otherwise 0. If there are more than way of placing queens print any of them.

If it is not possible to place all N queens in the desired way, then print "NO" (without quotes).

Constraints:
1<= N <=10

*/



import java.util.*;

class TestClass {
    public static void main(String args[] ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), arr[][] = new int[n][n];
        if(n<4){
            System.out.print((n==1) ? "YES":"NO");
            return;
        }
        System.out.println(NQ(arr,n) ? "YES":"NO");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean NQ(int[][] arr,int n){
        if(n==0)    return true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isSafe(arr,i,j,n)){
                    arr[i][j]=1;
                }
                if(NQ(arr,n-1)){
                    return true;
                }
                arr[i][j]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] arr, int i, int j, int n){
        if(i-1>-1 && j-1>-1 && arr[i-1][j-1]!=1)   return true;
        if(i-1>-1 && arr[i-1][j]!=1)   return true;
        if(i-1>-1 && j+1<n && arr[i-1][j+1]!=1)   return true;
        if(j-1>-1 && arr[i][j-1]!=1)   return true;
        if(j+1<n && arr[i][j+1]!=1)   return true;
        if(i+1<n && j-1>-1 && arr[i+1][j-1]!=1)   return true;
        if(i+1<n && arr[i+1][j]!=1)   return true;
        if(i+1<n && j+1<n && arr[i+1][j+1]!=1)   return true;
        return false;
    }
}
