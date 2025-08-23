
# Problem: Allocate Minimum Pages

## Problem Description
Given an array `arr[]` of integers, where each element `arr[i]` represents the **number of pages in the i-th book**. You also have an integer `k` representing the **number of students**. The task is to **allocate books to each student** such that:

- **Each student receives at least one book**
- **Each student is assigned a contiguous sequence of books**
- **No book is assigned to more than one student**

The objective is to **minimize the maximum number of pages assigned to any student**. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the **smallest possible maximum**.

## Input Format
- An array `arr[]` of integers representing pages in each book
- An integer `k` representing the number of students

## Output Format
- Return the **minimum possible maximum pages** assigned to any student
- Return **-1** if allocation is not possible

## Examples

### Input

`arr[] = [12, 34, 67, 90], k = 2`<br/>

### Output

`113`<br/>

**Explanation:** Allocation can be done in following ways:
- `[12]` and `[34, 67, 90]` Maximum Pages = `191`
- `[12, 34]` and `[67, 90]` Maximum Pages = `157`
- `[12, 34, 67]` and `[90]` Maximum Pages = `113`

The third combination has the **minimum pages assigned to a student** which is `113`.

### Input

`arr[] = [15, 17, 20], k = 5`<br/>

### Output

`-1`<br/>

**Explanation:** Since there are **more students than total books**, it's impossible to allocate a book to each student.

## Constraints
- `1 ≤ arr.size() ≤ 10^6`
- `1 ≤ arr[i], k ≤ 10^3`

## Notes
- If the number of students exceeds the number of books, return **-1**
- Each student must receive **at least one book**
- Books must be allocated in **contiguous sequences**

