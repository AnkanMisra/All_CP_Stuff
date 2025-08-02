
# Solution Explanation

## Intuition
Convert the problem into finding the **longest subarray whose sum is positive** by mapping each element to `+1` if it is **greater than k** and to `-1` if it is **less than or equal to k**. A positive subarray‐sum means the subarray has more `+1` values than `-1` values, exactly matching the required condition.

## Approach
1. **Transform the array**: Replace every `arr[i]` with `+1` when `arr[i] > k`, else `-1`.
2. **Prefix sums**: Build `prefix[i]` as the sum of transformed values up to index `i – 1` (1-based for convenience). The subarray `(l, r]` has a positive sum if `prefix[r] > prefix[l]`.
3. **Monotonic stack of minima**:
   - Traverse the prefix array from left to right.
   - Maintain a stack of indices with **strictly decreasing** prefix values (so the top always stores the smallest prefix seen so far). These are candidate left boundaries.
4. **Two-pointer scan from the right**:
   - Iterate `i` from `n` down to `0`.
   - While the current prefix is **greater** than the prefix at the stack top, pop the stack and update the answer with `i − stackTop`.
   - This guarantees we pair each right boundary with the **leftmost** index having a smaller prefix, producing the maximum length.

## Complexity
- **Time Complexity:** `O(n)` — single forward pass to build the stack and single backward pass to compute the answer.
- **Space Complexity:** `O(n)` — for the prefix array and the monotonic stack.

## Summary
By mapping elements to `+1/-1`, the task reduces to the classic longest subarray with positive sum. A monotonic stack over prefix sums lets us in linear time find, for every right boundary, the farthest left prefix that is smaller, yielding the longest valid subarray length.

