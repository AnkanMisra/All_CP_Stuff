class Solution {
    public String triangleType(int[] nums) {
        if(nums[0] >= nums[1] + nums[2] || nums[1] >= nums[0] + nums[2] || nums[2] >= nums[0] + nums[1]){
            return "none";
        }
        if(nums[0]==nums[1] && nums[1]==nums[2] && nums[2]==nums[0]){
            return "equilateral";
        }
        else if(nums[0]!=nums[1] && nums[1]!=nums[2] && nums[2]!=nums[0]){
            return "scalene";
        }
        return "isosceles";
    }
}