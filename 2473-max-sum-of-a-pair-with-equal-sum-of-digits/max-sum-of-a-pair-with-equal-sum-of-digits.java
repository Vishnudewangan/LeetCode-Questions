class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,TreeSet<Integer>>map =new HashMap<>();
        HashMap<Integer,Integer> mapFreq = new HashMap<>();// SOD v/s freq. of 

        for(int val : nums)
        {
            int SOD = sumOfDigits(val);
            TreeSet<Integer> set = map.getOrDefault(SOD,new TreeSet<>());
            set.add(val);
            map.put(SOD,set);
            mapFreq.put(SOD,mapFreq.getOrDefault(SOD,0)+1);
        }

        int maxSum=-1;

        for(int key : map.keySet())
        {
            int cnt = mapFreq.get(key);

            if(cnt>1)
            {
                int largest  = map.get(key).pollLast();

                int secondLargest;
                if(map.get(key).size()==0)
                {
                    secondLargest = largest;
                }
                else
                {
                   secondLargest = map.get(key).pollLast();
                }

                maxSum = Math.max(maxSum , largest + secondLargest);
            }
        }
        return maxSum;


    }
    private int sumOfDigits(int n)
    {
        int sum = 0;

        while(n > 0)
        {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}