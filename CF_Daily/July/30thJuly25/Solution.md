
# Solution Explanation

## Intuition
The key insight is to use a **greedy approach with a priority queue (min-heap)**. We want to drink as many potions as possible, so we should be **strategic about which negative potions to keep**. If we encounter a situation where our health would go negative, we should **remove the most harmful potion** we've drunk so far.

## Approach
We traverse the potions from left to right and use a **greedy strategy**:

1. **Always try to drink the current potion** initially
2. If drinking it would make our health negative, we need to **decide which potions to keep**
3. Use a **min-heap to track all negative potions** we've drunk so far
4. When health goes negative, **remove the most negative potion** from our selection
5. Keep doing this until health becomes non-negative again

The idea is that we want to **maximize the count of potions**, so we prefer keeping multiple smaller negative potions over one large negative potion.

## Algorithm
1. Initialize `health = 0`, `count = 0`, and a **min-heap** for negative potions
2. For each potion from left to right:
   - Add the potion's value to current health
   - Increment the count of potions drunk
   - If the potion is negative, add it to the min-heap
   - While health is negative:
     - Remove the **most negative potion** from the min-heap
     - Subtract its value from health (making health less negative)
     - Decrement the count
3. Return the final count

## Complexity
- **Time Complexity:** `O(n log n)` where n is the number of potions. Each potion might be added and removed from the heap once.
- **Space Complexity:** `O(n)` for the min-heap to store negative potions.

## Summary
This greedy approach works because we're **optimizing for maximum count**, not maximum health. By always keeping the "least harmful" negative potions and removing the most harmful ones when necessary, we ensure we can drink the maximum number of potions while maintaining non-negative health. The **min-heap efficiently tracks** which negative potion to remove when we need to recover health.

