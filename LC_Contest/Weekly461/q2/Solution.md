
# Solution Explanation

## Intuition
The key insight is that for a shipment to be **balanced**, the last element must be **strictly smaller** than the maximum element in that shipment. This means we need to find contiguous subarrays where the last element is not the maximum. We can use a **greedy approach** with a **monotonic stack** to efficiently find the **previous greater element** for each position, which helps us identify valid shipment endpoints.

## Approach
The solution uses a **monotonic decreasing stack** to find the **previous greater element** for each position. For each position `r` (potential shipment end), we find the leftmost position `l` where there exists an element greater than `a[r]`. This gives us a valid balanced shipment from `l+1` to `r`.

The algorithm works as follows:
1. **Build Previous Greater Array**: Use a monotonic stack to find `pg[i]` - the index of the previous greater element for each position `i`
2. **Greedy Selection**: Iterate through potential shipment endpoints and greedily select non-overlapping shipments
3. **Non-overlapping Constraint**: Track the last used endpoint to ensure shipments don't overlap

## Algorithm
1. Initialize a **monotonic decreasing stack** and `pg` array to store previous greater element indices
2. For each element at index `i`:
   - Pop elements from stack while they are **less than or equal** to current element
   - Set `pg[i]` to the top of stack (or `-1` if empty)
   - Push current index to stack
3. Initialize `count = 0` and `lastend = -1` for tracking selected shipments
4. For each potential endpoint `r` from `1` to `n-1`:
   - Get the previous greater element position `l = pg[r]`
   - If `l > lastend` (no overlap with previous shipment):
     - Increment `count`
     - Update `lastend = r`
5. Return `count`

## Complexity
- **Time Complexity:** `O(n)` - Each element is pushed and popped from stack at most once
- **Space Complexity:** `O(n)` - For the stack and previous greater array

## Summary
This approach works because it **greedily selects the earliest possible balanced shipments** without overlap. The monotonic stack efficiently finds previous greater elements, enabling us to identify valid shipment ranges. The greedy strategy is optimal because selecting an earlier shipment never prevents us from finding a better solution later. **Corner cases** include arrays where no balanced shipments can be formed (like `[4,4]`) and single-element arrays.

