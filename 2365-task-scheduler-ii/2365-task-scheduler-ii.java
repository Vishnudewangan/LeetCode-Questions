class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
         Map<Integer, Long> last = new HashMap<>();;
        long res = 0;
        for (int a : tasks)
            if (last.containsKey(a))
                last.put(a, res = Math.max(res, last.get(a) + space) + 1);
            else
                last.put(a, ++res);
        return res;
    }
}