import java.util.*;
class StairCaseCombinationCount{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.print(count(arr,m));
    }
    public static int count(int s[], int m) {
        int[] stairs=new int[m+1];
        stairs[0]=1;
        for(int i=0; i<s.length; i++){
            for(int j=s[i]; j<=m; j++){
                stairs[j]+=stairs[j-s[i]];
            }
        }
        return stairs[m];
    }
}