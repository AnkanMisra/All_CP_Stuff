# Solution Explanation

## Intuition
The problem is to find the largest subset of an array of distinct positive integers such that for every pair (x, y) in the subset, either x divides y or y divides x. This is a classic dynamic programming problem similar to the Longest Increasing Subsequence, but with a divisibility condition.

The key insight is to sort the array in descending order (to help with lexicographical order in case of ties) and use dynamic programming to build the largest divisible subset ending at each element.

## Approach
1. **Sort the Array in Descending Order:**  
   - This ensures that, when reconstructing the subset, we get the lexicographically greatest subset if there are multiple answers.
2. **Dynamic Programming:**  
   - For each element, try to extend the largest divisible subset ending at any previous element that divides the current element.
   - Use a `memo` array to store the length of the largest subset ending at each index.
   - Use a `parent` array to reconstruct the subset.
3. **Reconstruction:**  
   - After filling the DP arrays, reconstruct the subset by following the parent pointers from the index with the largest subset.
4. **Return the Result:**  
   - The result is the largest divisible subset, in descending order.

## Complexity
- **Time Complexity:** O(n^2), where n is the length of the array (since for each element, we may check all previous elements).
- **Space Complexity:** O(n), for the memoization and parent arrays.

## Summary
**By sorting the array in descending order and using dynamic programming to track the largest divisible subset ending at each element, we can efficiently find the largest subset and ensure it is lexicographically greatest.**  
The parent array allows us to reconstruct the actual subset.

```java
class Solution {
    public int lds(int[] arr, int[] memo, int[] parent, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }

        int maxLength = 1;
        int bestParent = -1;

        for (int j = 0; j < i; j++) {
            if (arr[j] % arr[i] == 0) {
                int length = lds(arr, memo, parent, j) + 1;
                if (length > maxLength) {
                    maxLength = length;
                    bestParent = j;
                }
            }
        }

        memo[i] = maxLength;
        parent[i] = bestParent;
        return maxLength;
    }

    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) temp[i] = arr[i];
        Arrays.sort(temp, Collections.reverseOrder());
        for (int i = 0; i < n; i++) arr[i] = temp[i];

        int[] memo = new int[n];
        int[] parent = new int[n];
        Arrays.fill(memo, -1);
        Arrays.fill(parent, -1);

        int maxSize = 0;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            int size = lds(arr, memo, parent, i);
            if (size > maxSize) {
                maxSize = size;
                lastIndex = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = lastIndex; i >= 0; i = parent[i]) {
            result.add(arr[i]);
            if (parent[i] == -1) break;
        }

        return result;
    }
}
