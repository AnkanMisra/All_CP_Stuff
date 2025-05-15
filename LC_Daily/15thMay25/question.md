# 📘 Problem: Longest Unequal Adjacent Groups Subsequence I

## 🧩 Description

You are given:

- A string array `words` of length `n`.
- A binary array `groups` of the same length `n`, where each `groups[i]` is either `0` or `1`.

Each element `words[i]` is associated with the value `groups[i]`.

Your goal is to **select the longest possible subsequence** from `words` such that **no two consecutive elements in the selected subsequence have the same group value**. In other words, the group values should **alternate** between `0` and `1`.

### 🧠 Key Definitions

- A **subsequence** is a sequence that can be derived from another sequence by deleting some or no elements, without changing the order of the remaining elements.
- A **valid alternating subsequence** satisfies:
  ```
  For all consecutive elements in the subsequence:
  groups[i_j] != groups[i_{j+1}]
  ```

> If there are multiple valid subsequences of maximum length, return any one of them.

### 📝 Notes

- Elements in `words` are **distinct**.
- All strings in `words` contain only lowercase English letters.
- The binary values in `groups` are either `0` or `1`.

---

## 📥 Input

- `words`: `string[]` of length `n` (1 ≤ `n` ≤ 100)
- `groups`: `int[]` of length `n` (with each element being either 0 or 1)

---

## 📤 Output

- Return a `List<String>` representing the longest subsequence of `words` that satisfies the condition that adjacent elements in the sequence belong to different groups.

---

## 🔍 Examples

### Example 1
```
Input:
words  = ["e", "a", "b"]
groups = [0, 0, 1]

Output:
["e", "b"] or ["a", "b"]
```

Explanation: 
- You can select `["e", "b"]` (groups 0 -> 1)
- Or `["a", "b"]` (groups 0 -> 1)
- Length of both valid subsequences is 2

---

### Example 2
```
Input:
words  = ["a", "b", "c", "d"]
groups = [1, 0, 1, 1]

Output:
["a", "b", "c"] or ["a", "b", "d"]
```

Explanation:
- `["a", "b", "c"]` is valid: groups 1 → 0 → 1
- So is `["a", "b", "d"]`: groups 1 → 0 → 1

---

## ✅ Constraints

- `1 <= n == words.length == groups.length <= 100`
- `1 <= words[i].length <= 10`
- `groups[i] ∈ {0, 1}`
- All strings in `words` are **distinct**
- `words[i]` contains only lowercase English letters

---

## 💡 Hint

Try building the alternating subsequence greedily from left to right by always adding the current word if its group differs from the last added word's group.
```