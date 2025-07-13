
# Solution Explanation

## Intuition
Every element that is **not already divisible by k** needs some extra value to reach the next multiple of `k`.  
For an element with remainder `r = a[i] % k`, the missing amount is `delta = k - r`.  
If several elements require the **same delta**, we cannot give them that delta with the same `x` value, because each element can be updated **at most once** and `x` grows by `1` after every move.  
So we must “schedule” their updates at different times, spaced exactly `k` moves apart:
``first element → x = delta``  
``second element → x = delta + k``  
``third element → x = delta + 2k``  
and so on.  
The **last** such update determines the total number of moves needed for this delta-group.

## Approach
1. For every element compute `r = a[i] % k`. If `r = 0`, it is already fine.  
   Otherwise compute `delta = k - r` and count how many elements need that exact `delta`.
2. For each distinct `delta` with frequency `cnt`:
   * The first element can be fixed when `x = delta` (that is after `delta` moves).
   * The second needs `x = delta + k`, the third `delta + 2k`, …, the `cnt`-th needs
     `x = delta + (cnt-1)·k`.
   * After fixing the last one we still need **one extra move** because the problem counts
     the move that increments `x` to this value.
   * Therefore the total moves required for this `delta` are
     `moves = (cnt-1)·k + delta + 1`.
3. The answer for the test case is the **maximum** `moves` over all deltas (or `0` if every
   element was already divisible by `k`).

## Complexity
- **Time Complexity:** `O(n)` per test case — we traverse the array once and iterate over the distinct deltas (at most `n`).
- **Space Complexity:** `O(n)` in the worst case to store counts of distinct deltas (one per array element).

## Summary
The key idea is to group elements by the **additional amount** they need to become divisible by `k`.  
Elements sharing the same `delta` must be processed sequentially, spaced `k` moves apart.  
By computing the last required update time for each group and taking the maximum, we obtain the minimum number of moves for the entire array.

