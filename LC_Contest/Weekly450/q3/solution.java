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
