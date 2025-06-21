class Solution {
    public int minSwaps(int[] a) {
        int b=a.length;
        List<Integer>c=new ArrayList<>();
        for(int d=0;d<b;d++){
            if((a[d]&1)==0){
                c.add(d);
            }
        }
        int e=c.size();
        int f=b-e;
        if(Math.abs(e-f)>1){
            return -1;
        }
        long g=Long.MAX_VALUE;
        if(e>=f){
            g=Math.min(g,fun(c,0,b));             
        }
        if(f>=e){
            g=Math.min(g,fun(c,1,b));             
        }
        if(g==Long.MAX_VALUE){
            return -1;
        }
        return (int)g;
    }
    private long fun(List<Integer>a,int b,int c){
        long d=0;
        int e=0;
        for(int f=b;f<c;f+=2){
            d+=Math.abs(a.get(e++)-f);
        }
        return d;
    }
}