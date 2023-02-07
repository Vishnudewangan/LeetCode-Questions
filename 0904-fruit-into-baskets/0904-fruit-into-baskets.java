class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map =new HashMap<>();
        
        int i=-1;
        int j=-1;
        int maxLen =0;
         
        int n = fruits.length;
        while(i<n-1)
        {
            while(i<n-1)
            {
                i++;
                
                int val=fruits[i];
                
                map.put(val,map.getOrDefault(val,0)+1);
                
                if(map.size()<=2)
                {
                    int len =i-j;
                    maxLen = Math.max(len,maxLen);
                }
                else
                {
                    break;
                }
            }
        
        
        while(j<i)
        {
            j++;
            int val=fruits[j];
            
            int freq=map.get(val);
            
            if(freq==1)
            {
                map.remove(val);
                break;
            }
            else{
                map.put(val,freq-1);
            }
        }
    
    }
    
    return maxLen;
}
}