class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> set = map.keySet();
        int temp = k;
        for(int key: set) {
            int freq = map.get(key);
            if(freq <= temp) {
                temp -= freq;
            } else if(freq > temp) {
                map.put(key, temp);
                temp -= freq;
            }
        }
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(map.get(nums[i]) > 0) {
                ans[j++] = nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }
        
        return ans;
    }
}
