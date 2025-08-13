
# Solution Explanation

## Intuition
Maintain two structures: a dynamic array `nums` storing all elements (allowing `O(1)` access by index) and a map `idxMap` from each value to the **set of indices** where it appears in `nums`.
• **Insert** appends the value to `nums` and records the new index in `idxMap`.
• **Remove** swaps the last element into the index to delete, updates the corresponding sets, and pops the last element—keeping `nums` compact in `O(1)` time.
• **getRandom** picks a random index in `nums`, so each stored occurrence is equally likely, giving probability proportional to frequency.

## Approach
1. **Data Structures**
   • `List<Integer> nums` — stores every element (duplicates included).
   • `Map<Integer, Set<Integer>> idxMap` — maps each value to all indices where it occurs in `nums`.
   • `Random rand` — generates random indices.
2. **insert(val)**
   a. Append `val` to `nums`.
   b. Add the new index (`nums.size() - 1`) to `idxMap[val]`.
   c. Return `true` if this is the first occurrence (`idxMap[val]` previously empty), else `false`.
3. **remove(val)**
   a. If `idxMap[val]` is empty, return `false`.
   b. Grab any index `i` from `idxMap[val]`.
   c. Get the last index `lastIdx` and last value `lastVal` in `nums`.
   d. Move `lastVal` to position `i` (if `i` is not `lastIdx`). Update its index set: remove `lastIdx`, add `i`.
   e. Remove `lastIdx` from `nums` and erase `i` from `idxMap[val]`.
   f. If `idxMap[val]` becomes empty, delete the entry.
   g. Return `true`.
4. **getRandom()**
   a. Generate random integer `r` in `[0, nums.size())`.
   b. Return `nums[r]`.

## Complexity
- **Time Complexity**
  • `insert` — `O(1)` average
  • `remove` — `O(1)` average
  • `getRandom` — `O(1)`
- **Space Complexity**
  • `O(n)` where `n` is the number of stored elements (arrays + hashmap sets).

## Summary
By combining an array for random access with a hashmap for index tracking, we achieve **O(1)** expected time for all operations, correctly handling duplicates and ensuring `getRandom` returns each occurrence with equal probability.
```java
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

```
