//Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> currList = new ArrayList<Integer>();
        if(rowIndex==0){
             currList.add(1);
             return currList;
        }
        if(rowIndex==1){
            currList.add(1);
            currList.add(1);
            return currList;
        }
        List<Integer> prevList =getRow(rowIndex-1);
        for(int i=0; i<rowIndex+1; i++){
            if(i==0 || i==rowIndex) currList.add(1);
            else{
                int a=i < prevList.size() ? prevList.get(i):1;
                int b=i-1 < prevList.size() ? prevList.get(i-1):1;
                currList.add(b+a);
            }
        }
        System.out.println(rowIndex+" "+currList);
        return currList;       
    }
}

