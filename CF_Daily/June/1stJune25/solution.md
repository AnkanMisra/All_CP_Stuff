# Solution Explanation

### Intuition

To light the entire street, the maximum distance between any two adjacent lanterns must be covered, as well as the distance from the first lantern to the start of the street and from the last lantern to the end of the street. The minimum required radius is the maximum of:
- The distance from the start to the first lantern,
- The distance from the last lantern to the end,
- Half the distance between any two adjacent lanterns.

### Approach

- Read the positions of all lanterns and sort them.
- Compute the distance from the start of the street to the first lantern and from the last lantern to the end of the street.
- For each pair of adjacent lanterns, compute half the distance between them.
- The answer is the maximum of these values.
- Print the result with 10 decimal places.

### Complexity

- Time Complexity: O(n log n), due to sorting the lantern positions.
- Space Complexity: O(n), for storing the lantern positions.

### Summary

- The solution sorts the lantern positions and computes the maximum required radius to ensure the entire street is lit.
- It considers the edge cases at the start and end of the street, as well as the largest gap between adjacent lanterns.
- The approach is efficient and optimal for the given constraints.
