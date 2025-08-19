class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0,continuity=0;
        for(int i:nums)
        {
            if(i==0)
            {
                continuity++;
                ans=ans+continuity;
            }
            else
            {
                continuity=0;
            }
        }
        return ans;
    }
}
