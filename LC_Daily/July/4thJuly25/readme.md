# Problem: 3307. Find the K-th Character in String Game II

## Problem Description
Alice and Bob are playing a game. Initially, Alice has a string `word = "a"`.

You are given a **positive integer k** and an **integer array operations**, where `operations[i]` represents the type of the ith operation.

Bob will ask Alice to perform all operations in sequence:
- If `operations[i] == 0`, **append a copy of word to itself**.
- If `operations[i] == 1`, **generate a new string by changing each character in word to its next character in the English alphabet**, and append it to the original word.

For example, performing operation 1 on `"c"` generates `"cd"` and performing operation 1 on `"zb"` generates `"zbac"`.

**Return the value of the kth character** in word after performing all the operations.

## Input Format
- `k`: A positive integer representing the position of the character to find
- `operations`: An integer array where each element is either 0 or 1

## Output Format
- A string containing the kth character in the final word

## Examples

### Example 1
**Input:** `k = 5, operations = [0,0,0]`<br/>
**Output:** `"a"`<br/>

**Explanation:**
Initially, `word == "a"`. Alice performs the three operations as follows:
1. Appends `"a"` to `"a"`, word becomes `"aa"`
2. Appends `"aa"` to `"aa"`, word becomes `"aaaa"`
3. Appends `"aaaa"` to `"aaaa"`, word becomes `"aaaaaaaa"`

### Example 2
**Input:** `k = 10, operations = [0,1,0,1]`<br/>
**Output:** `"b"`<br/>

**Explanation:**
Initially, `word == "a"`. Alice performs the four operations as follows:
1. Appends `"a"` to `"a"`, word becomes `"aa"`
2. Appends `"bb"` to `"aa"`, word becomes `"aabb"`
3. Appends `"aabb"` to `"aabb"`, word becomes `"aabbaabb"`
4. Appends `"bbccbbcc"` to `"aabbaabb"`, word becomes `"aabbaabbbbccbbcc"`

## Constraints
- **1 <= k <= 10^14**
- **1 <= operations.length <= 100**
- **operations[i] is either 0 or 1**
- The input is generated such that word has **at least k characters** after all operations

## Notes
- The character **'z' can be changed to 'a'** in the second type of operation (wrapping around the alphabet)
- Due to the large constraint on k (up to 10^14), a direct simulation approach would be too slow and require an efficient algorithm

