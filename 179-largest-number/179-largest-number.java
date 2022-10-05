class Solution {
    public String largestNumber(int[] nums) {
        
        if(nums.length==1) return String.valueOf(nums[0]);
        
        
        int count=0;
        
        
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]==0)
           {
               count++;
           }
            
           
        }
        
         if(count== nums.length || nums.length==0) return "0";
        
        ArrayList<String> al =new ArrayList<>();
        
         for(int val : nums)
         {
             al.add(val+"");
         }
        
        Collections.sort(al, (a,b)->{
            return (b+a).compareTo(a+b); 
        });
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<nums.length;i++)
        {
            sb.append(al.get(i));
        }
        
        return sb.toString();
    }
}