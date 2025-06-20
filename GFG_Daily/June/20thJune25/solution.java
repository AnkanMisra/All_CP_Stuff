class Solution {
    public boolean validgroup(int[] arr, int k) {
        int n = arr.length;
        if (n % k != 0)
            return false;
        Map<Integer, Integer> count = new TreeMap<>();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int num : count.keySet()) {
            int freq = count.get(num);
            if (freq == 0)
                continue;
            for (int i = 0; i < k; i++) {
                int curr = num + i;
                if (count.getOrDefault(curr, 0) < freq)
                    return false;
                count.put(curr, count.get(curr) - freq);
            }
        }
        return true;
    }
}
