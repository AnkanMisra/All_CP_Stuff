import java.util.*;
public class Solution {
    private static final int MODULO = 1_000_000_007;

    public int colorTheGrid(int rows, int cols) {
        Map<Integer, Long> stateCount = new HashMap<>();
        createValidStates(stateCount, 0, rows, 0, 0);

        for (int col = 1; col < cols; col++) {
            Map<Integer, Long> newStateCount = new HashMap<>();
            for (int currentState : stateCount.keySet()) {
                for (int nextState : stateCount.keySet()) {
                    if ((currentState & nextState) == 0) {
                        newStateCount.put(
                            nextState,
                            (newStateCount.getOrDefault(nextState, 0L) + stateCount.get(currentState)) % MODULO
                        );
                    }
                }
            }
            stateCount = newStateCount;
        }

        long totalWays = 0;
        for (long count : stateCount.values()) {
            totalWays = (totalWays + count) % MODULO;
        }

        return (int) totalWays;
    }

    private void createValidStates(Map<Integer, Long> stateCount, int position, int totalRows, int previousColor, int currentState) {
        if (position == totalRows) {
            stateCount.put(currentState, stateCount.getOrDefault(currentState, 0L) + 1);
            return;
        }

        for (int color = 1; color <= 3; color++) {
            if (color != previousColor) {
                createValidStates(stateCount, position + 1, totalRows, color, (currentState << 3) | (1 << color));
            }
        }
    }
}
