class Solution {
    public int substrCount(String s, int k) {
        int count=0;
        int len=s.length();
        for(int i=0;i<=len-k;i++)
        {
            Set<Character> ans=new HashSet<>();   
            for(int j=i;j<k+i;j++)
            {
                ans.add(s.charAt(j));
            }
            if(ans.size()==k-1)
            {
                count++;
            }
        }
        return count;
    }
}