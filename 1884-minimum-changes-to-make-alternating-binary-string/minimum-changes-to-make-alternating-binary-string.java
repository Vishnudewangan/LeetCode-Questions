class Solution {
    public int minOperations(String s) {

        boolean zero = true;
        boolean one = true;
       int changeWithZero = 0;
       int changeWithOne = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
             if(zero){
               if(ch != '0')changeWithZero++;
             }
             else{
                if(ch !='1')changeWithZero++;
             }

             zero = !zero;
            
            if(one){
                if(ch != '1')changeWithOne++;
            }
            else{
                if(ch != '0')changeWithOne++;
            }

            one = !one;

        }

        return Math.min(changeWithZero , changeWithOne);
    }
}