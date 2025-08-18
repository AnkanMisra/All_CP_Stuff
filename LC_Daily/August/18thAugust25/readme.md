
# Problem: 679. 24 Game

## Problem Description
You are given an integer array `cards` of length 4. You have **four cards**, each containing a number in the range `[1, 9]`. You should **arrange the numbers** on these cards in a mathematical expression using the operators `['+', '-', '*', '/']` and the parentheses `'('` and `')'` to **get the value 24**.

You are restricted with the following rules:
- The **division operator '/'** represents real division, not integer division.
- **Every operation** done is between two numbers. In particular, we cannot use `'-'` as a unary operator.
- You **cannot concatenate numbers** together.

## Input Format
- `cards`: An integer array of length 4, where each element is in the range `[1, 9]`.

## Output Format
- Return `true` if you can get such expression that evaluates to **24**, and `false` otherwise.

## Examples

### Example 1
**Input:** `cards = [4,1,8,7]`<br/>
**Output:** `true`<br/>
**Explanation:** `(8-4) * (7-1) = 24`

### Example 2
**Input:** `cards = [1,2,1,2]`<br/>
**Output:** `false`<br/>

## Constraints
- `cards.length == 4`
- `1 <= cards[i] <= 9`

## Notes
- For example, `4 / (1 - 2 / 3) = 4 / (1 / 3) = 12` demonstrates real division.
- If `cards = [1, 1, 1, 1]`, the expression `"-1 - 1 - 1 - 1"` is **not allowed** due to unary operator restriction.
- If `cards = [1, 2, 1, 2]`, the expression `"12 + 12"` is **not valid** due to number concatenation restriction.

