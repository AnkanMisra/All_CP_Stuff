class Solution {
    public String concatHex36(int a) {
        long b=1L*a*a;
        long c=b*a;
        String d=toBase(b,16);
        String e=toBase(c,36);
        return d+e;
    }
    public String toBase(long a,int b){
        if(a==0){
            return "0";
        }
        String c="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder d=new StringBuilder();
        long e=a;
        while(e>0){
            int f=(int)(e%b);
            d.append(c.charAt(f));
            e/=b;
        }
        return d.reverse().toString();
    }
}