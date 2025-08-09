
# Solution Explanation

## Intuition
The key insight is that for the condition `mex([ai, ai+1, ai+2]) = max([ai, ai+1, ai+2]) - min([ai, ai+1, ai+2])` to hold for **all consecutive triplets**, the array must have very specific properties. After analyzing the mathematical constraints, we find that an array can be made "good" only in very limited scenarios.

## Approach
The solution uses a **pattern recognition approach** based on the unique values present in the non-missing elements:

1. **Collect all unique non-missing values** from the array into a set
2. **Analyze the set size** to determine if the array can be made good:
   - If the set is **empty** (all elements are `-1`): We can fill all positions with the same positive value, making the array good
   - If the set has **exactly one unique value** and that value is **greater than 0**: We can potentially make the array good by filling missing positions appropriately
   - If the set has **multiple unique values** or contains **0**: The array cannot be made good due to the MEX constraint conflicts

## Algorithm
1. Read the array and store all **non-missing unique values** in a set
2. Check the set properties:
   - **Empty set**: Return "YES"
   - **Single element > 0**: Return "YES"
   - **Otherwise**: Return "NO"

## Complexity
- **Time Complexity:** `O(n)` where `n` is the array length
- **Space Complexity:** `O(n)` for storing unique values in the set

## Summary
This approach works because the MEX condition is extremely restrictive. When multiple distinct values are present, it becomes impossible to satisfy the MEX equation for all consecutive triplets simultaneously. The solution efficiently identifies the **only two scenarios** where the array can be made good: when all elements can be set to the same positive value, or when there's already a single positive value that can be extended to fill the missing positions.

