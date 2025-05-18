# Solution Explanation

### Intuition

We need to find the smallest index `i` in the array such that the sum of the digits of `nums[i]` is equal to `i`.  
This can be done by iterating through the array and, for each element, calculating the sum of its digits and comparing it to the index.

### Approach

- Iterate through the array from left to right.
- For each index `i`, calculate the sum of the digits of `nums[i]`.
- If the sum equals `i`, return `i` immediately (since we want the smallest such index).
- If no such index is found after checking all elements, return `-1`.

### Code

```java
class Solution {
    public int smallestIndex(int[] a) {
        for (int b = 0; b < a.length; b++) {
            if (sum(a[b]) == b) {
                return b;
            }
        }
        return -1;
    }

    public static int sum(int c) {
        int d = 0;
        while (c > 0) {
            d += c % 10;
            c /= 10;
        }
        return d;
    }
}
```

### Complexity

- **Time Complexity:** O(n * k), where n is the length of the array and k is the number of digits in the largest number (at most 4, since nums[i] ≤ 1000).
- **Space Complexity:** O(1), as only a few variables are used.

### Summary

- The solution checks each index for the digit sum condition and returns the smallest valid index.
- If no such index exists, it returns -1.
- This approach is efficient for the given constraints.
