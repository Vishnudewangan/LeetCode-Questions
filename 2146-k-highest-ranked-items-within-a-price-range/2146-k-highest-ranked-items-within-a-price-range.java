class Solution {
         public static class Node implements Comparable<Node>{
        int r,c,dist,val;
        Node(int r,int c,int val,int dist){
            this.r=r;
            this.c=c;
            this.val=val;
            this.dist=dist;
        }
        public int compareTo(Node o){
            if(o.dist!=this.dist){
                return this.dist-o.dist;
            }
            if(o.val!=this.val){
                return this.val-o.val;
            }
            if(this.r!=o.r)return this.r-o.r;
            if(o.c!=this.c){
            }
                return this.c-o.c;
        }
    }
    private int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        List<Node> ans=new ArrayList<>();
        
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(new Node(start[0],start[1],grid[start[0]][start[1]],0));
        visited[start[0]][start[1]]=true;
        
        while(queue.size()!=0){
            int l=queue.size();
            while(l-->0){
                Node rem=queue.remove();
                ans.add(rem);
                int r=rem.r;
                int c=rem.c;
                int dist=rem.dist;
                for(int dir[]:dirs){
                    int nr=dir[0]+r;
                    int nc=dir[1]+c;
                    if(nr<0||nc<0||nr>=n||nc>=m||grid[nr][nc]==0||visited[nr][nc])continue;
                    visited[nr][nc]=true;
                    queue.add(new Node(nr,nc,grid[nr][nc],dist+1));
                }
                
            }
        }
        List<List<Integer>> ret=new ArrayList<>();
        Collections.sort(ans);
        for(int i=0;i<ans.size()&&k>0;i++){
            if(ans.get(i).val>=pricing[0]&&ans.get(i).val<=pricing[1]){
                k--;
                ret.add(Arrays.asList(ans.get(i).r,ans.get(i).c));
            }
        }
        return ret;
    }
}