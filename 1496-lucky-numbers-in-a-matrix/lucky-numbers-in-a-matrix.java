class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans =new ArrayList<>();

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(check(matrix,matrix[i][j],i,j))
                {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }

    boolean check(int[][] matrix, int val , int row, int col)
    {
        int rowMin = Integer.MAX_VALUE;
        int colMax = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            colMax = Math.max(matrix[i][col],colMax);
        }
        for(int j=0;j<matrix[0].length;j++)
        {
            rowMin = Math.min(matrix[row][j],rowMin);
        }
        return (rowMin == val ) && (colMax == val);
    }
}