/**
  File Name: MergeSort.cpp
Author: zhy
Created Time: 2016/12/11 - 13:21:21
*/
#include <iostream>
using namespace std;
template <class T>
void Merge(T A[],int i1,int j1,int i2,int j2)   
{  // i1,j1是子序列1的下、上界，i1,j2是子序列2的下、上界
	T *Temp=new T[j2-i1+1];             //分配能存放两个子序列的临时数组
	int i=i1,j=i2,k=0;                   //i,j是两个子序列的游动指针，k是Temp的游动指针
	while (i<=j1&&j<=j2)                //若两个子序列都不空，则循环
		if (A[i]<=A[j]) Temp[k++]=A[i++];   //将A[i]和A[j]中较小的存入Temp[k]
		else Temp[k++]=A[j++];
	while (i<=j1) Temp[k++]=A[i++];     //若第一个子序列中还有剩余的就存入Temp
	while (j<=j2) Temp[k++]=A[j++];     //若第二个子序列中还有剩余的就存入Temp
	for (i=0; i<k; i++) A[i1++]=Temp[i]; //将临时数组中的元素倒回A
	delete [] Temp;                       
}

template <class T>
void MergeSort(T A[], int n)
{	
	int i1,j1,i2,j2;      //i1,j1是子序列1的下、上界，i2,j2是子序列2的下、上界
	int size=1;                      //子序列中元素个数，初始化为1。
	while (size<n){ 
		i1=0;  
		while (i1+size<n){ //若i1+size<n，则说明存在两个子序列，需再两两合并
			i2=i1+size;                  //确定子序列2的下界
			j1=i2-1;               //确定子序列1的上界
			if (i2+size-1>n-1) 
				j2=n-1;  //若第2个子序列中不足size个元素，则置子序列2的上界j2=n-1
			else j2=i2+size-1;        //否则有size个，置j2=i2+size-1
			Merge(A,i1,j1,i2,j2);     //合并相邻两个子序列
			i1=j2+1;                  //确定下一次合并第一个子序列的下界
		} 
		size*=2;                     //元素个数扩大一倍
	}
}
int main(int argc, char *argv[])
{
    int arr[100000];
    for(int i = 0; i < 100000; i++) 
        arr[i] = rand()%1000;
    MergeSort(arr,100000);
	return 0;
}
