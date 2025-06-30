class Solution {
    public int findLHS(int[] nums) {
        int result=0;
        Arrays.sort(nums);
        int start=0,end=1;
        while(end<nums.length){
            if(nums[end]-1>nums[start]) start++;
            else if(nums[end]-1==nums[start]) {result=Math.max(result,end-start+1);end++;}
            else end++;
        }
        return result;
    }
}