class Solution {
    public int largestInteger(int num) {
           
        
        ArrayList<Integer> odd =new ArrayList<>();
        
        ArrayList<Integer> even = new ArrayList<>();
        
        int n= num;
        
        String str= Integer.toString(n);
        
       for(int i=0;i<str.length();i++)
        {
            int rem = (int)(str.charAt(i)-'0');
            
            
            if(rem%2==0) even.add(rem);
            else odd.add(rem);
        }
        
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even, Collections.reverseOrder());
        
        String ans = "";
        
        int o=0,e=0;
        
       for(int i=0;i<str.length();i++)
       {
           int rem = (int)(str.charAt(i) -'0');
           
           if(rem%2==0)
           {
               ans+=even.get(e);
               e++;
           }
           else
           {
               ans+=odd.get(o);
               
               o++;
           }
           
       }
        
        return Integer.parseInt(ans);
        
        
          
        
    }
}