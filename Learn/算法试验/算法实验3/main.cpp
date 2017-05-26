#include <iostream>
#include <math.h>
#include "Loading.h"

using namespace std;
bool Place(int k,int i,int *x) //判定两个皇后是否在同一列或在同一斜线上
{
    for (int j=0;j<k;j++)
        if ((x[j]==i)||(abs(x[j]-i)==abs(j-k)))
            return false;
    return true;
}
void NQueens(int k,int n,int *x) //递归函数（求解n皇后问题）
{
    for (int i=0;i<n;i++)
    {
        if(Place(k,i,x))
        {
            x[k]=i;
            if (k==n-1)
            {
                for (i=0;i<n;i++)
                    cout<<x[i]<<" ";
                cout << endl;
            }
            else
            {
                NQueens(k+1,n,x);
            }
        }
    }
}
void NQueens(int n,int *x)
{
    NQueens(0,n,x);
}
int main()
{
//    int x[8];
//    for (int i=0;i<8;i++)
//        x[i]=-1;
//    NQueens(8,x);
    int weight[] = {22,35,24,15,4};
    Loading<int> *ld = new Loading<int>(5,60,40,weight);
//    ld->Backtrack(1);
//    ld->Show();
    ld->Iteration();
    ld->Show();
}