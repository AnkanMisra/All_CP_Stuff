class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int val : basket1) freq.put(val, freq.getOrDefault(val, 0) + 1);
        for (int val : basket2) freq.put(val, freq.getOrDefault(val, 0) + 1);
        for (int cnt : freq.values()) if ((cnt & 1) == 1) return -1;

        ArrayList<Integer> extra1 = new ArrayList<>();
        ArrayList<Integer> extra2 = new ArrayList<>();

        HashMap<Integer, Integer> count1 = new HashMap<>();
        for (int val : basket1) count1.put(val, count1.getOrDefault(val, 0) + 1);
        HashMap<Integer, Integer> count2 = new HashMap<>();
        for (int val : basket2) count2.put(val, count2.getOrDefault(val, 0) + 1);

        int globalMin = Integer.MAX_VALUE;
        for (int val : basket1) globalMin = Math.min(globalMin, val);
        for (int val : basket2) globalMin = Math.min(globalMin, val);

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey();
            int total = e.getValue();
            int targetEach = total / 2;
            int c1 = count1.getOrDefault(val, 0);
            int c2 = count2.getOrDefault(val, 0);
            if (c1 > targetEach) {
                int times = c1 - targetEach;
                for (int i = 0; i < times; i++) extra1.add(val);
            } else if (c2 > targetEach) {
                int times = c2 - targetEach;
                for (int i = 0; i < times; i++) extra2.add(val);
            }
        }

        if (extra1.isEmpty()) return 0;

        Collections.sort(extra1);
        Collections.sort(extra2, Collections.reverseOrder());

        long cost = 0;
        for (int i = 0; i < extra1.size(); i++) {
            int a = extra1.get(i);
            int b = extra2.get(i);
            cost += Math.min(Math.min(a, b), 2L * globalMin);
        }
        return cost;
    }
}
