# Solution Explanation

## Intuition
To maximize the number of segments in a "cool partition," we want to cut the array at positions where all elements in the current segment will also appear in the next segment. This is only possible if, for every element in the current segment, its next occurrence (if any) is after the current segment ends.

## Approach
- For each element, track the next occurrence index (or n if it does not appear again).
- As we scan the array, keep track of the farthest next occurrence (`sup`) for all elements seen so far.
- When the current index `i` reaches or passes the start of the current segment (`prev`), and the farthest next occurrence (`sup`) is less than `n`, we can make a cut (end the current segment).
- Reset `sup` and update `prev` to start a new segment.
- If there are any elements left after the last cut, count them as the final segment.

## Complexity
- Time Complexity: O(n) per test case, since we scan the array and update next occurrence indices in linear time.
- Space Complexity: O(n) per test case for the auxiliary arrays.

## Summary
By tracking the next occurrence of each element and making a cut whenever all elements in the current segment will appear again later, we maximize the number of "cool" segments in the partition.
