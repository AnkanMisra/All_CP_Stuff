# Solution Explanation

### Intuition

This problem is a shortest path problem on a grid with teleportation portals.  
- You can move to adjacent cells (up, down, left, right) if not blocked by an obstacle.
- If you step on a portal (an uppercase letter) and haven't used that portal letter before, you can instantly teleport to any other cell with the same letter (using that portal only once).

We need to find the minimum number of moves from the top-left to the bottom-right cell.

### Approach

- Use Dijkstra's algorithm (priority queue) to always expand the cell with the current minimum number of moves.
- For each cell, keep track of the minimum number of moves required to reach it.
- When stepping on a portal cell for the first time, teleport to all other cells with the same letter at zero additional cost.
- For each move, try all four directions and update the minimum moves if a better path is found.
- If the bottom-right cell is reached, return the number of moves. If not reachable, return -1.

### Code

```java
class Solution{
    public int minMoves(String[]a){
        int b=a.length;
        int c=a[0].length();
        char[][]d=new char[b][c];
        for(int e=0;e<b;e++){
            for(int f=0;f<c;f++){
                d[e][f]=a[e].charAt(f);
            }
        }
        List<int[]>[]g=new ArrayList[26];
        for(int e=0;e<26;e++){
            g[e]=new ArrayList<>();
        }
        for(int e=0;e<b;e++){
            for(int f=0;f<c;f++){
                char h=d[e][f];
                if(h>='A'&&h<='Z'){
                    g[h-'A'].add(new int[]{e,f});
                }
            }
        }
        int i=b*c+5;
        int[][]j=new int[b][c];
        for(int e=0;e<b;e++){
            Arrays.fill(j[e],i);
        }
        boolean[]k=new boolean[26];
        PriorityQueue<int[]>l=new PriorityQueue<>(new Comparator<int[]>(){public int compare(int[]x,int[]y){return x[2]-y[2];}});
        j[0][0]=0;
        l.add(new int[]{0,0,0});
        int[]m={1,-1,0,0};
        int[]n={0,0,1,-1};
        while(true){
            if(l.isEmpty()){
                break;
            }
            int[]o=l.poll();
            int p=o[0];
            int q=o[1];
            int r=o[2];
            if(r>j[p][q]){
                continue;
            }
            if(p==b-1&&q==c-1){
                return r;
            }
            char s=d[p][q];
            if(s>='A'&&s<='Z'){
                int t=s-'A';
                if(!k[t]){
                    for(int[]u:g[t]){
                        int v=u[0];
                        int w=u[1];
                        if(r<j[v][w]){
                            j[v][w]=r;
                            l.add(new int[]{v,w,r});
                        }
                    }
                    k[t]=true;
                }
            }
            for(int x=0;x<4;x++){
                int v=p+m[x];
                int w=q+n[x];
                if(v<0||v>=b||w<0||w>=c){
                    continue;
                }
                if(d[v][w]=='#'){
                    continue;
                }
                if(r+1<j[v][w]){
                    j[v][w]=r+1;
                    l.add(new int[]{v,w,r+1});
                }
            }
        }
        return -1;
    }
}
```

### Complexity

- **Time Complexity:** O(m * n), where m and n are the grid dimensions (each cell is processed at most once, and teleportation is limited to 26 letters).
- **Space Complexity:** O(m * n), for the distance array and portal lists.

### Summary

- The solution uses Dijkstra's algorithm to find the shortest path, handling teleportation portals efficiently.
- Each portal letter can be used at most once, and teleportation is done at zero cost.
- The approach is efficient for large grids and handles all edge cases.
