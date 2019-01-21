import java.util.*;
public class IsPossible {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int n=sc.nextInt(),flag=0;
		sc.nextLine();
		int[] arr=new int[130];
		for(int i=0; i<n; i++){
		    String copy=s;
		    String temp=sc.nextLine();
		    for(int j=0; j<temp.length(); j++){
		        if( ! copy.contains(String.valueOf(temp.charAt(j)))){
		            System.out.print("No");
		            return;
		        }
		        else{
		            String t=String.valueOf(temp.charAt(j));
		            copy=copy.replaceFirst(t,"");
		        }
		    }
		}
		System.out.print("Yes");
	}
}