class Solution {
    static class Pair
    {
        char ch;
        int cnt;
        
        Pair(char ch, int cnt)
        {
            this.ch = ch;
            this.cnt = cnt;
        }
      
    }
    public String frequencySort(String s) {
        
        Pair[] arr=new Pair[256];
        
        for(int i=0;i<256;i++)
        {
            arr[i]  = new Pair((char)(i+'0'), 0);
        }
        for(char ch: s.toCharArray())
        {
            arr[ch-'0']=new Pair(ch,arr[ch-'0'].cnt+1);
        }
     
        
        Arrays.sort(arr,(a,b)->{
              return b.cnt-a.cnt;
        });
        
        StringBuilder sb =new StringBuilder();
        
        for(int i=0;i<256;i++)
        {
            if(arr[i].cnt>=1)
            {
                for(int j=0;j<arr[i].cnt;j++)
                {
                    sb.append(arr[i].ch);
                }
            }
        }
        
        return sb.toString();
    }
}