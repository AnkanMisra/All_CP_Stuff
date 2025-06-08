class Solution {
    public int maxSumDistinctTriplet(int[] a, int[] b) {
        Map<Integer, Integer> c= new HashMap<>();
        for(int i=0;i<a.length;i++){
            c.put(a[i],Math.max(c.getOrDefault(a[i],0),b[i]));
        }
        if(c.size()<3){
            return -1;
        }
        List<Integer> d= new ArrayList<>(c.values());
        Collections.sort(d,Collections.reverseOrder());
        return d.get(0)+d.get(1)+d.get(2);
    }
}
