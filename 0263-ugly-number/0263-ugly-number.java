class Solution {
    public boolean isUgly(int n) {
        if(n<=0) return false;
     if(n<=1) return true;
        
        int count=0;
        int[] countOfGPrime=new int[3];
        
        while(n%2==0)
        {
            count++;
            countOfGPrime[0]+=1;
            n/=2;
            
        }
        while(n%3==0){
            count++;
            countOfGPrime[1]+=1;
            
            n/=3;
        }
        
        for(int i=5;i*i<=n;i=i+6)
        {
            while(n%i==0)
            {
                count++;
                if(i==5)
                countOfGPrime[2]+=1;
                n=n/i;
                
            }
            
            while(n%(i+2)==0)
            {
                count++;
                 if(i+2==5)
                countOfGPrime[2]+=1;
                n=n/(i+2);
            }
        }
        
        if(n>3)
        {
            count++;
             if(n==5)
                countOfGPrime[2]+=1;
               
        }
        
        int lPrime=count- (countOfGPrime[0]+countOfGPrime[1]+countOfGPrime[2]);
        
        return lPrime==0? true: false;
        
        
    }
}