
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(num);
            for (int val : current) {
                next.add(val | num);
            }

            result.addAll(next);
            current = next;
        }

        return result.size();
    }
}
