class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        long m = mass;
        Arrays.sort(asteroids);
        
        for(int val : asteroids)
        {
           if(val > m)
           {
              return false;
           }
            
           m += val;
        }
        
        return true;
    }
}