class Solution {
  public int minDeletion(String s, int k) {
    int[] a = new int[26];
    for (char b : s.toCharArray()) {
      a[b - 'a']++;
    }
    List<Integer> c = new ArrayList<>();
    for (int d = 0; d < 26; d++) {
      if (a[d] > 0) c.add(a[d]);
    }
    Collections.sort(c);
    int e = c.size();
    if (e <= k) return 0;
    int f = 0;
    for (int g = 0; g < e - k; g++) {
      f += c.get(g);
    }
    return f;
  }
}
