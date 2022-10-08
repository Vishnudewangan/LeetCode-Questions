class Solution {
     public int largestRectangleArea(int[] heights) {
        
        
        int[] nsel = nseOnLeft(heights);
        int[] nser = nseOnRight(heights);
        
        int maxArea=0;
        
        for(int i=0;i<heights.length;i++)
        {
            int width = nser[i] - nsel[i] -1;
            int h = heights[i];
            
            int area = width * h;
            
            maxArea = Math.max(area , maxArea);
        }
        
        return maxArea;
    }
    
    public int[] nseOnLeft(int[] arr)
    {
        int n=arr.length;
        
        Stack<Integer> st=new Stack<>();
        
        int[] nse=new int[n];
        
        nse[0] =-1;
       st.push(0);
        
        for(int i=1;i<n;i++)
        {
            while(st.size()>0 && arr[st.peek()] >= arr[i])
            {
                st.pop();
                
            }
            
            if(st.size()==0)
            {
                nse[i] = -1;
            }
            else
            {
                nse[i]=st.peek();
            }
            
            st.push(i);
        }
        
        return nse;
    }
    
    public int[] nseOnRight(int[] arr)
    {
        int n=arr.length;
        
        Stack<Integer> st=new Stack<>();
        
        int[] nse =new int[n];
        
        nse[n-1]= n;
        
        st.push(n-1);
        
        for(int i=n-2; i>=0;i--)
            {
                while(st.size()>0 && arr[st.peek()]>= arr[i])
                {
                    st.pop();
                }
                
                if(st.size()==0)
                {
                    nse[i] = n;
                }
                else
                {
                    nse[i] = st.peek();
                }
                st.push(i);
            }
            
            return nse;
    }
    public int maximalRectangle(char[][] matrix) {
        
        int n= matrix.length;
        int m= matrix[0].length;
        
        int[] arr=new int[m];
        
        int maxArea=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j< m ;j++)
            {
                if(matrix[i][j]=='0')
                {
                    arr[j]=0;
                }
                else
                {
                    arr[j] = arr[j]+1;
                }
            }
            
            int area=largestRectangleArea(arr);
            
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }
}