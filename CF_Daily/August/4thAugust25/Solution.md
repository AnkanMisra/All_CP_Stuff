
# Solution Explanation

## Intuition
To split an array into **three contiguous parts with equal sums**, the total sum must be **divisible by 3**. We need to find pairs of indices `(i, j)` where the first part ends at `i-1`, the second part spans from `i` to `j`, and the third part starts at `j+1`. Each part must have sum equal to `totalSum/3`.

## Approach
Use **prefix sum traversal** to efficiently count valid split points:

1. **Calculate total sum** and check if it's divisible by 3. If not, return 0.
2. **Define targets**: `target1 = totalSum/3` (sum of first part) and `target2 = 2*target1` (sum of first two parts combined).
3. **Single pass counting**: Traverse the array while maintaining a running prefix sum.
4. **Count valid first splits**: When prefix sum equals `target1`, increment a counter for potential first part endings.
5. **Count valid complete splits**: When prefix sum equals `target2`, add the current count of valid first splits to the total ways.
6. **Boundary constraint**: Stop at index `n-2` to ensure the third part is non-empty.

## Complexity
- **Time Complexity**: `O(n)` - Single pass through the array
- **Space Complexity**: `O(1)` - Only using constant extra space for counters

## Summary
This approach works by **leveraging the mathematical property** that if we know where the first part ends (prefix sum = `target1`) and where the second part ends (prefix sum = `target2`), we can count all valid combinations efficiently. The key insight is that for each valid ending of the second part, we can pair it with **all previously found valid endings** of the first part. **Corner cases** include arrays with less than 3 elements and total sums not divisible by 3, both returning 0 ways.

