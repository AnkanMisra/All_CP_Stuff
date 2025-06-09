# Solution Explanation

## Intuition
Vadim wants to guarantee that at least one student receives a correct prediction for the boarding process on two consecutive days. Since there are two possible outcomes each day, there are 4 possible scenarios for any two consecutive days. If Vadim can assign all 4 possible predictions to students betting on the same day, he is guaranteed to win with at least one student.

## Approach
- Sort the array of bet days.
- For each group of students betting on the same day, count how many students bet on that day (`j`).
- If there are at least 4 students betting on the same day, Vadim can assign all 4 possible predictions and guarantee a win.
- If there are two consecutive days with at least 2 students betting on each, Vadim can cover all 4 scenarios by combining predictions across these days.
- Iterate through the sorted array, tracking the count of students for each day and checking for the above conditions.
- If either condition is met, output "Yes". Otherwise, output "No".

## Complexity
- Time Complexity: O(n log n) per test case due to sorting.
- Space Complexity: O(n) per test case for storing the days.

## Summary
By grouping students by their bet days and checking for sufficient coverage (either 4 on the same day or 2 on two consecutive days), the solution efficiently determines if Vadim can guarantee a win.
