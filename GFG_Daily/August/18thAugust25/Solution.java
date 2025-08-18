class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int idx = 0;

        while(idx < n && citations[n-1-idx] > idx){
            idx++;
        }
        return idx;
    }
}
