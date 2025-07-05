# Problem: Hexadecimal and Hexatrigesimal Conversion

## Problem Description
Given an integer `n`, return the concatenation of the **hexadecimal representation** of `n * n` and the **hexatrigesimal representation** of `n * n * n`.

A **hexadecimal number** is a base-16 numeral system that uses the digits `0–9` and the uppercase letters `A–F` to represent values from `0` to `15`.

A **hexatrigesimal number** is a base-36 numeral system that uses the digits `0–9` and the uppercase letters `A–Z` to represent values from `0` to `35`.

## Input Format
- An integer `n` (**1 <= n <= 1000**)

## Output Format
- A string representing the **concatenation** of the hexadecimal representation of `n * n` and the hexatrigesimal representation of `n * n * n`.

## Examples

### Input
`n = 13`<br/>

### Output
`A91P1`<br/>

**Explanation:**<br/>
- `n * n = 13 * 13 = 169`. In hexadecimal, `169` is `A9`.<br/>
- `n * n * n = 13 * 13 * 13 = 2197`. In hexatrigesimal, `2197` is `1P1`.<br/>
- Concatenating both results gives `A9` + `1P1` = `A91P1`.

### Input
`n = 36`<br/>

### Output
`5101000`<br/>

**Explanation:**<br/>
- `n * n = 36 * 36 = 1296`. In hexadecimal, `1296` is `510`.<br/>
- `n * n * n = 36 * 36 * 36 = 46656`. In hexatrigesimal, `46656` is `1000`.<br/>
- Concatenating both results gives `510` + `1000` = `5101000`.

## Constraints
- **1 <= n <= 1000**
