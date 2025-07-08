class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int ele: arr){
            hm.put(ele, hm.getOrDefault(ele,0)+1);
        }
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        ArrayList<Integer> al = new ArrayList<>();
        int n = arr.length;
        for(int i=n-1;i>=0;i--){
            int curr = hm.get(arr[i]);
            while(stk.peek()!=-1 && hm.get(stk.peek())<=curr){
                stk.pop();
            }
            al.add(stk.peek());
            stk.push(arr[i]);
        }
        Collections.reverse(al);
        return al;
    }
}