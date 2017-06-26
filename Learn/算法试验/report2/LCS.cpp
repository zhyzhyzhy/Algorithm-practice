//
// Created by zhy on 5/20/17.
//
#include <iostream>
#include "LCS.h"
using namespace std;

int LCS::LCSLength() {
    for (int i=0;i<=m;i++)
        c[i][0]=0;
    for (int j=1;j<=n;j++)
        c[0][j]=0;
    for (int i=1;i<=m;i++)
    {
        for (int j=1;j<=n;j++)
        {
//            cout << a[i] << " " << b[j] << endl;
            if (a[i] == b[j])
            {
                c[i][j] = c[i-1][j-1]+1;
                s[i][j] = 1;
            }
            else if (c[i-1][j] >= c[i][j-1])
            {
                c[i][j] = c[i-1][j];
                s[i][j] = 2;
            }
            else
            {
                c[i][j] = c[i][j-1];
                s[i][j] = 3;
            }


        }

    }
    return c[m][n];
}

void LCS::CLCS(int i,int j) const {
    if (i==0||j==0||s[i][j]==0)
        return;
    if (s[i][j]==1)
    {
        CLCS(i-1,j-1);
        cout<<a[i];
    }
    else
    if (s[i][j]==2)
        CLCS(i-1,j);
    else CLCS(i,j-1);
}
