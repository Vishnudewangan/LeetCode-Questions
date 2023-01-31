class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        
         Pair[] arr =new Pair[scores.length];
        
        
        
        for(int i=0;i<scores.length;i++)
        {
            arr[i] = new Pair(scores[i],ages[i]);
        }
        
         Arrays.sort(arr,(Pair a, Pair b)->{
             
             return a.age == b.age ? a.score - b.score : a.age - b.age;
         });
        
        // for(int i=0;i<scores.length;i++)
        // {
        //     System.out.print(arr[i].age+" ");
        // }
        int[] dp =new int[scores.length];
        
        
        
        dp[0] = arr[0].score;
        int omax = dp[0];
        
        for(int i=1;i<scores.length;i++)
        {
            
              dp[i] = arr[i].score;
            
            for(int j=i-1; j>= 0; j--)
            {
               
                 
                 if(arr[i].score >= arr[j].score)
                 {
                     dp[i]  =Math.max(dp[j]+arr[i].score, dp[i]);
                 }
            }
              
            // System.out.println(dp[i]);
             omax = Math.max(omax, dp[i]);
        }
        return omax;
    }
    
    static class Pair 
    {
        int score;
        int age;
        
        Pair(int score, int age)
        {
            this.score = score;
            this.age = age;
        }
      
    }
}