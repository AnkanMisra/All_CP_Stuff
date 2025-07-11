
# Problem: Meeting Rooms III

## Problem Description
You are given an integer `n`, representing the number of meeting rooms numbered from `0` to `n - 1`. You are also given a 2D integer array `meetings`, where `meetings[i] = [start_i, end_i]` means that a meeting will be held during the half-closed time interval `[start_i, end_i)`. All `start_i` values are unique.

Meetings are allocated to rooms as follows:
- Each meeting will take place in the **unused room with the lowest number**.
- If there are **no available rooms**, the meeting will be **delayed until a room becomes free**. The delayed meeting should have the **same duration** as the original meeting.
- When a room becomes unused, meetings with an **earlier original start time** should be given the room first.

Return the **number of the room that held the most meetings**. If there are multiple rooms, return the room with the lowest number.

A half-closed interval `[a, b)` includes `a` but not `b`.

## Input Format
- An integer `n` — the number of rooms.
- An integer `meetings.length` — the number of meetings.
- A 2D integer array `meetings`, where each `meetings[i] = [start_i, end_i]`.

## Output Format
- An integer — the **room number that held the most meetings**. If multiple, the lowest number.

## Examples

### Example 1
**Input:**
`n = 2`, `meetings = [[0,10],[1,5],[2,7],[3,4]]`<br/>
<br/>
**Output:**
`0`<br/>
<br/>
**Explanation:**
- At time `0`, both rooms are unused. The first meeting starts in room `0`.
- At time `1`, only room `1` is unused. The second meeting starts in room `1`.
- At time `2`, both rooms are used. The third meeting is delayed.
- At time `3`, both rooms are used. The fourth meeting is delayed.
- At time `5`, the meeting in room `1` finishes. The third meeting starts in room `1` for `[5,10)`.
- At time `10`, both rooms finish. The fourth meeting starts in room `0` for `[10,11)`.
Both rooms `0` and `1` held `2` meetings, so we return `0`.

### Example 2
**Input:**
`n = 3`, `meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]`<br/>
<br/>
**Output:**
`1`<br/>
<br/>
**Explanation:**
- At time `1`, all rooms are unused. The first meeting starts in room `0`.
- At time `2`, rooms `1` and `2` are unused. The second meeting starts in room `1`.
- At time `3`, only room `2` is unused. The third meeting starts in room `2`.
- At time `4`, all rooms are used. The fourth meeting is delayed.
- At time `5`, the meeting in room `2` finishes. The fourth meeting starts in room `2` for `[5,10)`.
- At time `6`, all rooms are used. The fifth meeting is delayed.
- At time `10`, meetings in rooms `1` and `2` finish. The fifth meeting starts in room `1` for `[10,12)`.
Room `0` held `1` meeting, rooms `1` and `2` each held `2` meetings, so we return `1`.

## Constraints
- `1 <= n <= 100`
- `1 <= meetings.length <= 100000`
- `meetings[i].length == 2`
- `0 <= start_i < end_i <= 500000`
- All `start_i` values are unique.

## Notes
- A half-closed interval `[a, b)` includes `a` but not `b`.
- If multiple rooms have the same maximum number of meetings, return the room with the lowest number.

