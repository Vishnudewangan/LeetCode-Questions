class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n];
	for (int i = 0; i < n; i++) {
	  graph[i] = new ArrayList<>();
	}

	for (int[] dislike : dislikes) {
	  int u = dislike[0] - 1;
	  int v = dislike[1] - 1;

	  graph[u].add(v);
	  graph[v].add(u);
	}

	int[] colors = new int[n];

	for (int i = 0; i < n; i++) {
	  if (colors[i] != 0) {
		continue;
	  }

	  colors[i] = 1;

	  Queue<Integer> queue = new LinkedList<>();
	  queue.add(i);

	  while (!queue.isEmpty()) {
		int node = queue.poll();

		for (int adj : graph[node]) {
		  if (colors[adj] == colors[node]) {
			return false;
		  }

		  if (colors[adj] == 0) {
			colors[adj] = -colors[node];
			queue.add(adj);
		  }
		}
	  }
	}

	return true;
    }
}