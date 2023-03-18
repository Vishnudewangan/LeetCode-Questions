class BrowserHistory {

    
    ArrayList<String> mem;
    int curr;
    int last;
    public BrowserHistory(String homepage) {
        mem = new ArrayList<>();
        mem.add(homepage);
        curr=0;
        last=0;
    }
    
    public void visit(String url) {
        
        if(mem.size() == curr+1)
        {
            mem.add(url);
            curr++;
            last=curr;
        }
        else
        {
            // mem.size()>curr+1;
            
            curr++;
            mem.set(curr,url);
            last=curr;
              
        }
    }
    
    public String back(int steps) {
        
      curr= Math.max(0,curr-steps);
        
        return mem.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(curr+steps , last);
        return mem.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */