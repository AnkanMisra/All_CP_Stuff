class FindSumPairs {
    int[] nums1;
    int[] nums2;

    HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();

    public FindSumPairs(int[] nums1, int[] nums2) {
         
        this.nums1 = nums1;
        this.nums2 = nums2;

        for(int i : nums1)
        {
            map1.put(i,map1.getOrDefault(i,0)+1);
        }
        for(int i : nums2)
        {
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
    }
    
    public void add(int index, int val) {

        map2.put(nums2[index],map2.get(nums2[index])-1);
        nums2[index] +=val;
        map2.put(nums2[index],map2.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {

        int cc=0;
        for(int i : map1.keySet())
        {
            if(map2.containsKey(tot-i))
            {
                cc += map1.get(i) * map2.get(tot-i);
            }
        }

        return cc;
        
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */