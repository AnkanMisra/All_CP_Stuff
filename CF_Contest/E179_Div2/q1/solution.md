# Solution Explanation

## Intuition
The problem requires us to charge three crystals from 0 to `x` under a specific synchronization constraint: after every action, for any two crystals `i` and `j`, `ai ≥ floor(aj / 2)`. The optimal way is to always keep the crystals as balanced as possible, and the constraint essentially forces a doubling pattern, similar to how numbers are built up in binary.

## Approach
- The fastest way to reach `x` for all three crystals is to repeatedly double the value of the crystals, distributing the increases in a way that always satisfies the constraint.
- The process is analogous to representing `x` in binary and simulating the process of building up to `x` by doubling and adding.
- The minimum number of actions required is determined by the number of bits needed to represent `x` (i.e., the position of the highest set bit), since each bit corresponds to a "doubling" step.
- For three crystals, the minimum number of actions is `2 * k + 1`, where `k` is the number of bits required to represent `x`.

## Complexity
- Time Complexity: O(1) per test case, since finding the number of leading zeros and simple arithmetic are constant time operations.
- Space Complexity: O(1) per test case.

## Summary
By leveraging the binary representation of `x`, we can determine the minimum number of actions needed to charge all three crystals to level `x` while always satisfying the synchronization constraint. The answer for each test case is `2 * k + 1`, where `k` is the number of bits in `x`.
