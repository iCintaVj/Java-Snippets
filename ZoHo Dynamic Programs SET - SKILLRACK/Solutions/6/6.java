import java.util.*;
class IceCream{
    public static void main(String[] args) {
        ArrayList<Integer> arrList=new ArrayList<Integer>();
        Scanner in=new Scanner(System.in);
        int count=0,last;
        String[] a=in.nextLine().split(" ");
        int[] arr=new int[a.length];
        for(int i=0; i<arr.length; i++) arr[i]=Integer.parseInt(a[i]);
        last=arr[0];
        if(last==0) arrList.add(1);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==3){
                if(last==1) arr[i]=2;
                if(last==2) arr[i]=1;
            }
            if(arr[i]==last || arr[i]==0){ 
                arrList.add(1);
                last=0;
                continue;
            }
            last=arr[i];
        }
        System.out.print(arrList.size());
    }
}