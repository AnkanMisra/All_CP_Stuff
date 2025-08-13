import java.util.*;

class RandomizedCollection {
    private final List<Integer> nums;
    private final Map<Integer, Set<Integer>> idxMap;
    private final Random rand;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        rand = new Random();
    }
    public boolean insert(int val) {
        boolean isNew = !idxMap.containsKey(val) || idxMap.get(val).isEmpty();
        idxMap.computeIfAbsent(val, k -> new HashSet<>()).add(nums.size());
        nums.add(val);
        return isNew;
    }
    public boolean remove(int val) {
        Set<Integer> idxSet = idxMap.get(val);
        if (idxSet == null || idxSet.isEmpty()) {
            return false;
        }
        int removeIdx = idxSet.iterator().next();
        idxSet.remove(removeIdx);
        int lastIdx = nums.size() - 1;
        int lastVal = nums.get(lastIdx);
        if (removeIdx != lastIdx) {
            nums.set(removeIdx, lastVal);
            Set<Integer> lastSet = idxMap.get(lastVal);
            lastSet.remove(lastIdx);
            lastSet.add(removeIdx);
        }

        nums.remove(lastIdx);

        if (idxSet.isEmpty()) {
            idxMap.remove(val);
        }
        return true;
    }
    public int getRandom() {
        int idx = rand.nextInt(nums.size());
        return nums.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
