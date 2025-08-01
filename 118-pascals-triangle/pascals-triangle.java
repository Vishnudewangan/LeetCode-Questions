class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        
        for(int row=0;row<numRows;row++)
        {
            int val=1;
            
            List<Integer> temp=new ArrayList<>();
            
            temp.add(val);
            
            for(int col=0;col<row ; col++)
            {
                val=(val*(row-col))/(col+1);
                temp.add(val);
            }
            
            list.add(temp);
        }
        
        return list;
    }
}