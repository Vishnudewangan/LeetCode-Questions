class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        
       TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int val : A) m.put(val, m.getOrDefault(val, 0) + 1);
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            Integer x = m.higherKey(B[i]);
            if (x == null) x = m.firstKey();
            m.put(x, m.get(x) - 1);
            if (m.get(x) == 0) m.remove(x);
            res[i] = x;
        }
        return res;
    }
}