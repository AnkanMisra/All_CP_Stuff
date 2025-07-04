# Problem: C. Exams

## Problem Description
Student Valera is an undergraduate student who needs to pass exactly **n exams**. He can pass any exam on his first try and can take several exams on one day in any order.

According to the schedule, Valera can take the exam for the i-th subject on **day number ai**. However, he has made arrangements with teachers, and the teacher of the i-th subject allowed him to take the exam **before the scheduled time on day bi** (where `bi < ai`). Thus, Valera can take an exam for the i-th subject either on day `ai` or on day `bi`.

**Important:** All teachers write down the **scheduled date ai** in the record book, regardless of when the exam was actually taken.

Valera wants all entries in his record book to be in **non-decreasing order of dates**. Find the **minimum possible day** when Valera can take his final exam while maintaining this order.

## Input Format
- First line: a single positive integer **n** (`1 ≤ n ≤ 5000`) — the number of exams Valera will take
- Next **n lines**: two positive space-separated integers **ai** and **bi** (`1 ≤ bi < ai ≤ 10^9`) — the scheduled date and early date for the i-th exam

## Output Format
Print a single integer — the **minimum possible day** when Valera can take the last exam while ensuring all records go in non-decreasing order of scheduled dates.

## Examples

### Example 1
**Input:** `3`<br/>
`5 2`<br/>
`3 1`<br/>
`4 2`<br/>

**Output:** `2`<br/>

### Example 2
**Input:** `3`<br/>
`6 1`<br/>
`5 2`<br/>
`4 3`<br/>

**Output:** `6`<br/>

## Constraints
- `1 ≤ n ≤ 5000`
- `1 ≤ bi < ai ≤ 10^9`

## Notes
In the first example, Valera's strategy:
- **Day 1:** Takes exam for subject 2 (scheduled date `3` written in record book)
- **Day 2:** Takes exam for subject 3 (scheduled date `4` written in record book)  
- **Day 2:** Takes exam for subject 1 (scheduled date `5` written in record book)

The record book dates are in **non-decreasing order**: `3, 4, 5`, and the last exam is taken on day **2**.

In the second example:
- **Day 4:** Takes exam for subject 3 (scheduled date `4`)
- **Day 5:** Takes exam for subject 2 (scheduled date `5`)
- **Day 6:** Takes exam for subject 1 (scheduled date `6`)

The last exam is taken on day **6**.

