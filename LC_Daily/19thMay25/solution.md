# Solution Explanation

### Intuition

To determine the type of triangle (or if a triangle can be formed), we need to check:
- The triangle inequality: the sum of any two sides must be greater than the third.
- The number of equal sides to classify as equilateral, isosceles, or scalene.

### Approach

- First, check if the triangle inequality holds for all three pairs. If not, return `"none"`.
- If all three sides are equal, return `"equilateral"`.
- If all three sides are different, return `"scalene"`.
- Otherwise, return `"isosceles"` (exactly two sides are equal).

### Code

```java
class Solution {
    public String triangleType(int[] nums) {
        if(nums[0] >= nums[1] + nums[2] || nums[1] >= nums[0] + nums[2] || nums[2] >= nums[0] + nums[1]){
            return "none";
        }
        if(nums[0]==nums[1] && nums[1]==nums[2] && nums[2]==nums[0]){
            return "equilateral";
        }
        else if(nums[0]!=nums[1] && nums[1]!=nums[2] && nums[2]!=nums[0]){
            return "scalene";
        }
        return "isosceles";
    }
}
```

### Complexity

- **Time Complexity:** O(1), as only a constant number of checks are performed.
- **Space Complexity:** O(1), as no extra space is used.

### Summary

- The solution checks the triangle inequality and then classifies the triangle based on the number of equal sides.
- Returns the correct type or `"none"` if a triangle cannot be formed.
