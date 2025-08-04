class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n=landStartTime.length;
        int m=waterStartTime.length;

        int mlf=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int finish=landStartTime[i]+landDuration[i];
            if(finish<mlf){
                mlf=finish;
            }
        }
        int a=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            int t=Math.max(mlf,waterStartTime[j])+waterDuration[j];
            if(t<a){
                a=t;
            }
        }
        int mwf=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            int finish=waterStartTime[j]+waterDuration[j];
            if(finish<mwf){
                mwf=finish;
            }
        }
        int b=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int t=Math.max(mwf,landStartTime[i])+landDuration[i];
            if(t<b){
                b=t;
            }
        }
        return Math.min(a,b);

    }
}
