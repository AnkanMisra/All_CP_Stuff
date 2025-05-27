# Solution Explanation for "Need More Arrays"

## Approach

- We want to maximize the number of subarrays formed after removing some elements.
- According to the problem, a new subarray starts when the current element is strictly greater than the previous chosen element by at least 2 (i.e., **current_element ≥ previous_element + 2**).
- So, we greedily pick elements that satisfy this condition to start new subarrays.
- Initialize a variable `d` to the smallest possible integer (to represent the last chosen element).
- Iterate through the array elements:
  - If the current element is at least 2 greater than `d`, increment the count `e` of subarrays and update `d` to the current element.
- At the end, `e` is the maximum number of subarrays possible.

## Code Walkthrough

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int testcases = a.nextInt();

        while (testcases != 0) {
            int c = a.nextInt();             // Length of the array
            int d = Integer.MIN_VALUE;      // Last chosen element initialized to minimum integer
            int e = 0;                      // Count of subarrays

            for (int i = 0; i < c; i++) {
                int f = a.nextInt();        // Current element in array

                // Check if current element can start a new subarray
                if (f >= d + 2) {
                    e++;                    // Increase count of subarrays
                    d = f;                  // Update last chosen element
                }
            }

            System.out.println(e);          // Output max number of subarrays
            testcases--;
        }
    }
}
```

## Complexity

- Time Complexity: **O(n)** per test case, where **n** is the length of the array.
- Since the sum of **n** over all test cases ≤ 2×10⁵, the solution is efficient enough for the problem constraints.
- Space Complexity: **O(1)** extra space apart from input storage.

## Summary

- The solution greedily counts elements that can start new subarrays by ensuring the gap between chosen elements is at least 2.
- This directly corresponds to the problem’s condition to maximize the number of arrays formed after removals.
