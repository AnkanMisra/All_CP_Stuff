class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int threshold = arr.length / 3;

        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        Collections.sort(result);

        return result;
    }
}
