# Solution Explanation

## Intuition
The problem asks for the k-th smallest number in lexicographical order from 1 to n. Generating and sorting all numbers is not feasible for large n (up to 10^9). Instead, we can simulate the lexicographical traversal as if we are walking a 10-ary tree, where each node's children are formed by appending digits 0-9.

## Approach
- Start with the prefix `1` (the smallest number).
- At each step, count how many numbers in the range `[1, n]` start with the current prefix.
- If the count of numbers with the current prefix plus the numbers already counted so far is less than or equal to k, skip the entire subtree (move to the next prefix).
- Otherwise, go deeper by appending a zero to the prefix (move to the next level in the tree).
- Repeat this process until you reach the k-th number.

## Algorithm
1. Initialize `prefix = 1` and `count = 1` (since 1 is the first number).
2. While `count < k`:
   - Use a helper function to count how many numbers in `[1, n]` start with the current prefix.
   - If `count + currCount <= k`, increment the prefix and add `currCount` to `count`.
   - Otherwise, go deeper by multiplying the prefix by 10 and increment `count` by 1.
3. When `count == k`, return the current prefix.

## Complexity
- Time Complexity: O(log n * log n), since for each digit position, we may traverse down the tree and count the numbers with a given prefix.
- Space Complexity: O(1), as only a few variables are used.

## Summary
By simulating the lexicographical traversal and efficiently counting the number of numbers with a given prefix, we can find the k-th smallest number without generating all numbers, making the solution efficient even for large n.
