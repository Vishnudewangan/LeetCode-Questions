class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] nsel=nextSmallestLeft(heights);
        int[] nser=nextLargestRight(heights);
        
        int ans=Integer.MIN_VALUE;
        
        for(int i=0;i<heights.length;i++)
        {
           int width=nser[i]-nsel[i] -1;
            
            int height= heights[i];
            
            int area = width*height;
            
            ans =Math.max(area,ans);
        }
        
        
        return ans;
        
    }
    int[] nextSmallestLeft(int[] heights)
    {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        
        int[] nsel =new int[heights.length];
        
        nsel[0]=-1;
        
        for(int i=1;i<heights.length;i++)
        {
            while(st.size()>0 && heights[st.peek()] >=heights[i])
            {
                st.pop();
            }
            
            if(st.size()==0)
            {
                nsel[i]=-1;
            }
            else
            {
                nsel[i]=st.peek();
            }
            
            st.push(i);
        }
        
        return nsel;
    }
    
    int[] nextLargestRight(int[] heights)
    {  
        int n = heights.length;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        
        int[] nser = new int[n];
        
        nser[n-1] = n;
        
        for(int i=n-2;i>=0;i--)
        {
          while(st.size() >0 && heights[st.peek()]>= heights[i])
          {
              st.pop();
          }
            
          if(st.size()==0)
          {
              nser[i]= n;
          }
          else
          {
              nser[i] = st.peek();
          }
            
            st.push(i);
        }
        
        return nser;
        
    }
    
}