/* this program will print fan pattern

input  : 
7
output : 
1 * * * * * * 7 6 5 4 3 2 1 
2 1 * * * * * 6 5 4 3 2 1 * 
3 2 1 * * * * 5 4 3 2 1 * * 
4 3 2 1 * * * 4 3 2 1 * * * 
5 4 3 2 1 * * 3 2 1 * * * * 
6 5 4 3 2 1 * 2 1 * * * * * 
7 6 5 4 3 2 1 1 * * * * * * 
* * * * * * 1 7 6 5 4 3 2 1 
* * * * * 2 1 * 6 5 4 3 2 1 
* * * * 3 2 1 * * 5 4 3 2 1 
* * * 4 3 2 1 * * * 4 3 2 1 
* * 5 4 3 2 1 * * * * 3 2 1 
* 6 5 4 3 2 1 * * * * * 2 1 
7 6 5 4 3 2 1 * * * * * * 1 

*/

import java.util.*;
public class Hello {
    public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt(), count=1, m=n;
		for(int i=1; i<=n; i++){
		    int temp=count++;
		    int temp1=m--;
		    for(int j=1; j<=n; j++){
		        if(j<=i) System.out.print((temp--)+" ");
		        else System.out.print("* ");
		    }
		    for(int j=n; j>0; j--){
		        if(j>=i) System.out.print((temp1--)+" ");
		        else System.out.print("* ");
		    }
		    System.out.println();
		}
		count=1;
		m=n;
		for(int i=1; i<=n; i++){
		    int temp1=count++;
		    int temp2=m--;
		    for(int j=1; j<=n; j++){
		        if(j>n-i) System.out.print((temp1--)+" ");
		        else System.out.print("* ");
		    }
		    
		    for(int j=1; j<=n; j++){
		        if(j>=i) System.out.print((temp2--)+" ");
		        else System.out.print("* ");
		    }
		    System.out.println();
		}
	}
}
