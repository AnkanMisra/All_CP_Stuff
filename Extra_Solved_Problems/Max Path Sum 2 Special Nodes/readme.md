
# Problem: Max Path Sum 2 Special Nodes

## Problem Description
Given a binary tree in which each node element contains a number. Find the **maximum possible path sum** from one **special node** to another **special node**.

**Note:** Here special node is a node that is **connected to exactly one different node**.

## Input Format
A binary tree represented as an array where `N` represents null nodes.

## Output Format
Return the **maximum possible path sum** between two special nodes.

## Examples

### Example 1
**Input:** `root = [3, 4, 5, -10, 4, N, N]`<br/>

![Example 1](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700554/Web/Other/blobid0_1746446410.webp)

**Output:** `16`<br/>

**Explanation:** Maximum Sum lies between special node 4 and 5. `4 + 4 + 3 + 5 = 16`.

### Example 2
**Input:** `root = [-15, 5, 6, -8, 1, 3, 9, 2, -3, 0, 4, -1, 10]`<br/>

![Example 2](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700554/Web/Other/blobid1_1746446430.webp)


**Output:** `27`<br/>

**Explanation:** The maximum possible sum from one special node to another is `(3 + 6 + 9 + 0 + -1 + 10 = 27)`.

### Example 3
**Input:** `root = [3, 4, 1, -10, 4]`<br/>

![Example 3](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700554/Web/Other/blobid3_1746446485.webp)

**Output:** `12`<br/>

**Explanation:** Maximum Sum lies between special node 4 and 1. `4 + 4 + 3 + 1 = 12`.

## Constraints
- **2 ≤ number of nodes ≤ 10^4**
- **-10^3 ≤ node->data ≤ 10^3**

