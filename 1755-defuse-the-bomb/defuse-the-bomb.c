/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* decrypt(int* code, int codeSize, int k, int* returnSize) {
    
    int* ans;
    ans = (int*)malloc(codeSize * sizeof(int));

    for(int i=0;i<codeSize;i++)
    {
      
         if(k>0)
        {   
            int sum = 0;
            for(int j=1;j<=k;j++)
            {
                 sum += code[(i+j)%codeSize];
            }
            ans[i] = sum;
        }
        else if(k<0)
        {
            int posK = abs(k);
            int sum = 0;
            for(int j=1;j<=posK;j++)
            {
                sum+=code[(codeSize+i - j)%codeSize];

            }
            ans[i] = sum;
        }
        if(k==0)
        {
            for(int j=0;j<codeSize;j++)
            {
                ans[j]= 0;
            }
            break;
        }

    }
      *returnSize = codeSize;
    return ans;
}