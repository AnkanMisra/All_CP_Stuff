
# Problem: Balancing Consonants and Vowels Ratio

## Problem Description
You are given an array of strings `arr[]`, where each `arr[i]` consists of lowercase english alphabets. You need to find the **number of balanced strings** in `arr[]` which can be formed by **concatenating one or more contiguous strings** of `arr[]`.

A **balanced string** contains the **equal number of vowels and consonants**.

## Input Format
An array of strings `arr[]` where each string consists of lowercase English alphabets.

## Output Format
Return an integer representing the **number of balanced substrings** that can be formed.

## Examples

### Input

`arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]`<br/>

### Output

`4`<br/>

**Explanation:** `arr[0..4]`, `arr[1..2]`, `arr[1..3]`, `arr[3..3]` are the balanced substrings with equal consonants and vowels.

### Input

`arr[] = ["ab", "be"]`<br/>

### Output

`3`<br/>

**Explanation:** `arr[0..0]`, `arr[0..1]`, `arr[1..1]` are the balanced substrings with equal consonants and vowels.

### Input

`arr[] = ["tz", "gfg", "ae"]`<br/>

### Output

`0`<br/>

**Explanation:** There is no such balanced substring present in `arr[]` with equal consonants and vowels.

## Constraints
- **1 ≤ arr.size() ≤ 10^5**
- **1 ≤ arr[i].size() ≤ 10^5**
- **Total number of lowercase english characters in arr[] is lesser than 10^5**

