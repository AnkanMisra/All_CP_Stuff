
# Solution Explanation

## Intuition
To **maximize the sum of all query replies**, the core idea is to assign the **largest numbers** from the input array to the array positions that are included in the **most queries**. Conversely, the smallest numbers should be placed in positions that are included in the fewest queries. This greedy strategy ensures that the most valuable numbers contribute as frequently as possible to the total sum.

The problem, therefore, breaks down into two main parts:
1.  Finding out how many times each array index is included in a query.
2.  Pairing the highest values with the highest frequencies.

## Approach
1.  **Frequency Calculation using a Difference Array:**
    - We need to find the frequency of each index `i` (from `0` to `n-1`) across all `q` queries. A naive approach would be too slow (`O(n*q)`).
    - A more efficient method is to use a **difference array** (let's call it `count`) of size `n+1`.
    - For each query `(li, ri)` (using 1-based indexing from the problem), we perform two operations:
        - Increment `count[li - 1]` by `1`. This marks the start of a range where each index's frequency increases by one.
        - If `ri < n`, decrement `count[ri]` by `1`. This marks the end of the range. The effect of the increment at `li-1` is canceled out from index `ri` onwards.
2.  **Prefix Sum to Get Final Frequencies:**
    - After processing all `q` queries, we can compute the actual frequency for each index by taking the prefix sum of the `count` array.
    - Let `frequency[i]` be the final frequency. `frequency[0] = count[0]`, and `frequency[i] = frequency[i-1] + count[i]` for `i > 0`.
    - Now, `frequency[i]` holds the total number of queries that include index `i`.
3.  **Optimal Pairing for Maximum Sum:**
    - To get the maximum total sum, we sort the original input array `a` in **non-decreasing order**.
    - We also sort the `frequency` array in **non-decreasing order**.
    - The maximum sum is then the sum of the pairwise products: `sum(a[i] * frequency[i])` for all `i` from `0` to `n-1`. This ensures that the largest elements of `a` are multiplied by the largest frequencies.

## Complexity
- **Time Complexity:** `O(n log n + q)`
  - Building the difference array from `q` queries takes `O(q)`.
  - Calculating the final frequencies via prefix sum takes `O(n)`.
  - Sorting the input array and the frequency array takes `O(n log n)`.
  - Calculating the final dot product takes `O(n)`.
- **Space Complexity:** `O(n)`
  - To store the input array, the difference array, and the frequency array.

## Summary
The solution uses a **greedy approach** by pairing the largest values with the most frequently queried positions. The key to an efficient implementation is the use of a **difference array and prefix sums** to calculate the query frequencies for all indices in `O(n + q)` time, which is much better than a naive `O(n*q)` method. After sorting both the values and the frequencies, the maximum sum is computed by summing their pairwise products.

