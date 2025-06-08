class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> dummy = new ArrayList<>();

        for(int i=1;i<=n;i++)
        {
            dummy.add(String.valueOf(i));
        }

        Collections.sort(dummy);

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<dummy.size();i++) ans.add(Integer.parseInt(dummy.get(i)));

        return ans;
    }
}