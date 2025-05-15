# 🧠 Solution Intuition: Longest Unequal Adjacent Groups Subsequence I

## 🎯 Goal Recap

We are given:
- An array of **distinct strings** `words[]`.
- An array of **binary group indicators** `groups[]`.

The goal is to form the **longest subsequence** from `words[]` such that:
- Consecutive selected elements have **different group values** (alternating between 0 and 1).

---

## 🧩 Thought Process

### ✅ Observations
- We only need to ensure that **no two adjacent elements in our selected subsequence** come from the **same group**.
- The order of elements in the subsequence must be **left to right** (since it's a subsequence).
- Since we’re not allowed to reorder, we must **greedily pick elements** that maintain the alternation.

---

## 🛠️ Approach (Greedy + One Pass)

1. **Initialize** a list and **always include the first word** (since we have to start somewhere).
2. Traverse from the second word onward:
   - For each index `i`, **compare `groups[i]` with `groups[i - 1]`**.
   - If they differ, it means the current word can be added to the subsequence while maintaining the alternate group pattern.
3. Return the built list.

This is a **greedy approach** — always making the local best decision (i.e., add the word if it alternates group from the previous one).

---

## 📦 Java Implementation

```java
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        List<String> list = new ArrayList<>();
        list.add(words[0]); // Start with the first word

        for(int i = 1; i < n; i++) {
            // Add word only if its group differs from the previous one
            if(groups[i] != groups[i - 1]) {
                list.add(words[i]);
            }
        }

        return list;
    }
}
```

---

## ⏱️ Time and Space Complexity

- **Time Complexity:** `O(n)` – single pass through the arrays.
- **Space Complexity:** `O(n)` – in the worst case, the output list could contain all elements.

---

## 🧪 Example Walkthrough

### Input:
```java
words  = ["a", "b", "c", "d"];
groups = [1, 0, 1, 1];
```

### Steps:
- Start with `"a"` (group 1).
- Next `"b"` (group 0) → differs → ✅ include
- Next `"c"` (group 1) → differs → ✅ include
- Next `"d"` (group 1) → same as previous → ❌ skip

### Result:
```java
["a", "b", "c"]
```

---

## 💡 Final Thoughts

This problem showcases how greedy algorithms can solve a pattern-based sequence problem efficiently when the constraints and requirements align well with a forward pass and local decisions. 🎯
```