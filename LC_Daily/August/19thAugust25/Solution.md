

# Solution Explanation

## Intuition
Every maximal stretch of consecutive `0`s of length `k` forms
`k × (k + 1) / 2` zero-filled subarrays.
Instead of computing this formula for every block explicitly,
we can accumulate the answer **on the fly** while scanning the array.

## Approach
1. Initialise two variables:
   • `ans` – total number of zero-filled subarrays found so far.
   • `run` – length of the current consecutive `0` run.
2. Traverse `nums` from left to right.
   • If the element is `0`, increment `run` (the current run extends) and
     add `run` to `ans` (the new `0` forms `run` additional subarrays
     ending at this position).
   • Otherwise, reset `run` to `0` (the zero run is broken).
3. After the loop, `ans` contains the required count.

## Complexity
- **Time Complexity:** `O(n)` – single pass through the array.
- **Space Complexity:** `O(1)` – only constant extra variables.

## Summary
By incrementally tracking the length of the current zero streak and
adding it to the answer at each `0`, we implicitly sum
`k × (k + 1) / 2` for every block without extra passes, achieving an
optimal linear-time, constant-space solution.
```java
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0,continuity=0;
        for(int i:nums)
        {
            if(i==0)
            {
                continuity++;
                ans=ans+continuity;
            }
            else
            {
                continuity=0;
            }
        }
        return ans;
    }
}
```

