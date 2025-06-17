# Solution Explanation

## Intuition
The problem asks us to find the minimum number of coins to remove such that the absolute difference between the number of coins in any two remaining piles is at most `k`. This implies that all remaining piles must have heights within a contiguous range `[X, X + k]` for some minimum height `X`. To minimize the coins removed, we should consider each unique `arr[i]` from the original array as a potential minimum height `X` for the final configuration.

## Approach
1.  **Sort the array**: Sorting `arr` in ascending order is crucial. It allows us to efficiently identify piles that need to be removed (those smaller than the chosen `X`) and piles that need to be reduced (those larger than `X + k`).
2.  **Precompute Suffix Sums**: Create a `subset` array (also known as a suffix sum array). `subset[j]` will store the sum of all elements from `arr[j]` to `arr[n-1]`. This allows us to calculate the sum of a range of elements efficiently in O(1) time, which is needed for computing the cost of reducing larger piles.
3.  **Iterate through possible minimum heights (`X`)**: Iterate through the sorted `arr` array. For each `arr[i]`, we assume it is the minimum height (`X`) of the final configuration.
    *   **Cost for removing piles from the left**: All piles `arr[0]` through `arr[i-1]` must be completely removed because they are smaller than our assumed minimum height `arr[i]`. We can maintain a running sum (`sum` in the code) of these elements.
    *   **Cost for reducing piles from the right**: For piles `arr[j]` where `j >= i`, they must fit within the range `[arr[i], arr[i] + k]`.
        *   Piles `arr[j]` such that `arr[i] <= arr[j] <= arr[i] + k` incur no removal/reduction cost.
        *   Piles `arr[j]` such that `arr[j] > arr[i] + k` must be reduced to `arr[i] + k`. The cost for each such pile is `arr[j] - (arr[i] + k)`. To sum these costs efficiently:
            *   Use binary search (`findUpper` helper function) to find the first index `ind` (in the range `[i, n-1]`) where `arr[ind]` is strictly greater than `arr[i] + k`.
            *   The sum of these piles that need reduction is `subset[ind]`.
            *   The target sum if all these piles were reduced to `arr[i] + k` would be `(n - ind) * (arr[i] + k)`.
            *   The total cost for reducing these piles is `subset[ind] - (n - ind) * (arr[i] + k)`.
    *   **Total Cost for current `X`**: The total cost for the current `X` (`arr[i]`) is `coinsRemovedFromLeft` (accumulated `sum`) + `costForReducingLargePiles`.
    *   **Update Minimum**: Update `minTotalCoinsRemoved` with the minimum of current total cost and previously found minimum.

## Algorithm
1.  Sort the input array `arr` in non-decreasing order.
2.  Create a suffix sum array `subset` of size `n`.
    *   Initialize `subset[n-1] = arr[n-1]`.
    *   For `j` from `n-2` down to `0`, calculate `subset[j] = arr[j] + subset[j+1]`.
3.  Initialize `minTotalCoinsRemoved = Integer.MAX_VALUE`.
4.  Initialize `coinsRemovedFromLeft = 0` (this variable accumulates the sum of `arr[0]` to `arr[i-1]`).
5.  Iterate `i` from `0` to `n-1`:
    *   Let `currentMaxHeightAllowed = arr[i] + k`.
    *   Use the `findUpper` helper function to find `indexOfFirstPileAboveMaxAllowed` in `arr` (within range `[i, n-1]`). This function returns the index of the first element strictly greater than `currentMaxHeightAllowed`, or -1 if none exists.
    *   If `indexOfFirstPileAboveMaxAllowed == -1`: (Meaning all piles from `arr[i]` to `arr[n-1]` are within `[arr[i], currentMaxHeightAllowed]`)
        *   The `currentTotalCost` for this `arr[i]` as minimum is `coinsRemovedFromLeft`.
        *   Update `minTotalCoinsRemoved = Math.min(minTotalCoinsRemoved, coinsRemovedFromLeft)`.
    *   Else (`indexOfFirstPileAboveMaxAllowed` is a valid index where reduction is needed):
        *   `costForReducingLargePiles = (long)subset[indexOfFirstPileAboveMaxAllowed] - (long)(n - indexOfFirstPileAboveMaxAllowed) * currentMaxHeightAllowed`.
        *   `currentTotalCost = coinsRemovedFromLeft + costForReducingLargePiles`.
        *   Update `minTotalCoinsRemoved = Math.min(minTotalCoinsRemoved, (int)currentTotalCost)`.
    *   Add `arr[i]` to `coinsRemovedFromLeft` for the next iteration: `coinsRemovedFromLeft += arr[i]`.
