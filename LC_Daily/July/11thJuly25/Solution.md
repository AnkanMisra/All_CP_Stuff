
# Solution Explanation

## Intuition
- The key is to always assign meetings to the **lowest-numbered available room**.
- If no room is available, the meeting is **delayed** until the earliest room becomes free, and then scheduled for the same duration.
- We need to efficiently track which rooms are free and when each room will be available.

## Approach
- **Sort** all meetings by their start time.
- Use two priority queues:
  - One for **unused rooms** (min-heap by room number).
  - One for **used rooms** (min-heap by end time, then by room number).
- For each meeting:
  - Free up any rooms whose meetings have ended by the current meeting's start time and add them back to the unused queue.
  - If there is an unused room, assign the meeting to the lowest-numbered available room and update its end time.
  - If all rooms are busy, delay the meeting until the earliest room is free, then schedule it for the same duration in that room.
- Track the **number of meetings held by each room**.
- After all meetings, return the room with the **highest meeting count** (lowest number in case of a tie).

## Complexity
- Time Complexity: `O(m log n)` where `m` is the number of meetings and `n` is the number of rooms.
- Space Complexity: `O(n)` for the priority queues and meeting count array.

## Summary
- This approach ensures that meetings are always assigned to the correct room according to the rules.
- Using priority queues allows for efficient room assignment and release.
- The solution handles delays and tie-breaking as required by the problem statement.

