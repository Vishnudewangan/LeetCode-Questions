class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        String[] first = num1.split("\\+|i");
        String[] second = num2.split("\\+|i");
        
        int real1= Integer.parseInt(first[0]);
        int img1 = Integer.parseInt(first[1]);
        
        int real2 = Integer.parseInt(second[0]);
        int img2 = Integer.parseInt(second[1]);
        
        int ansReal = real1*real2 -(img1*img2);
        int ansImg  = real1*img2 + real2*img1;
        
        return ansReal+"+"+ansImg+"i";
    }
}