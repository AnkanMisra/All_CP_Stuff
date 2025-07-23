
# Solution Explanation

## Intuition
To find the sum of all subarrays, observe that each element contributes to several subarrays depending on its position. By calculating each element's total contribution, we can efficiently compute the answer without generating all subarrays.

## Approach
- For each element at index `i` in the array of size `n`, it appears in `(i + 1) * (n - i)` subarrays.
- Multiply each element by its number of appearances and sum up these contributions for all elements.

## Complexity
- Time Complexity: `O(n)`
- Space Complexity: `O(1)`

## Summary
This approach leverages the observation that each element's contribution can be computed directly, resulting in an efficient solution that avoids redundant calculations and works well within the given constraints.

```java
class Solution { 
    public int subarraySum(int[] arr)  
    {  
        int len = arr.length;  
        int sum  = 0;  
        for(int i=0;i<len;i++)  
        {  
            sum+=arr[i]*(i+1)*(len-i);  
        }  
        return sum;  
    }  
}  
```

