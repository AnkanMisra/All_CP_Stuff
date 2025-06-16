# Solution Explanation

## Intuition
To minimize the total cost of making all towers the same height, we need to choose a target height such that the sum of the costs to raise or lower each tower to that height is minimized. Since the cost function is convex (the cost increases as you move away from the optimal height), we can use ternary or binary search to efficiently find the minimum.

## Approach
- Find the minimum and maximum heights in the array. The optimal target height must be within this range.
- Use binary search to find the height that minimizes the total cost:
  - For each candidate height, calculate the total cost to make all towers that height.
  - Compare the cost at `mid`, `mid-1`, and `mid+1` to decide which direction to move.
  - If the cost decreases as you move left, search the left half; if it decreases as you move right, search the right half; otherwise, you have found the minimum.
- The helper function computes the total cost for a given target height by summing the cost for each tower.

## Complexity
- Time Complexity: O(n log(maxH-minH)), where n is the number of towers and maxH/minH are the maximum and minimum heights. Each binary search step takes O(n) time.
- Space Complexity: O(1), as only a few variables are used.

## Summary
By leveraging the convexity of the cost function and using binary search, we efficiently find the minimum cost to equalize all tower heights, even for large input sizes.
