
# Problem: Minimum Sum Partition

## Problem Description
Given an array `arr[]` containing **non-negative integers**, the task is to **divide it into two sets** `set1` and `set2` such that the **absolute difference between their sums is minimum** and find the **minimum difference**.

## Input Format
An array `arr[]` of non-negative integers.

## Output Format
Return the **minimum absolute difference** between the sums of two subsets.

## Examples

### Input

`arr[] = [1, 6, 11, 5]`<br/>

### Output

`1`<br/>
**Explanation:**
Subset1 = `{1, 5, 6}`, sum of Subset1 = `12`
Subset2 = `{11}`, sum of Subset2 = `11`
Hence, **minimum difference is 1**.

### Input

`arr[] = [1, 4]`<br/>

### Output

`3`<br/>
**Explanation:**
Subset1 = `{1}`, sum of Subset1 = `1`
Subset2 = `{4}`, sum of Subset2 = `4`
Hence, **minimum difference is 3**.

### Input

`arr[] = [1]`<br/>

### Output

`1`<br/>
**Explanation:**
Subset1 = `{1}`, sum of Subset1 = `1`
Subset2 = `{}`, sum of Subset2 = `0`
Hence, **minimum difference is 1**.

## Constraints
- **1 ≤ arr.size() * |sum of array elements| ≤ 10^5**
- **1 ≤ arr[i] ≤ 10^5**

