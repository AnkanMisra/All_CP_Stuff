class Solution {
    public int countIslands(int[][] grid, int k) {
        int r=grid.length;
        int c=grid[0].length;
        boolean v[][]=new boolean[r][c];
        int ans=0;
        int dr[]={1,-1,0,0};
        int dc[]={0,0,1,-1};
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]>0 &&  !v[i][j]){
                    long s=0;
                    ArrayDeque<int[]>q=new ArrayDeque<>();
                    q.add(new int[]{i,j});
                    v[i][j]=true;
                    while(!q.isEmpty()){
                        int cur[]=q.poll();
                        int x=cur[0],y=cur[1];
                        s+=grid[x][y];
                        for(int d=0;d<4;d++){
                            int nx=x+dr[d];
                            int ny=y+dc[d];
                            if(nx>=0 && nx<r && ny>=0 && ny<c && grid[nx][ny]>0 && !v[nx][ny]){
                                v[nx][ny]=true;
                                q.add(new int[]{nx,ny});
                            }
                        }
                    }
                    if(s%k==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}