class CustomStack {
     int[] value;
     int[] increment;
     int tos;
     int maxSize;
    public CustomStack(int maxSize) {
        value = new int[maxSize];
        increment = new int[maxSize];
        tos = -1;
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(tos+1 == maxSize) return ;// overflow
        tos++;
        value[tos] = x;
    }
    
    public int pop() {
        if(tos == -1) return -1;

        int realValue = value[tos] + increment[tos];
        int increaseVal = increment[tos];

        value[tos] = 0;
        increment[tos] = 0;
        
        tos--;
        if(tos>=0) increment[tos]+=increaseVal;
        return realValue;

    }
    
    public void increment(int k, int val) {
        if(tos==-1) return;
        if(k>tos+1){
            increment[tos]+=val;
        }
        else{
            increment[k-1]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */