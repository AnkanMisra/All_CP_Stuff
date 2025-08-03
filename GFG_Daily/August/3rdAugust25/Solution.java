class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat,
    int[][] opr){
        int n=mat.length;
        int m=mat[0].length;

        int[][] diff=new int[n+1][m+1];
        for(int it[]:opr){
            int val=it[0];
            int row1=it[1];
            int col1=it[2];
            int row2=it[3];
            int col2=it[4];
            diff[row1][col1]+=val;
            diff[row2+1][col2+1]+=val;
            diff[row1][col2+1]-=val;
            diff[row2+1][col1]-=val;
        }
        //Row-wise prefix calculation
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                diff[i][j]+=diff[i][j-1];
            }
        }
        //Col-wise prefix calculation
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                diff[i][j]+=diff[i-1][j];
            }
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> res=new ArrayList<>();
            for(int j=0;j<m;j++){
                int sum=mat[i][j]+diff[i][j];
                res.add(sum);
            }
            ans.add(new ArrayList<>(res));
        }
        return ans;
    }
}
