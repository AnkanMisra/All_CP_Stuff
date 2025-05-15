# Solution Explanation

## Intuition

For each element in the array, we want to find the next element to its right that is divisible by it.  
A brute-force approach would check every pair, but that would be too slow for large arrays.

Instead, we can use a **preprocessing and bucket-based approach**:
- For each value, keep track of the indices where it appears and which elements are waiting for a divisible value.
- As we process the array from left to right, for each value, we update all indices that are waiting for a value divisible by it.

## Approach

1. **Initialization:**
   - Create an answer array `c` initialized to `-1` for all positions.
   - Find the maximum value in the array for sizing buckets.

2. **Preprocessing:**
   - For each possible value up to the maximum, precompute all its divisors and store them in a list `g`.

3. **Processing:**
   - For each element in the array (from left to right):
     - For each divisor of the current value, check if there are indices waiting for this divisor (using `h`).
     - If so, set their answer to the current value and clear their waiting list.
     - Add the current index to the waiting list for its own value.

4. **Result:**
   - Return the answer array.

## Complexity

- **Time Complexity:**  
  \(O(n \sqrt{maxA})\), where \(n\) is the array length and \(maxA\) is the maximum value in the array, due to divisor enumeration and processing.
- **Space Complexity:**  
  \(O(n + maxA)\) for the answer array and buckets.