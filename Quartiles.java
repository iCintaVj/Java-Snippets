import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        double q1,median,q3;
        if( (n%2) != 0 ){
            median = arr[n/2];
        } else {
            median = ((double)arr[n/2] + (double)arr[(n/2) - 1]) / 2.0;
        }
        
        if( ((n/2)%2) != 0 ){
            q1 = arr [ ((n/2)/2) ];
            q3 = arr [ (n/2) + ((n/2)/2) ];
        } else {
            q1 = ((double)arr[((n/2)/2)] + (double)arr[((n/2)/2) - 1]) / 2.0;
            if( (n%2) == 0 )
                q3 = ((double)arr[(n/2) + ((n/2)/2)] + (double)arr[(n/2) + ((n/2)/2) - 1]) / 2.0;
            else
                q3 = ((double)arr[(n/2) + ((n/2)/2)] + (double)arr[(n/2) + ((n/2)/2) + 1]) / 2.0;
        }
        
        System.out.println((int)q1);
        System.out.println((int)median);
        System.out.println((int)q3);
    }
}

