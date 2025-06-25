class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i : nums1)
        {
            lst.add(i);
        }
        for(int i : nums2)
        {
            lst.add(i);
        }
        Collections.sort(lst);

        double res = 0.0000;

        int len = lst.size();
        int n = nums1.length;
        int m = nums2.length;
        if(len%2 == 0)
        {
            res = (lst.get((len / 2) - 1) + lst.get(len / 2)) / 2.0000; 
        }
        else
        {
            res = lst.get(len / 2);
        }
        return res;
    }
}
