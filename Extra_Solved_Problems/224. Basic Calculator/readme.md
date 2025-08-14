
# Basic Calculator

## Problem Description
Given a **valid arithmetic expression** `s`, evaluate it and **return the result**.
The expression may contain:
- digits `0-9`
- binary operators **+** and **-**
- parentheses `(` and `)`
- blank spaces

You are **not allowed** to use any built-in evaluation functions like `eval()`.

## Input Format
A single line containing the expression `s`.

## Output Format
A single integer – the value of the evaluated expression.

## Examples

### Example 1
**Input:**

`1 + 1`<br/><br/>
**Output:**

`2`<br/>

### Example 2
**Input:**

` 2-1 + 2 ` <br/><br/>
**Output:**

`3`<br/>

### Example 3
**Input:**

`(1+(4+5+2)-3)+(6+8)`<br/><br/>
**Output:**

`23`<br/>

## Constraints
- **1 ≤ s.length ≤ 300 000**
- `s` consists only of digits, `+`, `-`, `(`, `)` and spaces.
- `'+'` is **not** used as a unary operator.
- `'-'` **can** be used as a unary operator.
- There are **no two consecutive operators** in the input.
- Every intermediate or final value fits in a signed 32-bit integer.

## Notes
The task is to implement **integer evaluation** respecting the usual precedence where parentheses have higher priority and `+` / `-` are left-to-right within the same level.


