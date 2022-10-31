class Solution {
    public int maxDistance(int[] colors) {
        
        /// ***** O(n^2)******8
        
//         int ans=0;
        
//         for(int i=0;i<colors.length;i++)
//         {
//             for(int j=i+1;j<colors.length ;j++)
//             {
//                 if(colors[i]!=colors[j])
//                 {
//                     ans = Math.max(ans,j-i);
//                 }
//             }
//         }
        
//         return ans;
        
        /// *** O(n) *******8
        
        int n= colors.length, i=0,j=n-1;
        
        
        while(colors[i]==colors[j])j--;
        while(colors[n-1]==colors[i]) i++;
        
        return Math.max(n-1-i,j);
    }
}