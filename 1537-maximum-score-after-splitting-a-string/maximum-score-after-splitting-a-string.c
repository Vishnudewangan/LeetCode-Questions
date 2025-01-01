int maxScore(char* s) {  
   int n =strlen(s);
   int prefix1Cnt[n];
   memset(prefix1Cnt, 0 , n*sizeof(int));

   prefix1Cnt[0] = s[0]=='1'? 1 : 0;
   for(int i=1;i<n;i++) prefix1Cnt[i] = (prefix1Cnt[i-1]+ (s[i]=='1'? 1 : 0));

   int pre0Cnt=0;
   int ans =0;
   for(int i=0;i<n-1;i++)
   {
       pre0Cnt +=s[i]=='0' ? 1:0;

       ans = ans > (pre0Cnt + prefix1Cnt[n-1]-prefix1Cnt[i]) ? ans : pre0Cnt + prefix1Cnt[n-1]-prefix1Cnt[i];
   }
   return ans;
}