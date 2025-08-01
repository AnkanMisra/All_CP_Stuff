
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        answer.add(new ArrayList<>(firstRow));
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = answer.get(i - 1);
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                int element = prevRow.get(j - 1) + prevRow.get(j);
                currentRow.add(element);
            }
            currentRow.add(1);
            answer.add(new ArrayList<>(currentRow));

        }
        return answer;
    }
}
