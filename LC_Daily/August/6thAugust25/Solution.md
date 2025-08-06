
# Solution Explanation

## Intuition
The key insight is to **simulate the placement process** exactly as described in the problem. For each fruit type, we need to find the **leftmost available basket** that has sufficient capacity. This is a **greedy approach** where we process fruits in order and assign each to the first suitable basket we encounter.

## Approach
We use a **segment tree** to efficiently find the leftmost basket with sufficient capacity:

1. **Build a segment tree** where each node stores the maximum capacity in its range, allowing us to quickly determine if any basket in a range can hold a fruit.
2. **Query for leftmost suitable basket**: For each fruit, we traverse the segment tree to find the leftmost basket with capacity ≥ fruit size in `O(log n)` time.
3. **Mark basket as used**: Once a basket is selected, we update its capacity to 0 in the segment tree to mark it as unavailable.
4. **Count unplaced fruits**: If no suitable basket exists (root has capacity < fruit size), increment the unplaced counter.

This approach maintains the **leftmost selection rule** while achieving logarithmic time complexity per fruit.

## Algorithm
1. **Build segment tree**: Initialize a segment tree with basket capacities where each node stores the maximum capacity in its range.
2. **Process fruits sequentially**: For each fruit in `fruits` array:
   1. Check if any basket can hold the fruit by examining the root node's maximum capacity.
   2. If `seg[1] < fruitSize`, increment `unplaced` and continue.
   3. Otherwise, query the segment tree to find the leftmost basket index with sufficient capacity.
   4. Update that basket's capacity to 0 in the segment tree.
3. **Return result**: Return the total count of unplaced fruits.

## Complexity
- **Time Complexity:** `O(n log n)` – building the segment tree takes `O(n)`, and each of the `n` fruits requires `O(log n)` for query and update operations.
- **Space Complexity:** `O(n)` – the segment tree uses `O(4n)` space which is `O(n)`.

## Summary
The **segment tree approach** efficiently maintains the leftmost selection rule while providing `O(log n)` query and update operations. This optimization reduces the overall time complexity from `O(n²)` to `O(n log n)`, making it suitable for large inputs up to `10⁵` elements.

