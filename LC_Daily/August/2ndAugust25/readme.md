
# Problem: 2561. Rearranging Fruits

## Problem Description
You have **two fruit baskets** containing `n` fruits each. You are given two **0-indexed integer arrays** `basket1` and `basket2` representing the cost of fruit in each basket. You want to **make both baskets equal**. To do so, you can use the following operation as many times as you want:

- Choose two indices `i` and `j`, and **swap the ith fruit** of `basket1` with the **jth fruit** of `basket2`.
- The **cost of the swap** is `min(basket1[i], basket2[j])`.

**Two baskets are considered equal** if sorting them according to the fruit cost makes them exactly the same baskets.

## Input Format
- `basket1`: A **0-indexed integer array** representing the cost of fruits in the first basket
- `basket2`: A **0-indexed integer array** representing the cost of fruits in the second basket
- Both arrays have **equal length** `n`

## Output Format
Return the **minimum cost** to make both baskets equal, or **-1 if impossible**.

## Examples

### Input
`basket1 = [4,2,2,2], basket2 = [1,4,1,2]`<br/>

### Output
`1`<br/>

**Explanation:** Swap index 1 of basket1 with index 0 of basket2, which has cost `1`. Now `basket1 = [4,1,2,2]` and `basket2 = [2,4,1,2]`. Rearranging both arrays makes them equal.

### Input
`basket1 = [2,3,4,1], basket2 = [3,2,5,1]`<br/>

### Output
`-1`<br/>

**Explanation:** It can be shown that it is **impossible** to make both baskets equal.

## Constraints
- `basket1.length == basket2.length`
- **1 <= basket1.length <= 10^5**
- **1 <= basket1[i], basket2[i] <= 10^9**

## Notes
- The goal is to make both baskets have the **same multiset of elements** when sorted
- Each swap operation has a cost equal to the **minimum value** of the two fruits being swapped
- If it's impossible to make the baskets equal, return **-1**

