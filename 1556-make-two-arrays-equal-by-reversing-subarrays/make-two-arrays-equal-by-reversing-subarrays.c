
int compare(const void* a , const void* b)
{
    int n1 = *((int*)a);
    int n2 = *((int*)b);

    return n1-n2;
}
bool canBeEqual(int* target, int targetSize, int* arr, int arrSize) {

    
    qsort(target,targetSize,sizeof(int),compare);
    qsort(arr,arrSize,sizeof(int),compare);

    for(int i=0;i<targetSize;i++)
    {
        if(target[i]!=arr[i]) return false;
    }

    return true;
}    
