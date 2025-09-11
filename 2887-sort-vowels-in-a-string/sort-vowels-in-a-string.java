class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();

        ArrayList<Integer> list =new ArrayList<>();

        for(char ch  : arr)
        {
            if("aeiouAEIOU".indexOf(ch)!=-1) {
                int val = (ch-'A');

                list.add(val);
            }
        }

        Collections.sort(list);
         int idx=0;
        for(int i=0;i<arr.length && idx<list.size();i++){
            if("aeiouAEIOU".indexOf(arr[i])!=-1){
                arr[i] = (char)((int)(list.get(idx++)+'A'));
            }
        }

        return String.valueOf(arr);
    }
}