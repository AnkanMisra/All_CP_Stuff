class Solution {
    public long splitArray(int[] nums) {
        int n=nums.length;
        boolean p[]=new boolean[n];
        if(n>2){
            Arrays.fill(p,2,n,true);
            for(int i=2;(long)i*i<n;i++){
                if(p[i]){
                    for(int j=i*i;j<n;j+=i){
                        p[j]=false;
                    }
                }
            }
        }
        long a=0,b=0;
        for(int i=0;i<n;i++){
            if(i>=2 && p[i]){
                a+=nums[i];
            }else{
                b+=nums[i];
            }
        }
        return Math.abs(a-b);
    }
}