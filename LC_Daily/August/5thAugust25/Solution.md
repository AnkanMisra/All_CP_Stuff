
# Solution Explanation

## Intuition
The problem requires placing fruits in baskets following a **greedy approach**. For each fruit, we need to find the **leftmost available basket** that has sufficient capacity. This is a classic **first-fit allocation** problem where we process items sequentially and assign them to the first available container that can accommodate them.

## Approach
The solution uses a **greedy algorithm** with the following steps:

1. **Initialize tracking variables**: Create a boolean array `vis` to track which baskets are already used, and a counter `count` for successfully placed fruits.

2. **Process fruits sequentially**: For each fruit from left to right, search for the first available basket that can accommodate it.

3. **First-fit allocation**: For each fruit, iterate through baskets from left to right and find the first basket that:
   - Is not already used (`!vis[j]`)
   - Has sufficient capacity (`baskets[j] >= fruits[i]`)

4. **Mark and count**: When a suitable basket is found, mark it as used and increment the placement counter.

5. **Calculate unplaced fruits**: Return the difference between total fruits and successfully placed fruits.

## Complexity
- **Time Complexity:** `O(n²)` - In the worst case, for each fruit we might need to check all baskets
- **Space Complexity:** `O(n)` - For the boolean array to track used baskets

## Summary
This **greedy first-fit approach** works because we always choose the leftmost available basket, ensuring optimal placement order. The algorithm handles **corner cases** naturally: if no suitable basket exists for a fruit, it remains unplaced. The key insight is that since we process fruits in order and always pick the leftmost available basket, we maintain the required placement constraints while maximizing successful allocations.

