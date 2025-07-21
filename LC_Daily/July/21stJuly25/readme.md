
# Problem: Delete Characters to Make Fancy String

## Problem Description
Given a string `s`, you need to **delete the minimum possible number of characters** from `s` to make it a **fancy string**. A fancy string is defined as a string where **no three consecutive characters are equal**. The answer will always be unique.

## Input Format
- A single string `s` consisting only of lowercase English letters.

## Output Format
- A string representing the final fancy string after the minimum number of deletions.

## Examples

### Input

s = `leeetcode`<br/>

### Output

`leetcode`<br/>

**Explanation:**
Remove an `e` from the first group of `e`s to create `leetcode`. No three consecutive characters are equal, so return `leetcode`.

### Input

s = `aaabaaaa`<br/>

### Output

`aabaa`<br/>

**Explanation:**
Remove an `a` from the first group of `a`s to create `aabaaaa`. Remove two `a`s from the second group of `a`s to create `aabaa`. No three consecutive characters are equal, so return `aabaa`.

### Input

s = `aab`<br/>

### Output

`aab`<br/>

**Explanation:**
No three consecutive characters are equal, so return `aab`.

## Constraints
- **1 <= s.length <= 100000**
- `s` consists only of lowercase English letters.

