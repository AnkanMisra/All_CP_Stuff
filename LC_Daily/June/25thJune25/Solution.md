# Solution Explanation

## Intuition
The problem asks for the kth smallest product of pairs formed by multiplying elements from two sorted arrays. The brute-force approach of generating all products and sorting is infeasible due to the large constraints. The key insight is to use **binary search** on the value of the product, leveraging the sorted nature of the arrays to efficiently count how many products are less than a given value.

## Approach
1. **Binary Search on Product Value:**  
   - Set a search range for possible product values (from -1e10 to 1e10).
   - For each mid-value in the search, count how many products are less than this value using a helper function.
   - If the count is less than k, move the search range up; otherwise, move it down.
   - The answer is the largest value for which the count is less than k.

2. **Counting Function:**  
   - For each element in `nums1`, use binary search on `nums2` to count how many products with this element are less than the current mid-value.
   - If the element is non-negative, the products increase as you move right in `nums2`.
   - If the element is negative, the products decrease as you move right in `nums2`, so the binary search logic is reversed.

## Complexity
- **Time Complexity:** O(n log m log X), where n = nums1.length, m = nums2.length, and X is the range of possible product values (since each binary search on value does O(n log m) work).
- **Space Complexity:** O(1) extra space.

## Summary
**By using binary search on the product value and efficiently counting the number of products less than a given value, we can find the kth smallest product in optimal time.**  
This approach leverages the sorted property of the arrays and avoids generating all possible products.

```java
// Tc = O(nlogm)   => dependent on count function

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = (long)-1e10, high = (long)1e10;
        
        while(low <= high){
            long dotProduct = (low+high)/2;
            if(countNoOfElements(nums1, nums2, dotProduct) < k) 
                low = dotProduct+1;
            else
                high = dotProduct-1;
        }
        return low;
    }
    
    private long countNoOfElements(int[] nums1, int[] nums2, long dotProduct){  // this function will return the no. of elements(after product) which are less than dotProduct
        long count = 0;
        for(int element : nums1){
            if(element >= 0){     // if positive
                int low = 0, high = nums2.length;  // binary search on nums2
                while(low < high){
                    int mid = (low+high)/2;
                    if((long)element * nums2[mid] < dotProduct)
                        low = mid+1;
                    else
                        high = mid;
                }
               count += low;    // no. of elements after product with element smaller than dotproduct
            }
            else{          // if negative  => binary search in some reverse order
                int low = 0, high = nums2.length;
                while(low < high){
                    int mid = (low+high)/2;
                    if((long) element * nums2[mid] >= dotProduct)
                        low = mid+1;
                    else
                        high = mid;
                }
                count += nums2.length - low;   // in negative element case smaller element will be on right side
            }
        }
        return count;
    }
}
