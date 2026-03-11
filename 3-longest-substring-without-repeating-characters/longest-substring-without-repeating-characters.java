class Solution {
    public int lengthOfLongestSubstring(String s) {
        int distCnt = (int) s.chars().distinct().count();

        int n = s.length();

        //ds
        HashSet<Character> set = new HashSet<>();

        // TP
        int tail = 0, head = -1;
        int ans = 0;

        while(tail < n){
            while(head + 1 < n &&(set.contains(s.charAt(head+1))==false)){
                head++;
                set.add(s.charAt(head));
            }

            // ans 

            ans = Math.max(ans , head - tail + 1);

            if(tail <= head){
                set.remove(s.charAt(tail));
                tail++;
            }
            else{
                tail++;
                head = tail - 1;
            }
        }

        return ans;
    }
}