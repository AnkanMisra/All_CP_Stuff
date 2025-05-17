class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
          int  eqq=(A*val*val)+(B*val)+C;
            list.add(eqq);
        }
        Collections.sort(list);
        return list;
    }
}