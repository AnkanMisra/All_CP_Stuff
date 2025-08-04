class Solution {
    public int maxBalancedShipments(int[] a) {
     int n=a.length;

        int pg[]=new int[n];
        int st[]=new int[n];
        int top=-1;

        for(int i=0;i<n;i++){
            while(top>=0 && a[st[top]]<=a[i]){
                top--;
            }
            pg[i]=(top>=0?st[top]:-1);
            st[++top]=i;
        }

        int count=0,lastend=-1;
        for(int r=1;r<n;r++){
            int l=pg[r];
            if(l>lastend){
                count++;
                lastend=r;
            }
        }

        return count;
    }
}
