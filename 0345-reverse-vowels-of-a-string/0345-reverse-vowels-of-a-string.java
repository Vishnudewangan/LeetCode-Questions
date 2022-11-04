class Solution {
    public String reverseVowels(String s) {
        
        
        int i=0;
        int j=s.length()-1;
        char[] arr =s.toCharArray();
        
        while(i<j)
        { 
            
            while(i<j && isVowel(arr[i])==false)
            {
                i++;
            }
            
            while(i<j && isVowel(arr[j])==false)
            {
                j--;
            }
            
            swap(arr,i,j);
            i++;
            j--;
        }
        
        return new String(arr);
    }
    
    boolean isVowel(char ch)
    {
        String str= "aeiouAEIOU";
        
        int idx=str.indexOf(ch);
        
        return idx!=-1;
    }
    
    void swap(char[] arr,int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}