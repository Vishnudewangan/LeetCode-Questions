class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> mapT = new HashMap<>();

        for(char ch : t.toCharArray()) mapT.put(ch, mapT.getOrDefault(ch,0)+1);
        // DS
        HashMap<Character,Integer> mapS = new HashMap<>();
        
        
        // TP

        int tail = 0, head = -1;
        int ans = Integer.MAX_VALUE;
        int mtc = 0;
        
        int n =s.length();
        int si = -1;
        int ei = -1;

        while(tail < n){

            while(head + 1 < n && (mtc < t.length())){
                head++;
                mapS.put(s.charAt(head), mapS.getOrDefault(s.charAt(head),0)+1);

                if(mapS.get(s.charAt(head)) <= mapT.getOrDefault(s.charAt(head),0)){
                    mtc++;
                }
            }

            // ans
            if(ans > head - tail + 1 && mtc == t.length()){
                ans = head - tail + 1;
                si = tail;
                ei = head;
            }

            if(tail <= head)
            {
                char ch = s.charAt(tail);

                mapS.put(ch,mapS.get(ch)-1);

                if(mapS.get(ch)==0)mapS.remove(ch);

                if(mapT.getOrDefault(ch,0) > mapS.getOrDefault(ch,0))mtc--;

                tail++;
            }
            else{
                tail++;
                head = tail - 1;
            }
        }

        return ans != Integer.MAX_VALUE ? s.substring(si,ei+1) : "";

        
        
    }
}