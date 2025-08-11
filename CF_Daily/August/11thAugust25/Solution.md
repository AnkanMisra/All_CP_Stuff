
# Solution Explanation

## Intuition
To maximize the number of tables, each table needs 3 balloons and cannot have all three of the same color. The limiting factors are:
- The total number of balloons `sum = r + g + b` allows at most `sum / 3` tables because each table needs 3 balloons.
- If one color is very abundant, say `mx = max(r, g, b)`, the other two colors together may not be enough to keep avoiding triples of the same color. In that case, the maximum tables are limited by `sum - mx` (since each table must include at least one balloon from the other colors to avoid three-of-a-kind).

The answer is the minimum of these two bounds.

## Approach
- Read `r`, `g`, `b`.
- Compute `sum = r + g + b`.
- Compute `mx = max(r, g, b)`.
- The maximum number of valid tables is `min(sum / 3, sum - mx)`.

## Complexity
- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`

## Summary
The formula `min((r + g + b) / 3, (r + g + b) - max(r, g, b))` captures both constraints: overall balloon availability and distribution among colors. It ensures we never exceed the total possible groups of three and we avoid creating a triple of the same color when one color dominates.

