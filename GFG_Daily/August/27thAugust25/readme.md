
# Problem: Count the Number of Possible Triangles

## Problem Description
Given an integer array `arr[]`, find the **number of triangles** that can be formed with three different array elements as lengths of three sides of the triangle. A triangle with three given sides is only possible if **sum of any two sides is always greater than the third side**.

## Input Format
An integer array `arr[]` containing the lengths of potential triangle sides.

## Output Format
Return an integer representing the **total number of valid triangles** that can be formed.

## Examples

### Input

`arr[] = [4, 6, 3, 7]`<br/>

### Output

`3`<br/>

**Explanation:** There are three triangles possible `[3, 4, 6]`, `[4, 6, 7]` and `[3, 6, 7]`. Note that `[3, 4, 7]` is not a possible triangle.

### Input

`arr[] = [10, 21, 22, 100, 101, 200, 300]`<br/>

### Output

`6`<br/>

**Explanation:** There can be 6 possible triangles: `[10, 21, 22]`, `[21, 100, 101]`, `[22, 100, 101]`, `[10, 100, 101]`, `[100, 101, 200]` and `[101, 200, 300]`.

### Input

`arr[] = [1, 2, 3]`<br/>

### Output

`0`<br/>

**Explanation:** No triangles are possible.

## Constraints
- **1 ≤ arr.size() ≤ 10³**
- **0 ≤ arr[i] ≤ 10⁵**

