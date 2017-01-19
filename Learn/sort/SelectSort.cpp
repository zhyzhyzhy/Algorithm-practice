#include <iostream>
using namespace std;
template <class T>
void Swap(T &a, T &b) {
    T temp = a;
    a = b;
    b = temp;
}
template <class T>
void SelectSort(T A[], int n)
{ 
	  int small;
for (int i=0; i<n-1; i++) {        //执行n-1趟
	     small=i;                        //先假定待排序序列中第一个元素为最小
    for (int j=i+1;j<n;j++)         //每趟扫描待排序序列n-i-1次
         if (A[j]<A[small]) small=j; //如果扫描到一个比最小值元素还小的，则记下其下标
      Swap(A[i],A[small]);            //最小元素与待排序序列中第一个元素交换
  }
}
int main() 
{
    int arr[100000];
    for(int i = 0; i < 10000; i++) 
        arr[i] = rand()%1000;
    SelectSort(arr,100000);
}
