class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                list.add(mat[i][j]);
            }
        }

        Collections.sort(list);

        int ans = list.size()/2;

        return list.get(ans);
    }
}
