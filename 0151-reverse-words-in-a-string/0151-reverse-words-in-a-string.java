class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder out = new StringBuilder("");
        for (int i = parts.length - 1; i > 0; i--) {
            out.append(parts[i] + " ");
        }
        return out.append(parts[0]).toString();
    }
}