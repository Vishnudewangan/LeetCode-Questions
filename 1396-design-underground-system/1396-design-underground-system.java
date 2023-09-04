class UndergroundSystem {
    HashMap<Integer,Integer> map1; //checkIn IdvsTime;
    HashMap<Integer,String> map2;//checkInIdvsStationName;
    HashMap<String,Integer> map3;// checkInStation@checkOutStation v/s sum of exp. 
    HashMap<String,Integer> map4;// checkInStation@checkOutStation v/s  no. of exp.
    public UndergroundSystem() {
         map1 = new HashMap<>();
         map2 = new HashMap<>();
         map3 = new HashMap<>();
         map4 = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
         map1.put(id,t);
         map2.put(id,stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
         
        int inTime = map1.get(id);
        String inStName = map2.get(id);
        
      if(map3.containsKey(inStName+"@"+stationName))
        {
            int sum = map3.get(inStName+"@"+stationName) + t - inTime;
            int noOfExp = map4.get(inStName+"@"+stationName) + 1 ;
           
           map3.put(inStName+"@"+stationName, sum);
           map4.put(inStName+"@"+stationName,noOfExp);
            
            
            
        }
        else
        {
            map3.put(inStName+"@"+stationName, t - inTime);
            map4.put(inStName+"@"+stationName,1);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String uniqueId = startStation+"@"+endStation;
        
        int sum = map3.get(uniqueId);
        int noOfExp = map4.get(uniqueId);
        
        return (sum*1.0)/noOfExp;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */