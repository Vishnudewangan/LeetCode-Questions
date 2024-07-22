class Solution {
    static class Pair
    {
        String name ;
        int ht;
        
        Pair(String name , int ht)
        {
            this.name = name;
            this.ht = ht;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        
        Pair[] arr =new Pair[names.length];
        
        for(int i=0;i<names.length;i++)
        {
            arr[i] = new Pair(names[i],heights[i]);
        }
        
        Arrays.sort(arr,(a,b)->{
            return b.ht - a.ht;
        });
        
        
        for(int i=0;i<names.length;i++)
        {
            names[i] = arr[i].name;
        }
        return names;
        
    }
}