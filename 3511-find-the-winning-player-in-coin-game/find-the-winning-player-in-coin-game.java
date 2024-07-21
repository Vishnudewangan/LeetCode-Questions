class Solution {
    public String losingPlayer(int x, int y) {
       boolean isAlice = false;

       while(x>0 && y>3)
       {
         x-=1;
         y-=4;
         isAlice=!isAlice;
       }

       return isAlice ? "Alice" : "Bob";
    }
}