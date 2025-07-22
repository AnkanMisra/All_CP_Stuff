
# Solution Explanation

## Intuition
The **smallest positive missing number** is the first positive integer not present in the array. By sorting the array and scanning for gaps, we can efficiently identify this missing value.

## Approach
- **Sort** the array to bring all numbers in order, making it easier to find missing positives.
- **Search for `1`**: If `1` is not present, then `1` is the answer.
- **Scan for gaps**: Starting from the first occurrence of `1`, iterate through the array and check if each next positive number is exactly one greater than the previous (ignoring duplicates). If not, the missing number is `prev + 1`.
- **Handle edge cases**: If all numbers are consecutive up to the end, the answer is the last positive number plus one.

## Complexity
- **Time Complexity:** `O(n log n)` (due to sorting)
- **Space Complexity:** `O(1)` (if sorting is in-place)

## Summary
This approach works because sorting allows us to efficiently detect the first gap in the sequence of positive numbers. By focusing only on positive values and handling duplicates, we ensure the **smallest missing positive integer** is found. Edge cases, such as arrays with only negatives or missing `1`, are naturally handled by the initial checks.

