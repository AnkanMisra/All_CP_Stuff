class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;
        List<int[]>[]adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        int []indeg=new int[n];
        int maxCost=0;
        for(int e[]:edges){
            int u=e[0],v=e[1],c=e[2];
            adj[u].add(new int[]{v,c});
            indeg[v]++;
            if(c>maxCost) maxCost=c;
        }
        int []topo=new int[n];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++)if(indeg[i]==0)dq.add(i);
        int idx=0;
        while(!dq.isEmpty()){
            int u=dq.poll();
            topo[idx++]=u;
            for(int []e:adj[u]){
                int v=e[0];
                if(--indeg[v]==0)dq.add(v);
            }
        }
        if(idx!=n) return -1;
        int low=0,high=maxCost,ans=-1;
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(canReach(topo,adj,online,k,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    
    public boolean canReach(int topo[],List<int[]>[]adj,boolean[] online,long k,int thr){
        int n=topo.length;
        long dist[]=new long[n];
        Arrays.fill(dist,k+1);
        dist[0]=0;
        for(int i=0;i<n;i++){
            int u=topo[i];
            if(dist[u]>k) continue;
            if(u!=0 && u!=n-1 && !online[u]) continue;
            for(int e[]:adj[u]){
                int v=e[0],c=e[1];
                if(c<thr) continue;
                if(v!=n-1 && !online[v]) continue;
                long nd=dist[u]+c;
                if(nd<dist[v]&& nd<=k){
                    dist[v]=nd;
                }
            }
        }
        return dist[n-1]<=k;
    }
}