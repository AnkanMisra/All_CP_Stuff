class Solution {
    public int minSwaps(int[] a) {
        int b = a.length;
        int[][] c = new int[b][3];
        for (int d=0;d<b;d++) {
            c[d][0] = sum(a[d]);
            c[d][1] = a[d];
            c[d][2] = d;
        }
        Arrays.sort(c,(x, y)->{
            if (x[0] != y[0]) {
                return x[0] - y[0];
            }
            else{
                return x[1] - y[1];    
            }
        });
        boolean[] e = new boolean[b];
        int f=0;
        for (int d=0;d<b;d++) {
            if (e[d]||c[d][2]==d){
                continue;  
            } 
            int g=d;
            int h=0;
            while (!e[g]){
                e[g]=true;
                g=c[g][2];
                h++;
            }
            f+=h-1;
        }
        return f;
    }
    public static int sum(int a) {
        int b=0;
        while(a!=0) {
            b+=a%10;
            a/=10;
        }
        return b;
    }
}
