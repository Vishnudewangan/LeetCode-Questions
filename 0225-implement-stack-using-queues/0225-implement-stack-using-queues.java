class MyStack {

    Queue<Integer> que ;
    
    
    public MyStack() {
        que = new ArrayDeque<>();
       
    }
    
   
   
    
    public void push(int x) {
        
        
        int size = que.size();
        que.add(x);
        
        while(size>=1)
        {
            que.add(que.remove());
            size--;
        }
        
        
        
    }
    
    public int pop() {
        if(que.size()==0) return -1;
        
        return que.remove();
    }
    
    public int top() {
        if(que.size()==0) return -1;
        return que.peek();
    }
    
    public boolean empty() {
        return que.size() ==0 ;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */