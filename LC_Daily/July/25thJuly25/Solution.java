class Solution {
    public int maxSum(int[] nums) {
       int max=Integer.MIN_VALUE;
       Set<Integer>set=new HashSet<>();
       for(int c :nums){
        if(c>0){
            set.add(c);
        }
        else{
            max=Math.max(max,c);
        }
       }
       if(set.size()==0)return max;
       int sum=0;
       for(int i:set){
        sum+=i;
       }
       return sum;
    }
}
