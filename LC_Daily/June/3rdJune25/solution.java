class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> lockedBoxes = new HashSet();
        Queue<Integer> queue = new LinkedList();
        for (int init : initialBoxes) {
            if (status[init] == 1) {
                queue.offer(init);
            } else {
                lockedBoxes.add(init);
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int box = queue.poll();
            res += candies[box];
            for (int key : keys[box]) {
                status[key] = 1;
                // key unlocks box
                if (lockedBoxes.contains(key)) {
                    lockedBoxes.remove(key);
                    queue.offer(key);
                }
            }
            for (int newBox : containedBoxes[box]) {
                if (status[newBox] == 0) {
                    lockedBoxes.add(newBox);
                } else {
                    queue.offer(newBox);
                }
            }
        }

        return res;
    }
}
