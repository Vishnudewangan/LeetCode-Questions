class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp =new Integer[triangle.size()][triangle.size()];
        return rec(0,0,triangle,dp);
    }
    private static int rec(int r, int c, List<List<Integer>> triangle,Integer[][] dp){
        if(r+1>=triangle.size()) return triangle.get(r).get(c);
        if(dp[r][c]!=null) return dp[r][c];
        int firstComp = rec(r+1,c,triangle,dp);
        int secondComp = rec(r+1,c+1,triangle,dp);

        return dp[r][c] = Math.min(firstComp,secondComp) + triangle.get(r).get(c);
    }

}