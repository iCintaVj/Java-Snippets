import java.util.*;
public class Amazon_8001_final {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double n=sc.nextDouble();
        String s=""; s+=n;
        String sArr[]=s.split("\\.");
        char[] n1=sArr[0].toCharArray(),n2=sArr[1].toCharArray();
        Arrays.sort(n1); Arrays.sort(n2);
        if(n1[0]=='0'){
            int i=0;
            while(n1[i]=='0')   i++;
            char temp=n1[i];
            n1[i]='0';
            n1[0]=temp;
        }
        double min=Double.parseDouble(String.valueOf(n1)+"."+String.valueOf(n2));
        System.out.print(min);
    }
}
