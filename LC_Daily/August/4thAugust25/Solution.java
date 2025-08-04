class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int l=0,r=0,len=0;
        while(r<fruits.length)
        {
            if(mp.containsKey(fruits[r]))
                mp.put(fruits[r],mp.get(fruits[r])+1);
            else
                mp.put(fruits[r],1);
            while(mp.size()>2)
            {
                mp.put(fruits[l],mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0)
                    mp.remove(fruits[l]);

                l++;
            }
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}
