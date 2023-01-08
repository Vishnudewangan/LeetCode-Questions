class MyCalendar {
    
     ArrayList<int[]> events;
    public MyCalendar() {
        events=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        
        for(int[] event : events)
        {
            boolean notIntrsct = checkNonIntersection(event,start , end);
            if(notIntrsct==false) return false;
          
            
        }
        
        events.add(new int[]{start,end});
        return true;
    }
    private boolean checkNonIntersection(int[] event, int strt, int end)
    {
        return event[1]<=strt || event[0]>= end ? true : false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */