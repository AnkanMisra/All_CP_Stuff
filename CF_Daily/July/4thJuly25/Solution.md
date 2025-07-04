# Solution Explanation

## Intuition
To keep all dates written in the record book **non-decreasing**, we should process the exams in the order of their written dates.  
If two exams have the same written date `ai`, their processing order is irrelevant for the record book, but taking the one with the **earlier possible real day `bi`** first can only help us finish sooner.

After fixing this written-date order, for every exam we have two candidate days:
1. the early day `bi`
2. the scheduled day `ai`

Whenever the early day `bi` is **not earlier than** the day we finished the previous exam (`lastDay`), we can safely choose `bi`, which is always better because it is no later than `ai`.  
Otherwise `bi` would break chronological order of the real days, so we are forced to take the exam on the later day `ai`.

Repeating this greedy choice from the earliest written date to the latest guarantees the smallest possible finishing day.

## Approach
1. Read all `n` exam pairs `(ai, bi)`.
2. **Sort** the exams by `ai` ascending. If `ai` tie, sort by `bi` ascending so that earlier real days are tried first.
3. Initialise `lastDay = 0`.
4. Iterate through the sorted list:
   - If `bi >= lastDay`, set `lastDay = bi` (take the exam early).
   - Else set `lastDay = ai` (must wait until the scheduled day).
5. After the loop `lastDay` equals the earliest possible day of the **final** exam. Print it.

## Complexity
- **Time Complexity:** `O(n log n)` — only the sorting step dominates.
- **Space Complexity:** `O(n)` — to store the array of exams.

## Summary
By first sorting on the dates written in the record book and then greedily picking the earliest allowable real day for each exam, we never violate chronological order and always finish as soon as possible.  
The algorithm is simple, efficient, and provably optimal.

