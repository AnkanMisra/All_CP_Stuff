# ✅ Solution Explanation: Substrings with Same First and Last Characters

## 🧠 Problem Recap

We need to count all substrings of a given string `s` where the first and last characters are the same.

---

## 🧪 Intuition

- Every time we encounter a character, it can form substrings with all its previous occurrences **plus itself**.
- So, if we count how many times each character appears as we iterate through the string, we can:
  - Add the current count of that character to our answer (because that many substrings can end here with this character as start and end).

---

## 🪜 Step-by-Step Process

1. Initialize a `HashMap<Character, Integer>` to store the frequency of each character.
2. Initialize `count = 0` to store the final answer.
3. Loop through each character `ch` in the string:
   - Add `map.get(ch)` (number of times `ch` occurred so far) to `count`.
   - Then, increment `map[ch]` by 1.
4. Return `count`.

---

## 💡 Why This Works

- When a character appears at index `i`, all previous appearances of that same character (say `k` times) mean there are `k` substrings ending at `i` which start and end with that character.
- Also, the character itself forms a valid 1-length substring.

---

## ✅ Code

```java
class Solution {
    public int countSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(26);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Add current frequency of this character to count
            count += map.getOrDefault(ch, 0);

            // Update the frequency in the map
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return count;
    }
}
```

---

## ⏱️ Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the string
- **Space Complexity:** `O(1)` (since max 26 lowercase letters)

---

## 📌 Example

For `s = "aba"`:

| Index | Char | Map State        | Count Added | Total Count |
|-------|------|------------------|-------------|-------------|
| 0     | a    | {a:1}            | 0           | 0           |
| 1     | b    | {a:1, b:1}       | 0           | 0           |
| 2     | a    | {a:2, b:1}       | 1           | 1           |

Then add all 1-length substrings (`a`, `b`, `a`) → Total = 3  
Add 1 from above (substring "aba") → Final answer = **4**