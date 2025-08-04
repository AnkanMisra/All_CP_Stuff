class Solution {
    public int minTime(String s, int[] order, int k) {
        int n=s.length();
        long totalsub=(long)n*(n+1)/2;
        int low=0,high=n-1,ans=-1;
        while(low<=high){
            int mid=(low+high)>>>1;
            if(isActive(mid,order,n,totalsub,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
    return ans;
    }
    public boolean isActive(int t,int order[],int n,long totalsub,int k){

        boolean star[]=new boolean[n];
        for(int i=0;i<=t;i++){
            star[order[i]]=true;
        }

        long sumstar=0;
        long runlen=0;
        for(int i=0;i<n;i++){
            if(!star[i]){
                runlen++;
            }else{
                    sumstar+=runlen*(runlen+1)/2;
                    runlen=0;
            }
        }
        sumstar+=runlen*(runlen+1)/2;

        long valid=totalsub-sumstar;
        if(valid>=k){
            return true;
        }
        return false;
    }
}
