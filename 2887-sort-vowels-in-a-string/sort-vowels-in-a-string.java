class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();

        ArrayList<Integer> list =new ArrayList<>();

        for(char ch  : arr)
        {
            if("aeiouAEIOU".indexOf(ch)!=-1) list.add((int)ch);
        }

        Collections.sort(list);
         int idx=0;
        for(int i=0;i<arr.length && idx<list.size();i++){
            if("aeiouAEIOU".indexOf(arr[i])!=-1){
                arr[i] = (char)list.get(idx++).intValue();
            }
        }

        return String.valueOf(arr);
    }
}