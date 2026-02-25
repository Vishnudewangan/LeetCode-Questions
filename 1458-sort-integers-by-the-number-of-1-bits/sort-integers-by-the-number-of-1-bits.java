class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                  .boxed()
                  .sorted((a,b)->{
                    int cntA = countOnes(a);
                    int cntB = countOnes(b);

                    if(cntA == cntB){
                        return a - b;
                    }
                    return cntA - cntB;
                  })
                  .mapToInt(Integer::intValue)
                  .toArray();
    }

    private int countOnes(int n){

        int cnt = 0;

        while(n>0){
            int rsbm = (n&(-n));
            n = n - rsbm;
            cnt++;
        }
        return cnt;
    }
}