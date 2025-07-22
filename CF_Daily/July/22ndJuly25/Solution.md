
# Solution Explanation

## Intuition
The key insight is to use a **greedy approach** to decide the felling direction for each tree while processing them from **left to right**, prioritizing left felling to leave more space on the right, and tracking the **rightmost occupied position** to avoid overlaps.

## Approach
We iterate through the trees, attempting to fell each one to the **left** if the left segment doesn't overlap with the previous occupied position. If not, we try felling to the **right** if it doesn't reach the next tree's position. If neither is possible, we leave it standing. This maximizes the number of felled trees by making locally optimal choices.

## Complexity
- Time complexity: `O(n)`
- Space complexity: `O(n)`

## Summary
This approach works because the greedy choice of preferring left felling minimizes interference with subsequent trees, ensuring we can fell as many as possible. Key takeaways include handling edge cases like the first and last trees, which can always be felled in at least one direction if space allows, and the use of `long` for coordinates to avoid overflow.

