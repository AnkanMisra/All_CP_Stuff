
# Problem: Amr and Pins

## Problem Description
Amr has a **circle of radius** `r` with its **center at point** `(x, y)`. He wants to move the center of the circle to a **new position** `(x', y')`.

In one step, Amr can **put a pin on the border of the circle at any point**, rotate the circle around that pin by any angle, and then remove the pin. Your task is to determine the **minimum number of steps required** to move the center of the circle from `(x, y)` to `(x', y')`.

## Input Format
- Five space-separated integers: `r x y x' y'`
  - `r`: **Radius of the circle**
  - `x`, `y`: **Coordinates of the original center**
  - `x'`, `y'`: **Coordinates of the destination center**

## Output Format
- A single integer — **minimum number of steps required** to move the center of the circle to the destination point.

## Constraints
- `1 ≤ r ≤ 100000`
- `-100000 ≤ x, y, x', y' ≤ 100000`

## Examples

### Input

`2 0 0 0 4`<br/>

### Output

`1`<br/>

### Input

`1 1 1 4 4`<br/>

### Output

`3`<br/>

### Input

`4 5 6 5 6`<br/>

### Output

`0`<br/>

## Notes
- In the first example, the optimal way is to put a pin at point `(0, 2)` and rotate the circle by 180 degrees. The center moves from `(0, 0)` to `(0, 4)` in one step.
- If the original and destination centers are the same, **no steps are required**.

