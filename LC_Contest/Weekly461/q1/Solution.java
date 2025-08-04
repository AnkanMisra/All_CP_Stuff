class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;

        boolean inc[]=new boolean[n];
        inc[0]=true;
        for(int i=1;i<n;i++){
            inc[i]=inc[i-1]&&nums[i-1]<nums[i];
        }

        boolean sufinc[]= new boolean[n];
        sufinc[n-1]=true;
        for(int i=n-2;i>=0;i--){
            sufinc[i]=nums[i]<nums[i+1]&&sufinc[i+1];
        }

        int decend[]=new int[n];
        decend[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                decend[i]=decend[i+1];
            }else{
                decend[i]=i;
            }
        }

        for(int p=1;p<n-1;p++){
            if(!inc[p]){
                continue;
            }
            int mex=Math.min(decend[p],n-2);
            for(int q=p+1;q<=mex;q++){
                if(sufinc[q]){
                    return true;
                }
            }
        }

        return false;
    }
}
