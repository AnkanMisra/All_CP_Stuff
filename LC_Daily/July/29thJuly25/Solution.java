class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int[]latest = new int[32];
        Arrays.fill(latest,-1);

        for(int i = n - 1; i >= 0 ; i--){
            int farEle = i;

            for(int b = 0; b < 32 ; b++){
                if(((nums[i] >> b) & 1) != 0){
                    latest[b] = i;
                }

                if(latest[b] != -1){
                    farEle = Math.max(farEle,latest[b]);
                }
            }

            result[i] = farEle - i + 1;
        }

        return result;
    }
}
