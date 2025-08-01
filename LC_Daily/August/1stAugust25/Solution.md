
# Solution Explanation

## Intuition
Pascal's triangle has a **fundamental property**: each number is the sum of the two numbers directly above it. The **first and last elements** of each row are always `1`. We can build the triangle **row by row**, where each new row depends only on the previous row.

## Approach
We use a **dynamic programming approach** to build Pascal's triangle incrementally:

1. **Initialize** the result with the first row `[1]`
2. **For each subsequent row** from `1` to `numRows-1`:
   - Start the current row with `1`
   - **Calculate middle elements** by summing adjacent pairs from the previous row
   - End the current row with `1`
   - Add the completed row to the result

## Algorithm
1. Create a `List<List<Integer>>` to store the triangle
2. Add the first row `[1]` to the result
3. For each row `i` from `1` to `numRows-1`:
   - Create a new `currentRow` list
   - Add `1` as the first element
   - For each position `j` from `1` to `i-1`:
     - Calculate `prevRow[j-1] + prevRow[j]` and add to `currentRow`
   - Add `1` as the last element
   - Add `currentRow` to the result
4. Return the complete triangle

## Complexity
- **Time Complexity:** `O(numRows²)` - We generate `numRows` rows, and row `i` has `i+1` elements
- **Space Complexity:** `O(numRows²)` - The output triangle contains `numRows*(numRows+1)/2` total elements

## Summary
This approach works because **Pascal's triangle follows a predictable pattern** where each row can be constructed from the previous row. The algorithm handles the **base case** (first row) separately and then uses the **recurrence relation** to build subsequent rows. **Corner cases** like `numRows = 1` are naturally handled since we initialize with the first row and the loop doesn't execute for single-row cases.

