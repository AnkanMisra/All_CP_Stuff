# Solution Explanation

## Intuition
To maximize the number of shrink operations, we want to create as many "peaks" as possible in the permutation. A "peak" is an element that is greater than its immediate neighbors, making it eligible for removal by the shrink operation. By arranging the numbers so that the largest values are placed between smaller values, we can maximize the number of peaks.

## Approach
- Always start with `1` at the beginning and `2` at the end.
- Place the largest numbers in descending order between them.
- This arrangement ensures that each of the largest numbers (from `n` down to `3`) is a peak, as it is surrounded by smaller numbers (`1` and `2`).
- For example, for `n = 6`, the permutation is: `1 6 5 4 3 2`.
- For each test case, print the permutation in this order.

## Complexity
- Time Complexity: O(n) per test case, as we print each number once.
- Space Complexity: O(1) extra space, as we do not store the permutation.

## Summary
By placing the smallest numbers at the ends and the largest numbers in descending order in the middle, we maximize the number of shrink operations (peaks) that can be performed on the permutation.
