class Solution {
    public int maximumScore(int a, int b, int c) {
        
       
         int[] order = calculateOrder(a,b,c);
        
          int f = order[0];
          int s = order[1];
          int t = order[2];
        
        int score=0;
        while((f>0 && s>0)|| (s>0 && t>0)|| (f>0 && t>0))
        {
           f--;
           s--;
            score++;
            
            int[] max = calculateOrder(f,s,t);
            
            f= max[0];
            s=max[1];
            t= max[2];
            
            
        }
        
        return score;
        
    }
    
    int[] calculateOrder(int a, int b , int c)
    {
        int[] max  = new int[3];
        
         
        
        
        if(a> b&& a>c)
        {
            max[0]=a;
            
            max[2] =Math.min(b,c);
            max[1] = Math.max(b,c);
        }
        else if(b> a && b>c)
        {
             max[0] = b;
             max[2] = Math.min(a,c);
             max[1] = Math.max(a,c);
        }
        else
        {
             max[0] = c;
             max[2] = Math.min(a,b);
             max[1] = Math.max(a,b);
        }
        
        return max;
    }
}