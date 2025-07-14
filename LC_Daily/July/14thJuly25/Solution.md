
# Solution Explanation

## Intuition
The binary number is stored in a linked list, with the most significant bit at the head. We can process the list from head to tail, building the decimal value by shifting the current result left (multiplying by 2) and adding the current node's value.

## Approach
- Start with an initial result of `0`.
- Traverse the linked list from head to tail.
- For each node:
  - Multiply the current result by `2` (left shift).
  - Add the node's value to the result.
- Continue until the end of the list.
- Return the final result as the decimal value.

## Complexity
- Time Complexity: `O(n)`, where `n` is the number of nodes in the linked list.
- Space Complexity: `O(1)`, as only a constant amount of extra space is used.

## Summary
This approach works because each step simulates reading a binary digit from left to right, just as you would convert a binary number to decimal manually. The algorithm is efficient, handles all valid inputs, and does not require any extra data structures. Edge cases, such as a single-node list or all zeros, are naturally handled by the process.

