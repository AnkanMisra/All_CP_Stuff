# Solution Explanation

### Intuition

The problem requires distributing candies to children such that:
- Each child gets at least one candy.
- Any child with a higher rating than their neighbor gets more candies than that neighbor.

The challenge is to minimize the total number of candies distributed while satisfying these constraints.

### Approach

- Start by giving each child 1 candy.
- Traverse the ratings from left to right:
  - If a child has a higher rating than the previous child, give them one more candy than the previous child.
- Traverse the ratings from right to left:
  - If a child has a higher rating than the next child, ensure they have at least one more candy than the next child (using `Math.max` to keep the higher value from the previous pass).
- Sum up the candies for all children to get the minimum total.

### Algorithm

1. Initialize an array `candies` with 1 for each child.
2. Left-to-right pass: for each child, if their rating is higher than the previous, increment their candy count.
3. Right-to-left pass: for each child, if their rating is higher than the next, set their candy count to the maximum of its current value and one more than the next child's candy count.
4. Sum all values in the `candies` array for the result.

### Complexity

- **Time Complexity:** O(n), where n is the number of children (two linear passes and a sum).
- **Space Complexity:** O(n), for the candies array.

### Summary

- The solution uses two passes to ensure both left and right neighbor constraints are satisfied.
- It guarantees the minimum number of candies by only increasing when necessary.
- The approach is efficient and optimal for the given constraints.
