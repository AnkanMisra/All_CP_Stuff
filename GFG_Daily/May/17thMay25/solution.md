# Solution for 17thMay25
# Solution Explanation

### Intuition

The problem asks us to apply a quadratic transformation to each element of a sorted array and then return the resulting array in sorted order. Since the transformation can change the order, we must recompute and sort the results.

### Approach

- Iterate through each element in the input array.
- For each element `x`, compute the value using the quadratic function: `A * x^2 + B * x + C`.
- Store each computed value in a list.
- Sort the list to get the final sorted transformed array.
- Return the sorted list.

### Code

```java
class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int eqq = (A * val * val) + (B * val) + C;
            list.add(eqq);
        }
        Collections.sort(list);
        return list;
    }
}
```

### Complexity

- **Time Complexity:** O(n log n), where n is the length of the array (due to sorting).
- **Space Complexity:** O(n), for storing the transformed values.

### Summary

- Each element is transformed using the given quadratic equation.
- The transformed values are sorted and returned as the final answer.
- This approach is simple and efficient for the given constraints.
