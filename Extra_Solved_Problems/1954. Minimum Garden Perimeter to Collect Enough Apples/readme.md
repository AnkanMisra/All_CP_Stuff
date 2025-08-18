
# Problem: Minimum Garden Perimeter to Collect Enough Apples

## Problem Description
In a garden represented as an **infinite 2D grid**, there is an apple tree planted at every integer coordinate. The apple tree planted at an integer coordinate `(i, j)` has `|i| + |j|` apples growing on it.

You will buy an **axis-aligned square plot** of land that is **centered at (0, 0)**.

Given an integer `neededApples`, return the **minimum perimeter** of a plot such that **at least `neededApples` apples** are inside or on the perimeter of that plot.

The value of `|x|` is defined as:
- `x` if `x >= 0`
- `-x` if `x < 0`

## Input Format
A single integer `neededApples` representing the minimum number of apples required.

## Output Format
Return the minimum perimeter of the square plot.

## Examples

### Example 1

![Example 1](https://assets.leetcode.com/uploads/2019/08/30/1527_example_1_2.png)

**Input:** `neededApples = 1`<br/>

**Output:** `8`<br/>

**Explanation:** A square plot of side length 1 does not contain any apples. However, a square plot of side length 2 has 12 apples inside. The perimeter is `2 * 4 = 8`.

### Example 2
**Input:** `neededApples = 13`<br/>

**Output:** `16`<br/>

### Example 3
**Input:** `neededApples = 1000000000`<br/>

**Output:** `5040`<br/>

## Constraints
- `1 <= neededApples <= 10^15`

