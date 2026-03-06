class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length() == 1) return true;

        int cSegments = 0;
        boolean segment = true;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i) && s.charAt(i) == '1'){
                 continue;
            }
            else if(s.charAt(i) == '1'){
                segment = true;
            }
            else{
                if(segment) cSegments++;
                if(cSegments > 1) return false;
                segment = false;
            }
        }
        return (segment == false && cSegments <= 1) || (segment == true && cSegments == 0);
    }
}