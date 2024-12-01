class Solution
{
    public int minimumObstacles(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Initialize visited array to track min cost to reach each cell
        int[][] visited = new int[rows][cols];
        for (int[] row : visited)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Step 2: Define directions for moving (Right, Down, Left, Up)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Step 3: Use a Deque for BFS with prioritized traversal
        Deque<int[]> queue = new ArrayDeque<>(); // (Row, Col, Cost)
        
        // Step 4: Start BFS from the top-left corner (0, 0) with an initial cost of 0
        queue.addFirst(new int[] {0, 0, 0});
        visited[0][0] = 0;

        // Step 5: Process cells in the BFS loop
        while (!queue.isEmpty())
        {
            int[] curr = queue.pollFirst(); // Pop the cell with the current smallest cost
            int x = curr[0];
            int y = curr[1];
            int cost = curr[2];

            // Step 6: Explore all neighbors (up, down, left, right)
            for (int[] dir : directions)
            {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                // Step 7: Check if the neighbor is within bounds
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols)
                {
                    int nextCost = cost + grid[nextX][nextY]; // Add cost for obstacle (1) or free cell (0)

                    // Step 8: Update the visited array if a cheaper path is found
                    if (nextCost < visited[nextX][nextY])
                    {
                        visited[nextX][nextY] = nextCost;

                        // Step 9: Prioritize open cells (0) by adding to the front of the queue
                        if (grid[nextX][nextY] == 0)
                        {
                            queue.addFirst(new int[] {nextX, nextY, nextCost});
                        }
                        else // Process obstacle cells (1) later by adding to the end of the queue
                        { 
                            queue.addLast(new int[] {nextX, nextY, nextCost});
                        }
                    }
                }
            }
        }

        // Step 10: Return the minimum cost to reach the bottom-right corner
        return visited[rows - 1][cols - 1];
    }
}