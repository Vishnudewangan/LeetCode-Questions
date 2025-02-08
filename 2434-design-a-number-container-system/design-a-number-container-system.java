class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> mapSet ; /// number v/s set of idx
    HashMap<Integer,Integer>map ;
    public NumberContainers() {
        mapSet = new HashMap<>();
         map= new HashMap<>();
    }
    
    public void change(int index, int number) {
        
        if(map.containsKey(index)==true)
        {
            mapSet.get(map.get(index)).remove(index);
            if(mapSet.get(map.get(index)).size()==0)
            {
                mapSet.remove(map.get(index));
            }
            map.remove(index);
        }
     
        mapSet.putIfAbsent(number,new TreeSet<>());
        mapSet.get(number).add(index);

        map.put(index,number);

    }
    
    public int find(int number) {
        if(!mapSet.containsKey(number)) return -1;

       return mapSet.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */