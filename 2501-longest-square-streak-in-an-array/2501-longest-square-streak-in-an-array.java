class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> m=new HashMap<>();
        int res=-1;
        for(int x:nums){
            int perfect=(int)Math.sqrt(x);
            //check perfect int or not as there may be int which will not form perfect square
            
            if(perfect*perfect==x && m.containsKey(perfect)){
                m.put(x,m.get(perfect)+1);
                res=Math.max((m.get(perfect)+1),res);   
            }
            else{
                m.put(x,1);
            }
        }  
        return res;
    }
}