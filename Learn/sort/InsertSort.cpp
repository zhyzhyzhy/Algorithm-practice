#include <iostream>
using namespace std;
template <class T>
void InsertSort(T A[], int n)
{ 
  for(int i=1; i<n; i++){                //执行n-1趟
	    int j=i;
	    T temp=A[i];                      //待插入元素存入临时变量
while (j>0 && temp<A[j-1]){       //从后往前查找插入位置
		    A[j]=A[j-1];  j--;             //A[j-1]元素后移，j指针前移
	    }
	    A[j]=temp;                         //待插入元素存入找到的插入位置
  }
}
int main()
{
    int arr[100000];
    for(int i = 0; i < 100000; i++) 
        arr[i] = rand()%1000;
    InsertSort(arr,100000);
}