6.  Return `minTotalCoinsRemoved`.

### Helper Function `findUpper(arr, target, s, e)`:
*   Performs binary search on `arr` within indices `[s, e]` to find the smallest index `idx` such that `arr[idx] > target`.
*   Returns `idx` or -1 if no such element is found.

## Complexity
-   **Time Complexity**: O(N log N)
    *   Sorting the array: O(N log N).
    *   Precomputing suffix sums: O(N).
    *   The main loop runs N times. Inside the loop, the `findUpper` (binary search) takes O(log N) time. All other operations are O(1).
    *   Total time complexity: O(N log N + N * log N) = O(N log N).
-   **Space Complexity**: O(N)
    *   For the `subset` (suffix sum) array.

## Summary
The solution effectively explores all candidate minimum pile heights by iterating through the sorted array. For each candidate, it calculates the cost by summing coins from piles that are too small (and removed) and coins from piles that are too large (and reduced). The use of precomputed suffix sums and binary search ensures efficient calculation of costs for each candidate minimum, leading to an overall optimal time complexity.

```java
class Solution {
    public int minimumCoins(int[] arr, int k) {
        
        int n=arr.length;
        Arrays.sort(arr);
        
        // Precompute suffix sums for efficient calculation of sums of sub-arrays
        int[] subset = new int[n];
        subset[n-1] = arr[n-1];
        for(int i = n - 2 ; i >= 0 ; i--){
            subset[i] = arr[i] + subset[i+1];
        }
        
        int minTotalCoinsRemoved = Integer.MAX_VALUE;
        // This variable keeps track of the sum of coins in piles that are
        // to the left of the current 'arr[i]' (which is chosen as the minimum height)
        // and thus must be entirely removed.
        int coinsRemovedFromLeft = 0; 
        
        for(int i = 0; i < n; i++){
            // For the current iteration, arr[i] is considered as the minimum height
            // for the final set of piles.
            // So, any pile smaller than arr[i] (which are arr[0]...arr[i-1] after sorting)
            // must be removed. The sum of these is 'coinsRemovedFromLeft'.

            // The target maximum height for piles that remain is arr[i] + k.
            int currentMaxHeightAllowed = arr[i] + k;
            
            // Find the index of the first pile that is strictly greater than currentMaxHeightAllowed.
            // This 'ind' marks the beginning of the segment of piles that are too tall.
            int ind = findUpper(arr, currentMaxHeightAllowed, i, n - 1);
            
            long currentTotalCost;
            
            if(ind == -1){ 
                // Case 1: All piles from arr[i] to arr[n-1] are within the allowed range [arr[i], arr[i] + k].
                // No piles need to be reduced from the right.
                currentTotalCost = coinsRemovedFromLeft;
            } else { 
                // Case 2: There are piles from arr[ind] to arr[n-1] that are too tall
                // and need to be reduced to currentMaxHeightAllowed.
                // The sum of these piles is subset[ind].
                // The ideal sum if they were all reduced to currentMaxHeightAllowed is (n - ind) * currentMaxHeightAllowed.
                // The cost of reduction is their actual sum minus their ideal sum.
                long costForReducingLargePiles = (long)subset[ind] - ((long)(n - ind) * currentMaxHeightAllowed);
                currentTotalCost = coinsRemovedFromLeft + costForReducingLargePiles;
            }
            
            minTotalCoinsRemoved = Math.min(minTotalCoinsRemoved, (int)currentTotalCost);
            
            // Add arr[i] to coinsRemovedFromLeft for the next iteration.
            // In the next iteration, arr[i+1] will be the minimum height,
            // so arr[i] would also need to be removed.
            coinsRemovedFromLeft += arr[i]; 
        }
        
        return minTotalCoinsRemoved;
    }
    
    // Helper function: Finds the index of the first element in arr[s...e]
    // that is strictly greater than 'target'. Returns -1 if no such element exists.
    static int findUpper(int[] arr, int target, int s, int e){
        int ans = -1; // Default: no element found
        
        while(s <= e){
            int mid = s + (e - s) / 2;
            
            if(arr[mid] > target){
                ans = mid; // This is a potential candidate, try to find an even smaller one to its left
                e = mid - 1;
            } else {
                // arr[mid] <= target, so we need to look in the right half
                s = mid + 1; 
            }   
        }
        
        return ans;
    }
}
```
