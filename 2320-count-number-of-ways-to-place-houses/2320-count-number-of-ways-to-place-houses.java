class Solution {
    
    public int countHousePlacements(int n) {
        
        long mod = (long)1e9+7;
        long osp=1;
        long ob =1;
        
        for(int i=2;i<=n;i++)
        {
            long nsp= (ob%mod+osp%mod)%mod;
            long nb = osp%mod;
            
            osp = nsp;
            ob = nb;
        }
        
        long osw=(ob%mod+osp%mod)%mod ;// for one side
        
        long ans = ((osw%mod)*(osw%mod))%mod;
        
        return (int)ans;
    }
}