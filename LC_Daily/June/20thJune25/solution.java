class Solution {
    private int goNorthEast(int n, String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (k == 0)
                break;

            if (arr[i] == 'S') {
                k--;
                arr[i] = 'N';
            } else if (arr[i] == 'W') {
                k--;
                arr[i] = 'E';
            }
        }

        return manhattenDist(arr);
    }

    private int goNorthWest(int n, String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (k == 0)
                break;

            if (arr[i] == 'S') {
                k--;
                arr[i] = 'N';
            } else if (arr[i] == 'E') {
                k--;
                arr[i] = 'W';
            }
        }

        return manhattenDist(arr);
    }

    private int goSouthEast(int n, String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (k == 0)
                break;

            if (arr[i] == 'N') {
                k--;
                arr[i] = 'S';
            } else if (arr[i] == 'W') {
                k--;
                arr[i] = 'E';
            }
        }

        return manhattenDist(arr);
    }

    private int goSouthWest(int n, String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (k == 0)
                break;

            if (arr[i] == 'N') {
                k--;
                arr[i] = 'S';
            } else if (arr[i] == 'E') {
                k--;
                arr[i] = 'W';
            }
        }

        return manhattenDist(arr);
    }

    private int manhattenDist(char[] arr) {
        int horizon = 0;
        int vertical = 0;
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'N')
                vertical++;
            else if (arr[i] == 'S')
                vertical--;
            else if (arr[i] == 'W')
                horizon++;
            else
                horizon--;

            max = Math.max(max, Math.abs(vertical) + Math.abs(horizon));
        }

        return max;
    }

    public int maxDistance(String s, int k) {
        int n = s.length();
        int ne = goNorthEast(n, s, k);
        int nw = goNorthWest(n, s, k);
        int se = goSouthEast(n, s, k);
        int sw = goSouthWest(n, s, k);

        return Math.max(ne, Math.max(nw, Math.max(se, sw)));
    }
}
