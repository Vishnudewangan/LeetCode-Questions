class MyCalendarTwo {
       ArrayList<int[]> overlapBookings;
       ArrayList<int[]> bookings;
    public MyCalendarTwo() {
        overlapBookings=new ArrayList<>();
        bookings =new ArrayList<>();
    }
    
    public boolean book(int start, int end) { 
       
       for(int[] event : overlapBookings)
       {
           if(checkOverlapping(event,start,end)) return false;
       }

       for(int[] event : bookings){
            if(checkOverlapping(event,start,end)){
                addOverlappingPart(overlapBookings,event,start,end);
            }
           
       }
       bookings.add(new int[]{start,end});
       return true;
    }
    private boolean checkOverlapping(int[] event, int strt, int end)
    {
        return Math.max(event[0],strt) < Math.min(event[1],end);
    }
    private void addOverlappingPart(ArrayList<int[]> overlapBookings,int[] event, int start,int end){
        overlapBookings.add(new int[]{Math.max(event[0],start), Math.min(event[1],end)});
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */