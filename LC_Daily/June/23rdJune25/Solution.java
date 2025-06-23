class Solution {
    public long kMirror(int k, int n) {

        long ans = 0, x = 1, c = 0;
        while (true) {
            if (check_base(x, k)) {
                ans += x;
                c += 1;
                if (c == n)
                    return ans;
            }
            x = next_palin(x);
        }
    }

    public boolean check_base(long n, int k) {

        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            ans.append(n % k);
            n /= k;
        }
        return palin(ans.toString());
    }

    public boolean palin(String s) {

        int l = s.length() - 1, f = 0;
        while (f < l) {
            if (s.charAt(f) != s.charAt(l))
                return false;
            f++;
            l--;
        }

        return true;
    }

    public long next_palin(long n) {

        int len = (int) (Math.log10(n)) + 1;
        String s = String.valueOf(n);
        String t = String.valueOf(9).repeat(len);
        if (s.equals(t))
            return Long.parseLong(s) + 2;

        String half = s.substring(0, (len + 1) / 2);
        int l = half.length();
        long ans = 0;
        if ((len & 1) == 0) {
            ans = Long.parseLong(half + extrac(half, l - 1, 0));
        } else
            ans = Long.parseLong(half + extrac(half, l - 2, 0));

        if (ans > n)
            return ans;
        half = String.valueOf(Integer.parseInt(half) + 1);
        l = half.length();
        if ((len & 1) == 0) {
            ans = Long.parseLong(half + extrac(half, l - 1, 0));
        } else
            ans = Long.parseLong(half + extrac(half, l - 2, 0));

        return ans;
    }

    public String extrac(String s, int f, int l) {

        StringBuilder str = new StringBuilder();
        for (int i = f; i >= l; i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
