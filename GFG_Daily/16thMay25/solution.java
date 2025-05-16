class Solution {
    static class Node {
        int val, row, col;
        Node(int v, int r, int c) {
            val = v; row = r; col = c;
        }
    }
    
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int currentMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
            currentMax = Math.max(currentMax, arr[i][0]);
        }
        
        int bestL = 0, bestR = Integer.MAX_VALUE;
        
        while (true) {
            Node mn = pq.poll();
            int currentMin = mn.val;
            
            if (currentMax - currentMin < bestR - bestL) {
                bestL = currentMin;
                bestR = currentMax;
            }
            
            if (mn.col + 1 == arr[mn.row].length) {
                break;
            }
            int nextVal = arr[mn.row][mn.col + 1];
            pq.offer(new Node(nextVal, mn.row, mn.col + 1));
            if (nextVal > currentMax) {
                currentMax = nextVal;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(bestL);
        ans.add(bestR);
        return ans;
    }
}
