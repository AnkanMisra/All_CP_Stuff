class Solution {
    public int countPS(String s) {
        int n=s.length();
        int count=0;
        for(int c=0;c<n;c++){
            int l=c,r=c+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
             l=c-1;
             r=c+1;
            while(l>=0 && r<n &&s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}

