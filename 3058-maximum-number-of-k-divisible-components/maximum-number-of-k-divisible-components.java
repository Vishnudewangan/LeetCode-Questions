class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] edge : edges) {
            g.computeIfAbsent(edge[0], key -> new HashSet<>()).add(edge[1]);
            g.computeIfAbsent(edge[1], key -> new HashSet<>()).add(edge[0]);
        }
        int[] res = {1}; // Use an array to modify within lambda
        dfs(0, g, values, k, res);
        return res[0];
    }

    private int dfs(int node, Map<Integer, Set<Integer>> g, int[] values, int k, int[] res) {
        int total = values[node];
        for (int next_node : g.getOrDefault(node, new HashSet<>())) {
            g.get(next_node).remove(node);
            int next_total = dfs(next_node, g, values, k, res);
            if (next_total % k == 0) {
                res[0]++;
            } else {
                total += next_total;
            }
        }
        return total % k;
    }
}