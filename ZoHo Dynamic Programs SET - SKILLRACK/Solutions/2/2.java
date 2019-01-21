import java.util.*;
class LongestSubString{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int max=0;
        String s1=sc.next(),s2=sc.next();
        for(int i=0; i<s1.length(); i++){
            int count=0; int temp=i;
            for(int j=0; j<s2.length() && temp<s1.length(); j++){
                if(s1.charAt(temp) == s2.charAt(j)) {
                    temp++;
                    count++;
                }
                else j=s2.length();
            }
            if(max<count) max=count;
        }
        System.out.print(max);
    }
}