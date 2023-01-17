class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<list1.length;i++)
        {
            for(int j=0;j<list2.length;j++)
            {
                if(list1[i].equals(list2[j]))
                {
                    min = Math.min(min,i+j);
                }
            }
        }
          List<String> ans =new ArrayList<>();
         for(int i=0;i<list1.length;i++)
        {
            for(int j=0;j<list2.length;j++)
            {
                if(list1[i].equals(list2[j]) && i+j==min)
                {
                    ans.add(list1[i]);
                }
            }
        }
        
        return ans.toArray(new String[ans.size()]);
        
       
    }
}