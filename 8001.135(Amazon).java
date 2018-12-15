import java.util.*;
public class Hello {
    public static int Min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double n=sc.nextDouble();
        String s=""; s+=n;
        String sArr[]=s.split("\\.");
        char[] n1=sArr[0].toCharArray(),n2=sArr[1].toCharArray();
        String result="";
        result+=permutaion(sArr[0],0,(sArr[0].length()-1)) + ".";
        Min=Integer.MAX_VALUE;
        result+=permutaion(sArr[1],0,(sArr[1].length()-1));
        System.out.println(Double.parseDouble(result));
    }
    public static int permutaion(String str, int l, int r){   //permutaion
        if(l==r){
            int temp=Integer.parseInt(str);
            if(String.valueOf(temp).length()==str.length())
            if(Min>temp) Min=temp;
        }
        else{
            for(int i=l; i<=r; i++){
                str=swap(str,l,i);
                permutaion(str,l+1,r);
                str=swap(str,l,i);
            }
        }
        return Min;
    }
    public static String swap(String a,int i,int j){       
        char temp;
        char[] temArr=a.toCharArray();
        temp=temArr[i];
        temArr[i]=temArr[j];
        temArr[j]=temp;
        return String.valueOf(temArr);
    }
}
