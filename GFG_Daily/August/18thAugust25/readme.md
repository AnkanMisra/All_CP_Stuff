
# Problem: Find H-Index

## Problem Description
You are given an array `citations[]`, where each element `citations[i]` represents the **number of citations** received by the **i-th paper** of a researcher. You have to calculate the researcher's **H-index**.

The **H-index** is defined as the **maximum value H**, such that the researcher has published **at least H papers**, and all those papers have **citation value greater than or equal to H**.

## Input Format

- An array `citations[]` where each element represents the number of citations for a paper.

## Output Format

- Return an integer representing the **H-index** of the researcher.

## Examples

### Example 1
**Input:** `citations[] = [3, 0, 5, 3, 0]`<br/>
**Output:** `3`<br/>

**Explanation:** There are **at least 3 papers** with citation counts of `3`, `5`, and `3`, all having citations **greater than or equal to 3**.

### Example 2
**Input:** `citations[] = [5, 1, 2, 4, 1]`<br/>
**Output:** `2`<br/>

**Explanation:** There are **3 papers** (with citation counts of `5`, `2`, and `4`) that have **2 or more citations**. However, the **H-Index cannot be 3** because there aren't 3 papers with 3 or more citations.

### Example 3
**Input:** `citations[] = [0, 0]`<br/>
**Output:** `0`<br/>

**Explanation:** The **H-index is 0** because there are **no papers with at least 1 citation**.

## Constraints
- **1 ≤ citations.size() ≤ 10^6**
- **0 ≤ citations[i] ≤ 10^6**

