# Solution Explanation

## Intuition
The problem asks for all numbers from 1 to n in lexicographical (dictionary) order. A naive approach is to generate all numbers and sort them as strings, but this does not meet the O(n) time and O(1) extra space requirements. The optimal approach is to simulate the lexicographical traversal directly, similar to a pre-order traversal of a 10-ary tree.

## Approach
- Start from 1 and always try to go deeper by multiplying by 10 (i.e., from 1 to 10, 100, etc.), which corresponds to the next lexicographical number.
- If going deeper exceeds n, increment the current number. If the last digit is 9 or incrementing would exceed n, backtrack by dividing by 10 until you can increment.
- Repeat this process until you have generated n numbers.

## Complexity
- Time Complexity: O(n), since each number from 1 to n is visited exactly once.
- Space Complexity: O(1) extra space (excluding the output list).

## Summary
By simulating the lexicographical traversal, we efficiently generate the required order without sorting, meeting the problem's constraints.
