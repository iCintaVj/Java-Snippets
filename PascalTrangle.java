//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr=new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        if(numRows==0){
            return arr;
        }
        if(numRows==1){
            currList.add(1);
            arr.add(currList);
            System.out.println(numRows+" "+currList);
            return arr;
        }
        arr=generate(numRows-1);
        List<Integer> prevList =arr.get(numRows-2);
        for(int i=0; i<numRows; i++){
            if(i==0 || i==numRows-1) currList.add(1);
            else{
                int a=i < prevList.size() ? prevList.get(i):1;
                int b=i-1 < prevList.size() ? prevList.get(i-1):1;
                currList.add(b+a);
            }
        }
        System.out.println(numRows+" "+currList);
        arr.add(currList);
        return arr;
    }
}
