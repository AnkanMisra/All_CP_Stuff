# Solution Explanation

### Intuition

We need to find all indices of words in the array that contain the given character `x`.  
This is a straightforward search problem: for each word, check if it contains `x` and, if so, record its index.

### Approach

- Initialize an empty list to store the answer.
- Iterate through the `words` array.
- For each word, use the `indexOf` method to check if the character `x` is present.
- If `x` is found in the word, add the current index to the answer list.
- Return the list of indices.

### Code

```java
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) ans.add(i);
        }
        return ans;
    }
}
```

### Complexity

- **Time Complexity:** O(n * m), where n is the number of words and m is the average length of a word.
- **Space Complexity:** O(k), where k is the number of words containing the character `x`.

### Summary

- The solution checks each word for the presence of the character `x` and collects the indices.
- It is efficient and straightforward for the given constraints.
