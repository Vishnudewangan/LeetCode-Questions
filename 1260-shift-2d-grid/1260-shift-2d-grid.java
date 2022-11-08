class Solution {
    public List<List<Integer>> shiftGrid(int[][] g, int k) {
        int m = g.length, n = g[0].length, tot = m * n;
        List<List<Integer>> res= new ArrayList<>();
        k = k % tot;
        for (int i = 0; i < m; i++) res.add(new ArrayList<>());
        for (int l = 0; l < tot; l++) {
            int idx = (l - k + tot) % tot;
            res.get(l / n).add(g[idx / n][idx % n]);
        }
        return res;
    }
}