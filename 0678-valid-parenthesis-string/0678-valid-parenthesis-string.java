class Solution {
   public boolean checkValidString(String s) {  
    int leftBalance = 0;
    for (int i=0; i<s.length(); i++) {
      if ((s.charAt(i) == '(') || (s.charAt(i) == '*'))
        leftBalance++;        
      else
        leftBalance--;
        
      if (leftBalance<0) return false;
    }
    if (leftBalance == 0) return true;            
    int rightBalance = 0;
    for (int i=s.length()-1; i>=0; i--) {
      if ((s.charAt(i) == ')') || (s.charAt(i) == '*'))
        rightBalance++;
      else
        rightBalance--;
      
      if (rightBalance<0) return false;
    }
    return true;
  }
}