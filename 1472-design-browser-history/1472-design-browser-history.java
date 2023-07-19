class BrowserHistory {
     String[] history;
    int curr;
    int max;
    public BrowserHistory(String homepage) {
        history =new String[5001];
        curr=0;
        max = 0;
        history[curr] = homepage;
       
    }
    
    public void visit(String url) {
        curr++;
        history[curr] = url;
        max = curr;
       
    }
    
    public String back(int steps) {
         if(curr-steps<0)
         {   curr = 0;
             return history[0];
         }
         else
           curr=curr-steps;
        
        return history[curr];
    }
    
    public String forward(int steps) {
         if(curr+steps > max)
         {
             curr = max;
             
         }
        else
        {
            curr = curr+steps;
        }
        return history[curr];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */