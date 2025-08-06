
# Problem: Roman Number to Integer

## Problem Description
Given a string `s` in **Roman number format**, your task is to **convert it to an integer**. Various symbols and their values are given below:
- **I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000**

## Input Format
A string `s` representing a Roman number.

## Output Format
An integer representing the **decimal equivalent** of the given Roman number.

## Examples

### Input
`s = "IX"`<br/>

### Output
`9`<br/>
**Explanation:** IX is a Roman symbol which represents **10 – 1 = 9**.

### Input
`s = "XL"`<br/>

### Output
`40`<br/>
**Explanation:** XL is a Roman symbol which represents **50 – 10 = 40**.

### Input
`s = "MCMIV"`<br/>

### Output
`1904`<br/>
**Explanation:** M is `1000`, CM is `1000 – 100 = 900`, and IV is `4`. So we have total as **1000 + 900 + 4 = 1904**.

## Constraints
- **1 ≤ roman number ≤ 3999**
- **s[i] belongs to [I, V, X, L, C, D, M]**

## Notes
Roman numerals follow **subtraction rules** where smaller numerals before larger ones indicate subtraction (e.g., IV = 4, IX = 9, XL = 40, XC = 90, CD = 400, CM = 900).

