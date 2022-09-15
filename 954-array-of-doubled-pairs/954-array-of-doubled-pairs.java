class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        
        HashMap<Integer,Integer> map=new HashMap<>();//  frequency;
        
        
        
        for(int val : arr)
        {
            map.put(val, map.getOrDefault(val,0)+1);
            
        }
        
        Integer[] absSortedArr= new Integer[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            absSortedArr[i] = arr[i];
        }
        
        Arrays.sort(absSortedArr, (a,b)->{
            return Math.abs(a) - Math.abs(b);
        });
        
        
        
        for(int val : absSortedArr)
        {
            if(map.get(val)==0) continue;
            
            
            if(map.getOrDefault(val*2,0)<=0) return false;
            
            
             map.put(val, map.get(val)-1);
            map.put(val*2,map.get(val*2)-1);
            
            
        }
        
        return true;
    }
}