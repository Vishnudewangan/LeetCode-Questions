class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
         int l = 0, r = people.length-1;
         Arrays.sort(people);
        
        int ans= 0;
        while(l<=r)
        {
            int remaining= limit-people[r];
            r--;
            ans++;
            if(l<=r && remaining>=people[l])
            {
                l++;
            }
            
            
        }
        
        return ans;
    }
}