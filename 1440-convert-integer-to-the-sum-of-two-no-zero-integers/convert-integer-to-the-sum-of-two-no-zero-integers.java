class Solution {
    public int[] getNoZeroIntegers(int n) {
        int i=1,j=n-1;
        while(i<=j){
            if(!containsZero(i)&&!containsZero(j))return new int[]{i,j};

            i++;
            j--;
        }

        return new int[]{-1,-1};
    }

    private boolean containsZero(int num){
        

        while(num>0){
            int rem = num%10;
            if(rem==0) return true;
            num/=10;
        }
       return false;
    }
}