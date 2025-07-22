
# Problem: Smallest Positive Missing

## Problem Description
You are given an integer array `arr[]`. Your task is to find the **smallest positive number missing** from the array.

**Note:** Positive numbers start from `1`. The array can have negative integers too.

## Input Format
- The first line contains an integer `n`, the size of the array.
- The second line contains `n` space-separated integers representing the elements of `arr[]`.

## Output Format
- Print the **smallest positive number missing** from the array.

## Examples

### Input
`arr[] = [2, -3, 4, 1, 1, 7]`<br/>

### Output
`3`<br/>

**Explanation:** Smallest positive missing number is `3`.

### Input
`arr[] = [5, 3, 2, 5, 1]`<br/>

### Output
`4`<br/>

**Explanation:** Smallest positive missing number is `4`.

### Input
`arr[] = [-8, 0, -1, -4, -3]`<br/>

### Output
`1`<br/>

**Explanation:** Smallest positive missing number is `1`.

## Constraints
- **1 ≤ arr.size() ≤ 10^5**
- **-10^6 ≤ arr[i] ≤ 10^6**

## Notes
- Focus on finding the **smallest positive integer** not present in the array.

