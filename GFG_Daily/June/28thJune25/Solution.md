# Solution Explanation

## Intuition
The core idea is to efficiently count elements less than or equal to a given number. A brute-force approach of iterating through array `b` for each element in `a` would be too slow (O(N*M)). Instead, we can use a frequency array combined with prefix sums to achieve a faster solution.

## Approach
1.  **Find Maximum Value:** Determine the `maxVal` present in both arrays `a` and `b`. This will define the size of our frequency array.
2.  **Populate Frequency Array:** Create a `freq` array of size `maxVal + 1`. Iterate through array `b` and increment `freq[num]` for each `num` encountered in `b`. This `freq` array now stores the exact count of each number from `b`.
3.  **Compute Prefix Sums:** Iterate from `i = 1` to `maxVal` and update `freq[i] += freq[i - 1]`. After this step, `freq[i]` will store the total count of elements in `b` that are less than or equal to `i`.
4.  **Generate Result:** For each `num` in array `a`, the count of elements in `b` less than or equal to `num` can be directly retrieved from `freq[num]`. Add this value to the `result` `ArrayList`.

## Complexity
-   **Time Complexity:** O(N + M + maxVal).
    -   Finding `maxVal`: O(N + M)
    -   Populating frequency array: O(M)
    -   Computing prefix sums: O(maxVal)
    -   Generating result: O(N)
-   **Space Complexity:** O(maxVal) for the frequency array.

## Summary
By leveraging a frequency array and prefix sums, we transform the counting problem into a constant-time lookup for each element in array `a` after an initial linear preprocessing step. This makes the solution efficient for large input sizes within the given constraints.

```java
class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        int maxVal = 0;
        for (int num : a) maxVal = Math.max(maxVal, num);
        for (int num : b) maxVal = Math.max(maxVal, num);
        
        int[] freq = new int[maxVal + 1];
        
        for (int num : b){
            freq[num]++;
        }
        
        for(int i=1; i <= maxVal; i++){
            freq[i] += freq[i - 1];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : a){
            result.add(freq[num]);
        }
        
        return result;
    }
}
```
