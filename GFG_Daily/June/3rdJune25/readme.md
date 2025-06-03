# Substrings with K Distinct

Given a string consisting of lowercase characters and an integer `k`, the task is to count all possible substrings (not necessarily distinct) that have exactly `k` distinct characters.

---

## Examples

### Example 1

**Input:**  
s = "abc", k = 2

**Output:**  
2

**Explanation:**  
Possible substrings are ["ab", "bc"]

---

### Example 2

**Input:**  
s = "aba", k = 2

**Output:**  
3

**Explanation:**  
Possible substrings are ["ab", "ba", "aba"]

---

### Example 3

**Input:**  
s = "aa", k = 1

**Output:**  
3

**Explanation:**  
Possible substrings are ["a", "a", "aa"]

---

## Constraints

- 1 ≤ s.size() ≤ 10^6
- 1 ≤ k ≤ 26
