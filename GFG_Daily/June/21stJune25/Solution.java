class Solution {
    public int catchThieves(char[] arr, int k) {
        Queue<Integer> police = new LinkedList<>(), thieves = new LinkedList<>();
        int caught = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P')
                police.offer(i);
            else
                thieves.offer(i);
        }
        while (!police.isEmpty() && !thieves.isEmpty()) {
            if (Math.abs(police.peek() - thieves.peek()) <= k) {
                caught++;
                police.poll();
                thieves.poll();
            } else if (police.peek() < thieves.peek())
                police.poll();
            else
                thieves.poll();
        }
        return caught;
    }
}
