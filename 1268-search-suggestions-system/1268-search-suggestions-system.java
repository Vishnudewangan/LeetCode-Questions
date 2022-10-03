class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      List<List<String>> al =new ArrayList<>();
        Arrays.sort(products);
        for(int c=0;c<searchWord.length();c++)
        {    
            List<String> tempList =new ArrayList<>();
            char ch = searchWord.charAt(c);
            String sbstr= searchWord.substring(0,c+1);
            for(int i=0;i<products.length;i++)
            {
                String word = products[i];
                
                if(tempList.size()==3)
                {
                    break;
                }
                
                if(c< word.length() && word.substring(0,c+1).equals(sbstr))
                {
                    tempList.add(word);
                    continue;
                }
                
                 products[i]="";
            }
            al.add(tempList);
        }
       
 
        
        return al;
    }
}