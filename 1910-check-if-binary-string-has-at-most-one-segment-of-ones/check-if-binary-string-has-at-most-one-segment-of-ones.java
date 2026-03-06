class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length() == 1) return true;

        int cSegments = 0;
        int cnt = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i) && s.charAt(i) == '1'){
                 continue;
            }
            else if(s.charAt(i) == '1'){
                cnt = 1;
            }
            else{
                if(cnt > 0) cSegments++;
                if(cSegments > 1) return false;
                cnt = 0;
            }
        }
        return (cnt==0 && cSegments <= 1) || (cnt == 1 && cSegments == 0);
    }
}