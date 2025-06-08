import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String s = sc.next();
        char[] sArr = s.toCharArray();
        int[] nextpos = new int[k];
        Arrays.fill(nextpos, -1);
        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int c = sArr[i] - 'a';
            nextpos[c] = i;
            int minVal = Integer.MAX_VALUE;
            boolean missing = false;
            for (int ch = 0; ch < k; ch++) {
                int j = nextpos[ch];
                if (j == -1) {
                    f[i] = 1;
                    missing = true;
                    break;
                } else {
                    int v = f[j + 1];
                    if (v < minVal)
                        minVal = v;
                }
            }
            if (!missing) {
                f[i] = minVal + 1;
            }
        }
        int[] freq = new int[k];
        for (char ch : sArr)
            freq[ch - 'a']++;
        int[][] posList = new int[k][];
        for (int ch = 0; ch < k; ch++) {
            posList[ch] = new int[freq[ch]];
            freq[ch] = 0;
        }
        for (int i = 0; i < n; i++) {
            int c = sArr[i] - 'a';
            posList[c][freq[c]++] = i;
        }
        int q = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            String t = sc.next();
            int pos = -1;
            boolean pleasant = true;
            for (char ch : t.toCharArray()) {
                int c = ch - 'a';
                int[] list = posList[c];
                if (list.length == 0) {
                    pleasant = false;
                    break;
                }
                int key = pos + 1;
                int idx = Arrays.binarySearch(list, key);
                int newPos;
                if (idx >= 0) {
                    newPos = list[idx];
                } else {
                    int ip = -idx - 1;
                    if (ip < list.length) {
                        newPos = list[ip];
                    } else {
                        pleasant = false;
                        break;
                    }
                }
                pos = newPos;
            }
            sb.append(pleasant ? f[pos + 1] : 0).append('\n');
        }
        System.out.print(sb);
    }
}
