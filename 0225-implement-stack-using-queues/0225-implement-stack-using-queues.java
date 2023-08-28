class MyStack {

     Queue<Integer> queMain ;
    
    int top ;
     
    public MyStack() {
        
        queMain =new ArrayDeque<>();
       
        top = -1;
        
    }
    
    public void push(int x) {
        queMain.add(x);
        top = x;
    }
    
    public int pop() {
        if(queMain.size()==0) return -1;
         
         Queue<Integer> helper =new ArrayDeque<>();
        while(queMain.size()>1)
        {
            
            if(queMain.size()==2) top = queMain.peek();
            helper.add(queMain.remove());
        }
         int val = queMain.remove();
        queMain = helper;
        return val;
        
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queMain.size()==0;
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