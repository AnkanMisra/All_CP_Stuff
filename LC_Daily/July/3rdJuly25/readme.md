# Problem: 3304. Find the K-th Character in String Game I

## Problem Description
Alice and Bob are playing a game. Initially, Alice has a string `word = "a"`. Bob will ask Alice to perform the following operation forever:

**Generate a new string** by changing each character in `word` to its **next character in the English alphabet**, and **append it to the original word**.

For example, performing the operation on `"c"` generates `"cd"` and performing the operation on `"zb"` generates `"zbac"`.

Return the **value of the kth character** in `word`, after enough operations have been done for `word` to have **at least k characters**.

**Note:** The character `'z'` can be changed to `'a'` in the operation.

## Input Format
A **positive integer** `k`.

## Output Format
The **value of the kth character** in `word`.

## Examples

### Example 1
**Input:** `k = 5`<br/>
**Output:** `"b"`<br/>

**Explanation:**
Initially, `word = "a"`. We need to do the operation three times:
- Generated string is `"b"`, word becomes `"ab"`
- Generated string is `"bc"`, word becomes `"abbc"`
- Generated string is `"bccd"`, word becomes `"abbcbccd"`

### Example 2
**Input:** `k = 10`<br/>
**Output:** `"c"`<br/>

## Constraints
- `1 <= k <= 500`

## Notes
- The character transformation follows the English alphabet order where `'z'` wraps around to `'a'`
- Operations continue until the word has **at least k characters**
- The problem asks for the **kth character** (1-indexed) in the final word

