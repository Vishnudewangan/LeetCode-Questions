class Solution {
    public int maximumSwap(int num) {
        String str = num+"";
        int n= str.length();
        char[] arr = new char[n];
        for(int i=0;i<n;i++)
           arr[i] = str.charAt(i) ;
        
        
        for(int i=0;i<n;i++)
        {    int biggest = i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[biggest]<= arr[j])
                {
                    biggest = j;
                }
            
            }

            if(arr[biggest]!=arr[i])
            {
                swap(i,biggest,arr);
                return Integer.parseInt(new String(arr));

            }
        }
        return num;

        
    }

    public void swap(int i,int j,char[] arr)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}