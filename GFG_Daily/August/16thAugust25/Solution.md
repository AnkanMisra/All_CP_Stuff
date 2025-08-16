
# Solution Explanation

## Intuition
To form the **largest possible number**, we need to arrange the numbers such that when concatenated, they produce the maximum value. The key insight is that we cannot simply sort numbers in descending order because `30` should come after `3` (since `330 < 303`), but `9` should come before `5` (since `95 > 59`). We need a **custom comparison strategy** that determines the optimal order by comparing concatenated results.

## Approach
1. **Convert integers to strings** to enable string concatenation and comparison
2. **Sort using custom comparator**: For any two strings `a` and `b`, compare `b+a` with `a+b` and arrange them based on which concatenation produces a larger value
3. **Handle edge case**: If the largest element after sorting is `"0"`, return `"0"` (handles arrays with all zeros)
4. **Concatenate all sorted strings** to form the final result

## Algorithm
1. Create a string array from the input integer array
2. Sort the string array using comparator `(a,b) -> (b+a).compareTo(a+b)`
3. Check if the first element is `"0"` - if yes, return `"0"`
4. Use StringBuilder to concatenate all strings in the sorted order
5. Return the final concatenated string

## Complexity
- **Time Complexity:** `O(n log n * m)` where `n` is the number of elements and `m` is the average length of string representations
- **Space Complexity:** `O(n * m)` for storing the string array and StringBuilder

## Summary
The **custom comparator approach** works because it directly tests which arrangement of two numbers produces a larger concatenated value. This greedy strategy is optimal because if `b+a > a+b`, then placing `b` before `a` will always contribute to a larger final number. The **edge case handling** ensures that arrays containing only zeros return `"0"` instead of multiple zeros.
```java
class Solution {
    public String findLargest(int[] arr) {
        String[] strarr = new String[arr.length];
        for(int i=0;i<strarr.length;i++) {
            strarr[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(strarr,(a,b)->(b+a).compareTo(a+b));
        if(strarr[0].equals("0"))
            return "0";
        StringBuilder str = new StringBuilder();
        for(String s: strarr) {
            str.append(s);
        }
        return str.toString();
    }
}
```
