# Solution Explanation

## Intuition
To efficiently find the **next greater element** (NGE) for every position in a **circular array**, we use a **monotonic stack**.  
Traversing the array twice simulates its circular nature, while the stack lets us discard elements that cannot be the NGE of any earlier position.

## Approach
1. Traverse the indices from `2·n − 1` down to `0` (right-to-left, twice).  
   • Index `i = idx % n` maps us back into the valid range `0 … n − 1`.  
2. Maintain a **decreasing stack** that stores candidate values (not indices).  
   • Before using the current value `arr[i]`, pop all elements `≤ arr[i]` because they cannot be the NGE of `arr[i]` or any element to its left.  
3. During the **first pass** (when `idx < n`) the top of the stack, if any, is the NGE for `arr[i]`; otherwise the answer is `-1`.  
4. Push `arr[i]` onto the stack so that it becomes a candidate for earlier elements.

## Algorithm
1. Let `ans` be an array of length `n` initialised with `-1`.  
2. Create an empty stack `st`.
3. For `idx` from `2·n − 1` down to `0`:
   1. `i = idx % n`  
   2. While `st` is **not empty** and `st.top() ≤ arr[i]`, pop `st`.  
   3. If `idx < n` and `st` is **not empty**, set `ans[i] = st.top()` (otherwise `-1` remains).  
   4. Push `arr[i]` onto `st`.
4. Return `ans`.

## Complexity
- **Time Complexity:** `O(n)` — each element is pushed and popped at most once.  
- **Space Complexity:** `O(n)` — the stack can hold at most `n` elements.

## Summary
By iterating twice from right to left and using a **monotonic decreasing stack**, we process every element in constant amortised time, achieving an optimal linear-time solution while correctly handling the circular behaviour of the array.

