# Solution Explanation

## Intuition
Each row is sorted, but the whole matrix is not.
If we could count, for any value `x`, how many elements are `≤ x`, we could binary-search on the **value range** to find the first `x` such that at least half of the elements are `≤ x`.
That `x` is precisely the median.

## Approach
1. **Search range**: the smallest possible element is `1`, the largest is `2000` (from constraints).
2. **Binary search on value** within this range.
   - Let `mid` be the current value.
   - For every row, the position of the first element `>` `mid` can be found with an upper-bound binary search (because the row is sorted).
   - Summing these positions over all rows gives `cnt =` number of elements `≤ mid` in the whole matrix.
3. **Decision rule**:
   - The matrix has `n × m` elements; its median (0-based) is at index `(n × m) / 2`.
   - If `cnt ≤ (n × m) / 2`, too few elements are `≤ mid` &rarr; median is larger &rarr; move *right* (`low = mid + 1`, keep `ans = mid`).
   - Otherwise median is smaller &rarr; move *left* (`high = mid − 1`).
4. The loop finishes when `low > high`; the last stored `ans` is the median.

## Algorithm (pseudo)
1. `low = 1, high = 2000, need = (n × m) / 2, ans = -1`
2. while `low ≤ high`
   1. `mid = (low + high) / 2`
   2. `cnt = 0`
   3. for each row `r`: `cnt += upperBound(r, mid)`
   4. if `cnt ≤ need`: `ans = mid, low = mid + 1`
      else: `high = mid - 1`
3. return `ans`.

*`upperBound(row, x)` returns the index of the first element `> x` in `row`, i.e., the count of elements `≤ x`.*

## Complexity
- **Time Complexity:**
  - Outer binary search over value range: `log(2000) ≈ 11` iterations.
  - For each iteration we process `n` rows, each upper-bound search costs `log m`.
  - Total: `O(log V × n × log m)` where `V = 2000`.
  - With constraints (`n, m ≤ 400`) this is `≈ 11 × 400 × 9 ≈ 40k` operations.
- **Space Complexity:** `O(1)` — only constant auxiliary variables.

## Summary
By leveraging the row-wise sorting we count elements `≤ x` in `O(log m)` per row.
Binary searching the *value space* pinpoints the smallest `x` that has at least half of all elements not exceeding it, which is exactly the median of the matrix.
```java
class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                list.add(mat[i][j]);
            }
        }

        Collections.sort(list);

        int ans = list.size()/2;

        return list.get(ans);
    }
}
```

