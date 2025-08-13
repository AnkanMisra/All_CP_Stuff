class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int ans = Integer.MAX_VALUE;
        for (int mins = 0; mins <= 99; mins++) {
            int secs = targetSeconds - mins * 60;
            if (secs < 0 || secs > 99) continue;
            String mm = String.format("%02d", mins);
            String ss = String.format("%02d", secs);
            String full = mm + ss;
            int idx = 0;
            while (idx < 3 && full.charAt(idx) == '0') idx++;
            String digits = full.substring(idx);
            int cost = calcCost(digits, startAt, moveCost, pushCost);
            ans = Math.min(ans, cost);
        }
        return ans;
    }

    private int calcCost(String digits, int startAt, int moveCost, int pushCost) {
        int cost = 0;
        int finger = startAt;
        for (char ch : digits.toCharArray()) {
            int d = ch - '0';
            if (finger != d) {
                cost += moveCost;
                finger = d;
            }
            cost += pushCost;
        }
        return cost;
    }
}
