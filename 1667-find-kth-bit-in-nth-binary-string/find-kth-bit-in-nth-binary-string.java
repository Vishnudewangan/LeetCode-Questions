class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder prev = new StringBuilder("0");
        

        for(int i=2;i<=n;i++)
        {
            StringBuilder curr = new StringBuilder(prev);
            curr.append("1"+invert(prev.reverse()));
            prev = curr;
        }

        System.out.println(prev);
         
        return prev.charAt(k-1);
    }

    private String invert(StringBuilder sb){
          
          for(int i = 0; i < sb.length(); i++)
          {
            if(sb.charAt(i) == '1'){
                sb.setCharAt(i, '0');
            }
            else{
                sb.setCharAt(i, '1');
            }
          }

          return sb.toString();
    }
}