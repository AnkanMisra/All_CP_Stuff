
# Problem: Fruit Into Baskets

## Problem Description
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits` where `fruits[i]` is the type of fruit the ith tree produces.

You want to **collect as much fruit as possible**. However, the owner has some strict rules that you must follow:

- You only have **two baskets**, and each basket can only hold a **single type of fruit**. There is no limit on the amount of fruit each basket can hold.
- Starting from any tree of your choice, you must **pick exactly one fruit from every tree** (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
- Once you reach a tree with fruit that **cannot fit in your baskets**, you must stop.

Given the integer array `fruits`, return the **maximum number of fruits** you can pick.

## Input Format
- An integer array `fruits` where `fruits[i]` represents the type of fruit the ith tree produces

## Output Format
- An integer representing the **maximum number of fruits** you can pick

## Examples

### Input
`fruits = [1,2,1]`<br/>

### Output
`3`<br/>
**Explanation:** We can pick from all 3 trees.

### Input
`fruits = [0,1,2,2]`<br/>

### Output
`3`<br/>
**Explanation:** We can pick from trees `[1,2,2]`. If we had started at the first tree, we would only pick from trees `[0,1]`.

### Input
`fruits = [1,2,3,2,2]`<br/>

### Output
`4`<br/>
**Explanation:** We can pick from trees `[2,3,2,2]`. If we had started at the first tree, we would only pick from trees `[1,2]`.

## Constraints
- **1 <= fruits.length <= 10^5**
- **0 <= fruits[i] < fruits.length**

## Notes
This problem is essentially asking for the **longest subarray** that contains at most **two distinct elements**.

