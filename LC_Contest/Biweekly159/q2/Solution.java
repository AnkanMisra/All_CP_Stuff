class Solution {
    public long maxArea(int[][] a) {
        int b=a.length;
        Map<Integer,int[]>c=new HashMap<>();
        Map<Integer,int[]>d=new HashMap<>();
        int e=Integer.MAX_VALUE,f=Integer.MIN_VALUE;
        int g=Integer.MAX_VALUE,h=Integer.MIN_VALUE;
        for(int i=0;i<b;i++){
            int j=a[i][0],k=a[i][1];
            c.computeIfAbsent(k,z->new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            int l[]=c.get(k);
            l[0]=Math.min(l[0],j);
            l[1]=Math.max(l[1],j);
            d.computeIfAbsent(j,z->new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            int m[]=d.get(j);
            m[0]=Math.min(m[0],k);
            m[1]=Math.max(m[1],k);
            e=Math.min(e,j);
            f=Math.max(f,j);
            g=Math.min(g,k);
            h=Math.max(h,k);
        }
        long n=0;
        for(Map.Entry<Integer,int[]>o:c.entrySet()){
            int p=o.getKey();
            int q[]=o.getValue();
            long r=(long)q[1]-q[0];
            long s=Math.max(h-p,p-g);
            if(r>0 && s>0){
                n=Math.max(n,r*s);
            }
        }
        for(Map.Entry<Integer,int[]> o:d.entrySet()){
            int p=o.getKey();
            int []q=o.getValue();
            long r=(long)q[1]-q[0];
            long s=Math.max(f-p,p-e);
            if(r>0 && s>0){
                n=Math.max(n,r*s);
            }
        }
    if(n==0){
        return -1;
    }
        return n;
    }
}