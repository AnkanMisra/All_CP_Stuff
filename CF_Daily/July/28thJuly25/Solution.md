
# Solution Explanation

## Intuition
The core idea is to determine the winner based on the **maximum final score** `M`, and in case of ties, identify the player who **first reached a score of at least `M`** during the game.

## Approach
1. Read the number of rounds `n` and store all events (player name and score changes) in a list.
2. Compute the **final scores** for all players using a `map`.
3. Find the **maximum score** `M` among the final scores.
4. Collect all players (candidates) who achieved this **maximum score** `M`.
5. If there's only one candidate, they are the winner.
6. Otherwise, simulate the game round by round, tracking **cumulative scores**.
7. For each round, update the cumulative score and check if any candidate has reached >= `M` for the first time; track the earliest such occurrence.

## Complexity
- **Time Complexity:** `O(n)` - We process the list of events twice: once for final scores and once for cumulative simulation.
- **Space Complexity:** `O(n)` - Due to storing events and maps for scores (in worst case, `n` unique players).

## Summary
This approach correctly handles both unique winners and tie scenarios by leveraging the chronological order of events to determine who first achieved the winning score threshold, ensuring we consider only the relevant candidates for efficiency. Key corner cases include all players tying, negative scores, and minimal rounds.

