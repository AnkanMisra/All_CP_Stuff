import java.util.*;
class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> l = new ArrayList<>();
        for (int c : cards) l.add((double) c);
        return solve(l);
    }
    private boolean solve(List<Double> l) {
        if (l.size() == 1) return Math.abs(l.get(0) - 24) < 1e-6;
        int n = l.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++)
                    if (k != i && k != j) next.add(l.get(k));
                double a = l.get(i), b = l.get(j);
                for (double v : calc(a, b)) {
                    next.add(v);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
    private List<Double> calc(double a, double b) {
        List<Double> r = new ArrayList<>();
        r.add(a + b); r.add(a - b); r.add(b - a); r.add(a * b);
        if (Math.abs(b) > 1e-6) r.add(a / b);
        if (Math.abs(a) > 1e-6) r.add(b / a);
        return r;
    }
}
