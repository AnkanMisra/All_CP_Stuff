# Solution Explanation

## Intuition
To determine whether there is a smaller element to the right of index `i`, examine the **minimum value of every suffix**.
If that suffix minimum is smaller than `arr[i]`, at least one element inside that suffix satisfies the condition.
Because the suffix‐minimum array is **non-increasing**, we can binary search on it to find the farthest index whose suffix minimum remains smaller than `arr[i]`.

## Approach
1. **Build suffix minima.**
   - Let `minSuffix[n-1] = arr[n-1]`.
   - For `i` from `n-2` down to `0`, set `minSuffix[i] = min(arr[i], minSuffix[i+1])`.
2. **Process each index `i`.**
   - Initialise `lo = i + 1`, `hi = n-1`, `ans = -1`.
   - While `lo ≤ hi`:
     1. `mid = (lo + hi) / 2`.
     2. If `minSuffix[mid] < arr[i]`, store `ans = mid` and move right (`lo = mid + 1`).
     3. Else move left (`hi = mid − 1`).
3. **Return** the list of all stored answers.

## Complexity
- **Time Complexity:** `O(n log n)` — we perform a binary search (`log n`) for each of the `n` indices.
- **Space Complexity:** `O(n)` — for the `minSuffix` array and the answer list.

## Summary
Pre-computing the suffix minima converts the task into searching a monotonic array.
Binary search on this array yields, for every position, the farthest index holding a smaller value, achieving the desired result in **`O(n log n)`** time and **`O(n)`** space.
```java
class Solution {

    private void bs(int l, int r, int[] lowestFromRight, int ele, int[] temp) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (lowestFromRight[m] < ele) {
                temp[0] = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }

    private void findLowestFromRight(int[] lowestFromRight, int[] arr) {
        int n = arr.length;
        lowestFromRight[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            lowestFromRight[i] = Math.min(lowestFromRight[i + 1], arr[i]);
        }
    }

    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;

        int[] lowestFromRight = new int[n];
        findLowestFromRight(lowestFromRight, arr);

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            int[] temp = {-1};
            bs(i + 1, n - 1, lowestFromRight, arr[i], temp);
            ans.set(i, temp[0]);
        }

        return ans;
    }
}
```

