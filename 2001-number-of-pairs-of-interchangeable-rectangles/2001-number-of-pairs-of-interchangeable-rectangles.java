class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        
        long count =0;
        
        
        HashMap<Double,Integer> map =new HashMap<>();
        
        for(int i=0;i<rectangles.length;i++)
        {
            int width = rectangles[i][0];
            int height = rectangles[i][1];
            
            double val = (width * 1.0)/height;
            
            if(map.containsKey(val)==true)
            {
                count+=map.get(val);
            }
            
             map.put(val, map.getOrDefault(val,0)+1);
        }
        
        return count;
        
    }
}