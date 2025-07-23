class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x >= y) {
            int score1 = removeAndCount(s, 'a', 'b', x);
            int score2 = removeAndCount(remaining, 'b', 'a', y);
            return score1 + score2;
        } else {
            int score1 = removeAndCount(s, 'b', 'a', y);
            int score2 = removeAndCount(remaining, 'a', 'b', x);
            return score1 + score2;
        }
    }

    private String remaining;

    private int removeAndCount(String s, char first, char second, int points) {
        StringBuilder sb = new StringBuilder();
        int score = 0;

        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == first && c == second) {
                sb.setLength(sb.length() - 1);
                score += points;
            } else {
                sb.append(c);
            }
        }

        remaining = sb.toString();
        return score;
    }
}
