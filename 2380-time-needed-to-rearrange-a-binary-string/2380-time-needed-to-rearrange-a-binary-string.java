class Solution {
    public int secondsToRemoveOccurrences(String s) {
        
           int seconds = 0;
        while (s.indexOf("01") >= 0) {
            s = s.replace("01", "10");
            ++seconds;
        }
        return seconds;
    }
}