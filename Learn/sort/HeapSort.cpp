/**
  File Name: HeapSort.cpp
Author: zhy
Created Time: 2016/12/11 - 13:24:23
*/
#include <iostream>
using namespace std;
template <class T>
void Swap(T &a, T &b) {
    T temp = a;
    a = b;
    b = temp;
}
template <class T>
void AdjustDown(T A[], int r, int j)       
{  
    int child=2*r+1; T temp=A[r];        
    while(child<=j) {
        if((child<j)&&(A[child]<A[child+1])) child++;  //找两个孩子中较大的孩子
        if (temp>= A[child]) break;
        A[(child-1)/2]=A[child];
        child=2*child+1;
    }
    A[(child-1)/2]=temp;
}
template <class T>
void HeapSort(T A[], int n)
{
    int i;
    for(i=(n-2)/2; i>-1; i--) AdjustDown(A,i,n-1);  //构造最大堆
    for(i=n-1; i>0; i--){
        Swap(A[0],A[i]);                     //堆顶和堆底元素交换位置
        AdjustDown(A,0,i-1);                 //将A[0]向下调整为堆
    }
}
int main(int argc, char *argv[])
{
    int arr[100000];
    for(int i = 0; i < 100000; i++) 
        arr[i] = rand()%1000;
    HeapSort(arr,100000);
    return 0;
}
