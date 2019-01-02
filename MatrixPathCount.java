//this program will print all the possible paths from top left element to bottom right element in MxN
import java.util.ArrayList;
import java.util.List;
import java.util.*;
class MatrixPathCount    {
	// Function to print the route taken
	public static void printPath(List<Integer> path, int last)  {
		for (int i : path) {
			System.out.print(i + " - ");
		}
		System.out.println(last);
	} 
	public static void findPaths(int[][] mat, List<Integer> path, int i, int j) {    
		int M = mat.length;
		int N = mat[0].length;
		// if we have reached the last cell, print the route
		if (i == M - 1 && j == N - 1) {
            printPath(path, mat[i][j]);
			return;
		}
		// include current cell in path
        path.add(mat[i][j]);
		// move right
		if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) {
			findPaths(mat, path, i, j + 1);
		}
		// move down
		if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) {
			findPaths(mat, path, i + 1, j);
        }
		// remove current cell from path
		path.remove(path.size() - 1);
	}
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                mat[i][j]=sc.nextInt();
		List<Integer> path = new ArrayList<Integer>();
        findPaths(mat, path, 0, 0);
	}
}
