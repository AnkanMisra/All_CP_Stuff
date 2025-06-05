# Solution Explanation

## Intuition
To make all elements of the array equal with the minimum cost, it's optimal to choose a value that already appears in the array and expand its largest contiguous block to cover the entire array. The cost is minimized when you use the largest contiguous block of any value, as you only need to change the elements outside this block.

## Approach
- For each value in the array, find the length of its largest contiguous block.
- For each value, the minimum cost to make the entire array equal to that value is `(n - k) * v`, where `k` is the length of the largest contiguous block of value `v`.
- Iterate through the array to compute the largest contiguous block for each value.
- For each value, calculate the cost and keep track of the minimum cost across all values.

## Complexity
- Time Complexity: O(n) per test case, since we scan the array once to find the largest contiguous block for each value and once to compute the minimum cost.
- Space Complexity: O(n) per test case for storing the block lengths.

## Summary
By focusing on the largest contiguous block for each value, we minimize the number of changes needed and thus the total cost. The answer is the minimum cost among all possible values in the array.
