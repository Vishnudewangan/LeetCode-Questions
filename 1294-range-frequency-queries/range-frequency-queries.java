class RangeFreqQuery {
    
    Map<Integer,ArrayList<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.putIfAbsent(arr[i],new ArrayList<>());
           map.get(arr[i]).add(i);

        }
    }
    
    public int query(int left, int right, int value) {
        ArrayList<Integer> arr = map.containsKey(value) ? map.get(value) : new ArrayList<>();

        if(arr.size() == 0) return 0;

           int lb = lowerBound(arr,left);
           int ub = upperBound(arr,right);

           return ub - lb;
          
    }

    private int lowerBound(ArrayList<Integer> arr, int target){
        
        int lo = 0;
        int hi = arr.size() - 1;
        int ans = arr.size();// default ans, if all the elements are less than target;

        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;

            if(check1(mid,target,arr)==1){
                ans = mid ;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }

    private int check1(int mid , int target, ArrayList<Integer> arr){
        if(arr.get(mid) >= target) return 1;
        else return 0;
    }
    private int upperBound(ArrayList<Integer> arr, int target){
        int lo = 0;
        int hi = arr.size() - 1;

        int ans = arr.size(); // default ans what if there are not no greater element than target

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(check2(mid,target,arr)==1){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    private int check2(int mid, int target, ArrayList<Integer> arr){
       if(arr.get(mid) > target) return 1;
       else return 0;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */