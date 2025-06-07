class Solution {
    public String clearStars(String s) {
        int deleted[] = new int[s.length()];

        Queue<Pair> q = new PriorityQueue<>((a, b) -> {
            if (a.c != b.c)
                return Character.compare(a.c, b.c);
            return Integer.compare(b.i, a.i);
        });
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                q.add(new Pair(s.charAt(i), i));
            }
            if (s.charAt(i) == '*') {
                Pair p = q.remove();
                deleted[p.i] = 1;
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < deleted.length; i++) {
            if (deleted[i] == 1 || s.charAt(i) == '*')
                continue;
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}

class Pair {
    int i;
    char c;

    public Pair(char c, int i) {
        this.c = c;
        this.i = i;
    }
}
