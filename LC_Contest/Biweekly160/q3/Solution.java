class Solution {
    public int minTime(int n, int[][] edges) {
        ArrayList<int[]>[]g=new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int ed[]:edges){
            g[ed[0]].add(new int[]{ed[1],ed[2],ed[3]});
        }
            long dist[]=new long[n];
            Arrays.fill(dist,Long.MAX_VALUE);
            dist[0]=0;
            PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
            pq.add(new long[]{0,0});
            while(!pq.isEmpty()){
                long cur[]=pq.poll();
                long t=cur[0];
                int u=(int)cur[1];
                if(t!=dist[u]){
                    continue;
                }
                if(u==n-1){
                    break;
                }
                for(int ed[]:g[u]){
                    int v=ed[0];
                    int s=ed[1];
                    int e=ed[2];
                    if(t>e){
                        continue;
                    }
                    long dep=t<s?s:t;
                    long arr=dep+1;
                    if(arr<=dist[v]){
                        dist[v]=arr;
                        pq.add(new long[]{arr,v});
                    }
                }
            }
            if(dist[n-1]==Long.MAX_VALUE){
                return -1;
            }
            return (int)dist[n-1];
    }
}