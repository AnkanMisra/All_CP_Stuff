# 🧩 Problem: Substrings with Same First and Last Characters

**Difficulty:** Easy  
**Constraints:**  
- 1 ≤ |s| ≤ 10⁴  
- `s` contains only lowercase English alphabets (`a` to `z`)

---

## 📝 Description

You are given a string `s` consisting only of lowercase characters.  
Your task is to find the **total number of substrings** (contiguous sequences) that **start and end with the same character**.

---

## ✅ Examples

### Example 1:
**Input:**
```
s = "abcab"
```
**Output:**
```
7
```
**Explanation:**  
Valid substrings with the same starting and ending character:
- "a"
- "b"
- "c"
- "a" (at index 3)
- "b" (at index 4)
- "abca"
- "bcab"

### Example 2:
**Input:**
```
s = "aba"
```
**Output:**
```
4
```
**Explanation:**  
Valid substrings:
- "a"
- "b"
- "a" (at index 2)
- "aba"

---

## 🧠 Approach Hint

- Think about **how many times each character occurs** and how that can help count substrings.
- You can calculate the number of substrings using the formula for combinations based on character frequency.

---

## 🔁 Notes

- A single character is also considered a valid substring.
- The order of the characters matters as we are looking for substrings (not subsequences).