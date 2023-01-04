class Solution {
    public String oddString(String[] words) {
         
        int n= words[0].length();
        
        int[]arr1=new int[n-1];
        int[] arr2=new int[n-1];
        int[] arr3 =new int[n-1];
        
      
            for(int j=0;j<n-1;j++)
            {
                arr1[j] = words[0].charAt(j+1) - words[0].charAt(j);
                arr2[j] = words[1].charAt(j+1)-words[1].charAt(j);
                arr3[j] = words[2].charAt(j+1) - words[2].charAt(j);
            }
        
        
        if(Arrays.equals(arr1,arr2) && !Arrays.equals(arr1,arr3)) return words[2];
        if(Arrays.equals(arr1,arr3) && !Arrays.equals(arr1,arr2)) return words[1];
        if(Arrays.equals(arr2,arr3) && !Arrays.equals(arr2,arr1)) return words[0];
        
        
        for(int i=3;i<words.length;i++)
        {
            int[] temp  =new int[n-1];
            
            for(int j=0;j<n-1;j++)
            {
                temp[j] = words[i].charAt(j+1) - words[i].charAt(j);
            }
            
            if(!Arrays.equals(temp,arr1)) return words[i];
        }
        
        return null;
        
    }
}