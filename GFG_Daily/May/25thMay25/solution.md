# Solution Explanation

### Intuition

This solution uses a hash map to store the squares of all elements in the array along with their indices. For each pair of squares, it checks if their sum is also present as a square in the map, which would indicate a Pythagorean triplet.

### Approach

- Create a map where the key is the square of an element and the value is a list of indices where that square occurs.
- For every pair of keys (i, j) in the map:
  - Compute `k = i + j`.
  - If `k` is present in the map, check if the indices are distinct (to ensure all three numbers are from different positions).
  - If `i == k` or `j == k`, ensure there are at least two occurrences for that value.
  - If a valid triplet is found, return true.
- If no such triplet is found, return false.

### Code

```java
class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sq = arr[i] * arr[i];
            if (map.containsKey(sq)) {
                map.get(sq).add(i);
            } else {
                map.put(sq, new ArrayList<>());
                map.get(sq).add(i);
            }
        }
        for (Map.Entry<Integer, List<Integer>> i : map.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> j : map.entrySet()) {
                int k = i.getKey() + j.getKey();
                if (map.containsKey(k)) {
                    if (i.getKey() == k) {
                        if (i.getValue().size() > 1) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (j.getKey() == k) {
                        if (j.getValue().size() > 1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
```

### Complexity

- **Time Complexity:** O(n^2), where n is the length of the array (due to the nested loops over the map entries).
- **Space Complexity:** O(n), for storing the squares and their indices.

### Summary

- The solution uses a hash map to efficiently check for the existence of a Pythagorean triplet.
- It ensures that all three numbers are from different indices.
- Returns true if such a triplet exists, otherwise false.
