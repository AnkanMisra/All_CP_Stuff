class Solution {
    public int maxMatching(int[] arr, int[] brr) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();

        for (int e : arr) {
            if (e < 0) a.add(e);
            else b.add(e);
        }
        for (int e : brr) {
            if (e < 0) c.add(e);
            else d.add(e);
        }
        return m(a, d) + m(c, b);
    }

    public static int m(List<Integer> a, List<Integer> b) {
        Collections.sort(a, (x, y) -> Integer.compare(Math.abs(x), Math.abs(y)));
        Collections.sort(b);
        int e = 0, f = 0, g = 0;
        while (e < a.size() && f < b.size()) {
            if (Math.abs(a.get(e)) > b.get(f)) {
                g++;
                f++;
            }
            e++;
        }
        return g;
    }
}
