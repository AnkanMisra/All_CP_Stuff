
# Solution Explanation

## Intuition
To **maximize the number**, we need to make the **leftmost digit as large as possible**. Since we can only change at most one digit and the number consists only of `6` and `9`, the optimal strategy is to find the **first occurrence of `6` from left to right** and change it to `9`. This gives us the maximum possible increase in value.

## Approach
The solution uses a **greedy approach** with string manipulation:

1. **Convert the integer to string** for easy character access and manipulation
2. **Iterate through each digit from left to right** to find the first `6`
3. **Replace the first `6` with `9`** and immediately return the result
4. **If no `6` is found**, return the original number (all digits are `9`)

## Algorithm
1. Convert `num` to string representation
2. Loop through each character in the string:
   - If current character is `6`, replace it with `9` and convert back to integer
   - Return this maximized number immediately
3. If loop completes without finding any `6`, return the original `num`

## Complexity
- **Time Complexity:** `O(d)` where `d` is the number of digits in `num`
- **Space Complexity:** `O(d)` for the string representation of the number

## Summary
This **greedy approach** works because changing the leftmost `6` to `9` provides the maximum increase in value. Since we can change at most one digit, we don't need to consider multiple changes. The algorithm handles the edge case where all digits are `9` by returning the original number unchanged. The solution is efficient and straightforward, making only one pass through the digits.
```java
class Solution {
    public int maximum69Number (int num) {
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '6') {
                return Integer.parseInt(numStr.substring(0, i) + '9' + numStr.substring(i + 1));
            }
        }
        return num;
    }
}
```

