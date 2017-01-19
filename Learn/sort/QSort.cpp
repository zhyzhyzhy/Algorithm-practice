/**
  File Name: QSort.cpp
Author: zhy
Created Time: 2016/12/11 - 13:14:56
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
void QuickSort(T A[], int n) {
    QSort(A,0,n-1);                   //以初始序列为待排序序列开始快速排序
}
template <class T>
void QSort(T A[], int left, int right)    //left和right为待排序序列的下界和上界
{ 
    int i,j;
    if (left<right){                     //若待排序序列多于一个元素，则继续快速排序
        i=left; j=right+1;               //确定待排序序列的游动指针i,j
        do{                              //开始一趟快速排序,A[left]作为分割元素
            do i++;while (A[i]<A[left]);  //i指针从左往右找第一个分割元素的元素
            do j--; while (A[j]>A[left]);//j指针从右往左找第一个分割元素的元素
            if (i<j) Swap(A[i],A[j]);    //若i<j，则交换两个元素
        }while (i<j);                    //若i<j，则继续本趟排序
            Swap(A[left],A[j]);             //交换分割元素A[left]和A[j]的位置
            QSort(A,left,j-1);               //对低端序列快速排序
            QSort(A,j+1,right);             //对高端序列快速排序
    }
} 
int main(int argc, char *argv[])
{
    int arr[100000];
    for(int i = 0; i < 100000; i++) 
        arr[i] = rand()%1000;
    QSort(arr,0,100000);
    return 0;
}
