class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
     int n=landStartTime.length;
        int m=waterStartTime.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ls=landStartTime[i];
            int ld=landDuration[i];
            int finishLand=ls+ld;
            for(int j=0;j<m;j++){
                int w=waterStartTime[j];
                int d=waterDuration[j];
                int f1=Math.max(finishLand,w)+d;
                ans=Math.min(ans,f1);
                int fw=w+d;
                int f2=Math.max(fw,ls)+ld;
                ans=Math.min(ans,f2);
            }
        }
        return ans;
    }
}
