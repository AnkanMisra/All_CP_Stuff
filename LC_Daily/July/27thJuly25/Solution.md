
# Solution Explanation

## Intuition
The key insight is to **identify groups of consecutive equal elements** and treat each group as a single unit. For each group, we need to find its **closest non-equal neighbors** on both sides. A group forms a **hill** if both neighbors are smaller, and a **valley** if both neighbors are larger.

## Approach
We can solve this by **removing consecutive duplicates** first, creating a simplified array where each element represents a group of equal values. Then we check each element (except the first and last) to see if it forms a hill or valley by comparing it with its immediate neighbors.

## Algorithm
1. **Create a simplified array** by removing consecutive duplicates from the original array
2. **Iterate through the simplified array** from index 1 to `length - 2` (excluding first and last elements)
3. For each element at index `i`:
   - Check if `simplified[i] > simplified[i-1]` and `simplified[i] > simplified[i+1]` (**hill condition**)
   - Check if `simplified[i] < simplified[i-1]` and `simplified[i] < simplified[i+1]` (**valley condition**)
   - If either condition is true, **increment the count**
4. **Return the total count** of hills and valleys

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the input array
- **Space Complexity:** `O(n)` for storing the simplified array (worst case when no consecutive duplicates exist)

## Summary
This approach works because **consecutive equal elements behave as a single unit** when determining hills and valleys. By removing duplicates first, we simplify the problem to checking local maxima and minima in the resulting array. The key insight is that elements at the **boundaries cannot form hills or valleys** since they lack neighbors on one side.

