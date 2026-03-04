class Solution {
    public int numSpecial(int[][] mat) {
        int cnt = 0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){

                    if(visitRowAndCol(i,j,mat)) cnt++;

                }
            }
        }
        return cnt;
    }

    private boolean visitRowAndCol(int r, int c, int[][] mat){
        boolean row = true;
        for(int j = 0;j < mat[0].length;j++){
            if(j == c) continue;

            if(mat[r][j]==1){
                row = false;
                break;
            }
        }
        boolean col = true;
        for(int i = 0 ; i < mat.length ; i++){
            if(i == r) continue;

            if(mat[i][c] == 1){
                col = false;
                break;
            }
        }

        return row && col;
    }
}