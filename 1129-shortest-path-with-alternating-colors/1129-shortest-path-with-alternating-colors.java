class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // Each vertex has 2 values for starting from red and blue edges, respectively.
        int[][] steps = new int[2][n];
        // Initialized with MAX values, except that 2 starting points initialized with 0.
        Arrays.fill(steps[0], 1, n, Integer.MAX_VALUE);
        Arrays.fill(steps[1], 1, n, Integer.MAX_VALUE);
        // Put starting points and edge colors into queue. 
        Queue<int[]> q = new LinkedList<>(Arrays.asList(new int[]{0, 0}, new int[]{1, 0}));
        while (!q.isEmpty()) {
            int color = q.peek()[0], i = q.poll()[1]; // vertex number and color (red/blue: 0/1).
            int[][] edges = color == 0 ? red_edges : blue_edges;
            for (int[] vertex : edges) {
                if (i == vertex[0]) {
                    if (steps[1 - color][vertex[1]] == Integer.MAX_VALUE) { // 1 - color: the other color.
                        steps[1 - color][vertex[1]] = steps[color][i] + 1;
                        q.offer(new int[]{1 - color, vertex[1]});
                    }
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            int shorter = Math.min(steps[0][i], steps[1][i]);
            steps[0][i] = shorter == Integer.MAX_VALUE ? -1 : shorter;
        }
        return steps[0];
   }
}