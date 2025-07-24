class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxleft=Integer.MIN_VALUE;
        for(int i=0;i<left.length;i++)
        {
            maxleft=Math.max(maxleft,left[i]);
        }

        int minright=Integer.MAX_VALUE;
        for(int i=0;i<right.length;i++)
        {
            minright=Math.min(minright,right[i]);
        }

        int l=maxleft==Integer.MIN_VALUE?0:maxleft;
        int r=minright==Integer.MAX_VALUE?0:(n-minright);

        return Math.max(l,r);

    }
}
