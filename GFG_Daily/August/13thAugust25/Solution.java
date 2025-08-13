class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int required = (n + 1) / 2;

        int luckyCount = 0;
        List<Integer> costs = new ArrayList<>();


        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                luckyCount++;
            } else {
                costs.add((k - soldiers % k) % k);
            }
        }

         if (luckyCount >= required) {
            return 0;
        }
         Collections.sort(costs);
        int totalCost = 0;
        int needed = required - luckyCount;
        for (int i = 0; i < needed; i++) {
            totalCost += costs.get(i);
        }

        return totalCost;
    }
}
