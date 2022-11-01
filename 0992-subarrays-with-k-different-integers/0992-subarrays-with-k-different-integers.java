class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atMostKDifferentIntegers(nums, k) - atMostKDifferentIntegers(nums,k-1);
    }
    
    int atMostKDifferentIntegers(int[] arr, int k)
    {
        int n = arr.length;
        HashMap<Integer,Integer> map =new HashMap<>();
        
        int i=-1;
        int j= -1;
        int count=0;
        
        
        while(i < n-1)
        {
            while(i<n-1)
            {
                i++;
                
                int val = arr[i];
                
                map.put(val,map.getOrDefault(val,0)+1);
                
                if(map.size()<=k)
                {
                    count+=(i-j);
                }
                else 
                {
                    break;
                }
            }
            
            while(j<i && map.size()>k )
            {
                j++;
                
                int val = arr[j];
                
                if(map.get(val)==1)
                {   
                    map.remove(val);
                    count+=(i-j);
                }
                else
                {
                    map.put(val,map.get(val)-1);
                }
            }
    
        }
        return count;
    }
}