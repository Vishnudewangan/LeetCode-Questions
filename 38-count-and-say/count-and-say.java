class Solution {
    public String countAndSay(int n) {
        
        if(n==1)return "1";

        String s = countAndSay(n-1);
         int count=1;
          String str="";
         for(int i=0;i<s.length()-1;i++)
         {
             if(s.charAt(i)!=s.charAt(i+1))
             {
                 str = str+Integer.toString(count)+s.charAt(i);
                 count=1;
             }
             else
             count++;
         }

         return str+ Integer.toString(count)+s.charAt(s.length()-1);
        
    }
}