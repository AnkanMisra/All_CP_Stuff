class Solution {
    public int minRemoval(int[] nums, int k) {
     int n=nums.length;
        Arrays.sort(nums);
        int mw=1;
        int r=0;
        for(int i=0;i<n;i++){
            while(r+1<n&&(long)nums[r+1]<=(long)nums[i]*k){
                r++;
            }
            mw=Math.max(mw,r-i+1);
        }
        return n-mw;
    }
}
