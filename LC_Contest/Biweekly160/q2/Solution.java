class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        if(m<=0 || n<=0){
            return 0L;
        }
        long a[]=new long[n];
        Arrays.fill(a,Long.MAX_VALUE/4);
        a[0]=0L;
        for(int b=0;b<m;b++){
            for(int c=0;c<n;c++){
                if(b==0 && c==0){
                    continue;
                }
                long d=b>0?a[c]:Long.MAX_VALUE/4;
                long e=c>0?a[c-1]:Long.MAX_VALUE/4;
                long f=Math.min(d,e);
                long g=1L*(b+1)*(c+1);
                long h;
                if(b==m-1&& c==n-1){
                    h=g;
                }
                else{
                    h=g+waitCost[b][c];
                }
                a[c]=f+h;
            }
        }
        return a[n-1]+1;
    }
}