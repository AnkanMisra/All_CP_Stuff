# Solution Explanation

## Intuition
The problem asks for the minimum number of adjacent swaps needed to rearrange an array so that the parity (even/odd) of adjacent elements alternates. The key insight is that, for a valid arrangement, the even and odd numbers must be distributed as evenly as possible, and their positions must alternate.

If the difference between the number of even and odd elements is more than 1, it is impossible to alternate them, so we return -1.

## Approach
1. **Count Even and Odd Positions:**  
   - Collect the indices of all even numbers in the array.
   - Let `e` be the number of even numbers and `f` be the number of odd numbers.
2. **Check Feasibility:**  
   - If `|e - f| > 1`, return -1 (impossible to alternate).
3. **Try Both Starting Parities:**  
   - If there are at least as many even numbers as odd, try starting with an even number at index 0.
   - If there are at least as many odd numbers as even, try starting with an odd number at index 0.
   - For each case, calculate the total number of swaps needed to move the even numbers to the correct positions (0, 2, 4, ...) or (1, 3, 5, ...).
   - The answer is the minimum swaps among the valid cases.
4. **Return the Result:**  
   - If no valid arrangement is possible, return -1.

## Complexity
- **Time Complexity:** O(n), where n is the length of the array (since each element is processed at most twice).
- **Space Complexity:** O(n), for storing the indices of even numbers.

## Summary
**By counting the even and odd numbers and simulating both possible starting parities, we can efficiently compute the minimum number of adjacent swaps needed to alternate the array.**  
If the counts differ by more than 1, it is impossible to alternate, and we return -1.

```java
class Solution {
    public int minSwaps(int[] a) {
        int b = a.length;
        List<Integer> c = new ArrayList<>();
        for (int d = 0; d < b; d++) {
            if ((a[d] & 1) == 0) {
                c.add(d);
            }
        }
        int e = c.size();
        int f = b - e;
        if (Math.abs(e - f) > 1) {
            return -1;
        }
        long g = Long.MAX_VALUE;
        if (e >= f) {
            g = Math.min(g, fun(c, 0, b));
        }
        if (f >= e) {
            g = Math.min(g, fun(c, 1, b));
        }
        if (g == Long.MAX_VALUE) {
            return -1;
        }
        return (int) g;
    }
    private long fun(List<Integer> a, int b, int c) {
        long d = 0;
        int e = 0;
        for (int f = b; f < c; f += 2) {
            d += Math.abs(a.get(e++) - f);
        }
        return d;
    }
}