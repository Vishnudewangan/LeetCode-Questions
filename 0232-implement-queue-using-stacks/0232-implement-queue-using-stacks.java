class MyQueue {
     Stack<Integer> stMain; 
    Stack<Integer> stHelper;
    
    int peek =-1;

    public MyQueue() {
         stMain = new Stack<>();
        stHelper = new Stack<>();
    }
    
    public void push(int x) {
        if(stMain.size()==0)
        {
            peek=x;
        }
        stMain.push(x);
    }
    
    public int pop() {
        
        while(stMain.size()!=1)
        { 
            
            peek=stMain.pop();
            
            
            stHelper.push(peek);
        }
        
        
        
        int popV = stMain.pop();
        
        while(stHelper.size()!=0)
        {
            stMain.push(stHelper.pop());
        }
        return popV;
    }
    
    public int peek() {
        return peek;
    }
    
    public boolean empty() {
        if(stMain.size()==0) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */