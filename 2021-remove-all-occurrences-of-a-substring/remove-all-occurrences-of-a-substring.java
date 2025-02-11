class Solution {
    public String removeOccurrences(String s, String part) {
        return solve(new StringBuilder(s),part).toString();
    }
    private StringBuilder solve(StringBuilder sb, String part)
    {
        if(sb.length()==0) return sb;

        int idx=  sb.indexOf(part);

        if(idx==-1) return sb;

        sb.delete(idx,idx+part.length());
        solve(sb,part);
        return sb;
        
    }
}