
# Solution Explanation

### Intuition

We are asked to find the sum of all possible substrings of a given number represented as a string. For each possible substring, we convert it to an integer and add it to the total sum.

### Approach

- Convert the string into an array of digits.
- For every possible substring (from every start index to every end index), build the number and add it to the sum.
- Use three nested loops:
  - The outer loop selects the length of the substring.
  - The middle loop selects the starting index.
  - The inner loop builds the number from the substring.
- Accumulate the sum of all such numbers and return the result.

### Code

```java
class Solution {
    public static int sumSubstrings(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = '0' - s.charAt(i);
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                int num = 0;
                for (int k = j; k < j + i + 1; k++) {
                    num = (num * 10) + arr[k];
                }
                count += num;
            }
        }
        return Math.abs(count);
    }
}
```

### Complexity

- **Time Complexity:** O(n^3), where n is the length of the string (due to three nested loops).
- **Space Complexity:** O(n), for the digit array.

### Summary

- The solution generates all possible substrings, converts them to integers, and sums them up.
- This brute-force approach is acceptable for small strings (n ≤ 9).
- The code uses absolute value to ensure the result is positive, as the digit array is built with negative values.
