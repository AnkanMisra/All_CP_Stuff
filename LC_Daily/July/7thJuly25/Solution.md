# Solution Explanation

## Intuition
The key insight is to always attend the event that ends the earliest among all available events for each day, maximizing the number of events attended without conflicts.

## Approach
- **Sort** the `events` array by their start day.
- Use a **min-heap (priority queue)** to keep track of the end days of all events that are available to attend on the current day.
- Iterate through the days, always attending the event with the earliest end day (top of the heap) and removing events that have already expired.
- Only increment the day when an event is attended, otherwise jump to the next available event's start day.

## Complexity
- **Time Complexity:** `O(n log n)` where `n` is the number of events (due to sorting and heap operations).
- **Space Complexity:** `O(n)` for storing events in the heap in the worst case.

## Summary
This greedy approach ensures that you always attend the event that leaves the most room for future events, which is optimal for maximizing attendance. The use of a priority queue efficiently manages overlapping events and avoids unnecessary memory usage by only processing days with available events.

