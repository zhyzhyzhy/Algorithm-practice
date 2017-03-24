#include <iostream>
#include <stdlib.h>
using namespace std;
template <class T>
void Swap(T &a, T &b) {
    T temp = a;
    a = b;
    b = temp;
}
template <class T>
void BubbleSort(T A[], int n)
{ 
    int i,j,last;
    i=n-1;                    
    while (i>0){                    //最多进行n-1趟
        last=0;                     //进入循环就将last置成0
        for (j=0; j<i; j++)          //从上往下进行相邻元素的两两比较
            if (A[j+1]<A[j]){      
                Swap(A[j],A[j+1]);  //由于后者小，故交换
                last=j;              //有交换就将last置成j
            }
        i=last;                        //如果一趟排序中没有交换元素，则last为0
    }
}
int main()
{
    int arr[100000];
    for(int i = 0; i < 100000; i++) 
        arr[i] = rand()%1000;
    BubbleSort(arr, 100000);
}
