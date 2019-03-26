/*
Matt loves Graph Theory. He recently enrolled into the Algorithms course and started liking it too. His teacher understood his love for graphs and decided to give him a problem.

She gives him a Tree and asks him to write a program to find if it's connected or not. She realizes that Matt would do this in no time. So, instead she gives him a Graph and then removes a vertex from it and now asks him to find if the resultant graph is connected or not.

Since he is new to programming and algorithms, you have to help him solve this problem.

Input
First line contains a single integer N denoting the number of vertices in the graph. Second line contains a single integer k denoting the number of edges in the graph. k lines follow each containing two space separated integers a and b denoting the edge between the vertices a and b. Then, the last line contains a single integer x which denotes the vertex that is removed from the graph.

Output
"Connected" (without quotes) if the resultant graph is connected. "Not Connected" (without quotes), otherwise.

Constraints
1 ≤ N ≤ 105
1 ≤ k ≤ 2×105
0 ≤ a,b ≤ 105
0 ≤ x ≤ 105

SAMPLE INPUT 
4
3
3 0
0 1
1 2
2
SAMPLE OUTPUT 
Connected
Explanation
Number of vertices: 4 
Number of edges: 3

enter image description here
https://he-s3.s3.amazonaws.com/media/uploads/16235f2.png
It is still Connected.
*/


import java.util.*;
class Connected {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] arr=new int[e][2];
        for(int i=0; i<e; i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        int x=sc.nextInt();
        for(int i=0; i<e; i++){
            if(arr[i][0]==x)    arr[i][0]=-1;
            if(arr[i][1]==x)    arr[i][1]=-1;
        }
        System.out.print(fun(arr,v) ? "Connected":"Not Connected");
    }
    public static boolean fun(int[][] arr,int v){
        for(int i=0; i<arr.length; i++){
            if(arr[i][0]==-1) arr[i][1]=-1;
            if(arr[i][1]==-1) arr[i][0]=-1;
        }
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0; i<arr.length; i++){
            if(arr[i][0]!=-1) set.add(arr[i][0]);
            if(arr[i][1]!=-1) set.add(arr[i][1]);
        }
        if(set.size()<v-1)    return false;
        return true;
    }
}
