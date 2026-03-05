class Solution {
    public int minOperations(String s) {

        StringBuilder startWithZero = new StringBuilder();
        StringBuilder startWithOne = new StringBuilder();

        boolean zero = true;
        boolean one = true;

        for(int i = 0; i < s.length(); i++){
             if(zero){
                startWithZero.append('0');
             }
             else{
                startWithZero.append('1');
             }

             zero = !zero;
            
            if(one){
                startWithOne.append('1');
            }
            else{
                startWithOne.append('0');
            }

            one = !one;

        }

        int changeWithZero = 0;
        int changeWithOne = 0;


        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);


            if(ch != startWithZero.charAt(i))changeWithZero++;

            if(ch != startWithOne.charAt(i)) changeWithOne++;
        }

        return Math.min(changeWithZero , changeWithOne);
    }
}