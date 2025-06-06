import java.util.*;
import java.io.*;

public class Solution {
    static final int MOD = 1000000007;
    static final int SMOD = 998244353;
    static ArrayList<Long> fac, inv;
    static long[] seg, lazy;

    static void in(long[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextLong();
    }

    static void in(char[] arr, Scanner sc) {
        String s = sc.next();
        for (int i = 0; i < arr.length; i++)
            arr[i] = s.charAt(i);
    }

    static void in(String[] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.next();
    }

    static void in(long[][] arr, Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
        }
    }

    static long exp(long x, long n, long m) {
        x %= m;
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * x % m;
            x = x * x % m;
            n >>= 1;
        }
        return res;
    }

    static void factorial(int n) {
        fac = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            fac.add(1L);
        for (int i = 1; i <= n; i++)
            fac.set(i, fac.get(i - 1) * i % MOD);
    }

    static void inverses(int n) {
        inv = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            inv.add(1L);
        inv.set(n, exp(fac.get(n), MOD - 2, MOD));
        for (int i = n; i >= 1; i--)
            inv.set(i - 1, inv.get(i) * i % MOD);
    }

    static long choose(int n, int r) {
        return fac.get(n) * inv.get(r) % MOD * inv.get(n - r) % MOD;
    }

    static void init(int n) {
        seg = new long[5 * n];
        lazy = new long[5 * n];
    }

    static void update(int idx, int l, int r, int ql, int qr, long change) {
        if (l > r)
            return;
        if (lazy[idx] != 0) {
            seg[idx] += (r - l + 1) * lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (l > qr || r < ql)
            return;
        if (l >= ql && r <= qr) {
            seg[idx] += (r - l + 1) * change;
            if (l != r) {
                lazy[2 * idx + 1] += change;
                lazy[2 * idx + 2] += change;
            }
            return;
        }
        int mid = (l + r) / 2;
        update(2 * idx + 1, l, mid, ql, qr, change);
        update(2 * idx + 2, mid + 1, r, ql, qr, change);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    static void update_set(int idx, int l, int r, int ql, int qr, long change) {
        if (l > r)
            return;
        if (lazy[idx] != 0) {
            seg[idx] = (r - l + 1) * lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] = lazy[idx];
                lazy[2 * idx + 2] = lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (l > qr || r < ql)
            return;
        if (l >= ql && r <= qr) {
            seg[idx] = (r - l + 1) * change;
            if (l != r) {
                lazy[2 * idx + 1] = change;
                lazy[2 * idx + 2] = change;
            }
            return;
        }
        int mid = (l + r) / 2;
        update_set(2 * idx + 1, l, mid, ql, qr, change);
        update_set(2 * idx + 2, mid + 1, r, ql, qr, change);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    static long query(int idx, int l, int r, int ql, int qr) {
        if (l > r)
            return 0;
        if (lazy[idx] != 0) {
            seg[idx] += (r - l + 1) * lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (l > qr || r < ql)
            return 0;
        if (l >= ql && r <= qr)
            return seg[idx];
        int mid = (l + r) / 2;
        return query(2 * idx + 1, l, mid, ql, qr) + query(2 * idx + 2, mid + 1, r, ql, qr);
    }

    static void create_seg_rec(long[] vec, int idx, int l, int r) {
        if (l > r)
            return;
        if (l == r) {
            seg[idx] = vec[l];
            return;
        }
        int mid = (l + r) / 2;
        create_seg_rec(vec, 2 * idx + 1, l, mid);
        create_seg_rec(vec, 2 * idx + 2, mid + 1, r);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    static void create_seg(long[] vec) {
        int n = vec.length;
        init(n);
        create_seg_rec(vec, 0, 0, n - 1);
    }

    static void solve(Scanner sc, PrintWriter out) {
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] vec = new long[n];
        in(vec, sc);
        HashMap<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)
            mp.put(vec[i], i);
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long x = sc.nextLong();
            a--;
            b--;
            Integer idx = mp.get(x);
            if (idx == null || idx < a || idx > b) {
                out.println(-1);
                continue;
            }
            int l = a, r = b, mid, more = 0, less = 0, umore = 0, uless = 0;
            int fless = 0, fmore = 0;
            while (l <= r) {
                mid = (l + r) / 2;
                if (mid < idx) {
                    if (vec[mid] > x) {
                        less++;
                        fmore++;
                    } else
                        uless++;
                    l = mid + 1;
                } else if (mid > idx) {
                    if (vec[mid] < x) {
                        more++;
                        fless++;
                    } else
                        umore++;
                    r = mid - 1;
                } else
                    break;
            }
            if (less + uless > x - 1 || more + umore > n - x) {
                out.println(-1);
                continue;
            }
            int tot = more + less + Math.max(0, more - fmore) + Math.max(0, less - fless);
            out.println(tot);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = 1;
        if (sc.hasNextInt())
            T = sc.nextInt();
        for (int t = 0; t < T; t++)
            solve(sc, out);
        out.flush();
    }
}
