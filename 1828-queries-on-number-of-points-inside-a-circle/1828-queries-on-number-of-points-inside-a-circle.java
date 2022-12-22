class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        
        int[] ans=new int[queries.length];
        
        for(int i=0;i<queries.length;i++)
        {
            int cnt =0;
            
            int x=queries[i][0];
            int y=queries[i][1];
            int r= queries[i][2];
            
            for(int [] arr: points)
            {
                int x1=arr[0];
                int y1=arr[1];
                
                if((x-x1)*(x-x1) + (y-y1)*(y-y1)<= r*r)
                {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        
        return ans;
    }
}