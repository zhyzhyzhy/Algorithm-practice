#include <iostream>
#include <stdio.h>
using namespace std;
int print(int** matrix, int n);
void getMaxMin(int **matrix, int n, int *max, int *min);
bool isYBG(int p, int q, int ** matrix, int n, int max, int min);
int main()
{
    freopen("file.txt","r",stdin);
    int Length;
    cin >> Length;

    int **matrix = new int*[Length];
    for(int i = 0; i < Length; i++ ) {
        matrix[i] = new int[Length];
        for(int j = 0; j < Length; j++) {
            matrix[i][j] = 0;
        }
    }
     
    int a,b;
    while(scanf("%d,%d",&a,&b) != EOF) {
        matrix[a-1][b-1] = 1;
    }

    print(matrix,Length);
    //求盖住关系
    for(int i = 0; i < Length; i++) {
        for(int j = 0; j < Length; j++) {
            if(matrix[i][j] == 1) {
                int k;
                for(k = 0; k < Length; k++) {
                    if(matrix[i][k] == 1 && matrix[k][j] == 1 && k != j && i != k)
                        break;
                }
                if(k == Length && i != j) {
                    cout << "(" << i+1 << "," << j+1 << ")  ";
                }
            }
        }
    }
    cout <<  endl;
    //判断是否是有补格
    int max, min;
    getMaxMin(matrix,Length,&max,&min);
    cout << "全上界 = "<< max+1 << endl;
    cout << "全下界 = " << min+1 << endl;
    int flag = 0;
    for(int i = 0; i < Length; i++) {
        for(int j = 0; j < Length; j++) {
            if(!isYBG(i,j,matrix,Length,max,min))
               flag = 1;
        }
    }
    if(flag == 0)
        cout << "是有补格" << endl;
    else 
        cout << "不是有补格" << endl;



}
int print(int** matrix, int n) {
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl; 
    }
}
void getMaxMin(int **matrix, int n, int *max, int *min) {
    bool judgeMin[n], judgeMax[n];
    for(int i = 0; i < n; i++) {
        judgeMin[i] = true;
        judgeMax[i] = true;
    }
    for(int i = 0; i < n; i++) {
        int flag = 0;
        for(int j = 0; j < n; j++) {
            if(matrix[i][j] == 1 ) {
                flag = 1;
                if(i == j)
                    continue;
                judgeMin[j] = false;
                judgeMax[i] = false;
            }
        }
        if(flag == 0) {
            judgeMax[i] = false;
            judgeMin[i] = false;
        }
    }
    for(int i = 0; i < n; i++) {
        if(judgeMax[i] == true) {
            *max = i;
        }
        if(judgeMin[i] == true)
            *min = i;
    }
}
bool isYBG(int p, int q, int ** matrix, int n, int max, int min) {
    bool JudgeP[n];
    bool JudgeQ[n];
    bool MaxIsSame = false;
    bool MinIsSame = false;
    for(int i = 0; i < n ; i++) {
        JudgeP[i] = false;
        JudgeQ[i] = false;
    }
    for(int i = 0; i < n; i++) {
        if(matrix[p][i] == 1 && p != i)
            JudgeP[i] = true;
        if(matrix[q][i] == 1 && q != i)
            JudgeQ[i] = true;
    }
    for(int i = 0; i < n; i++) {
        if(JudgeP[i] == true && JudgeQ[i] == true )
            if(i == max) {
                MaxIsSame = true;
            }
    }
    for(int i = 0; i < n ; i++) {
        JudgeP[i] = false;
        JudgeQ[i] = false;
    }
    for(int i = 0; i < n; i++) {
        if(matrix[i][p] == 1 )
            JudgeP[i] = true;
        if(matrix[i][q] == 1)
            JudgeQ[i] = true;
    }
    for(int i = 0; i < n; i++) {
        if(JudgeP[i] == true && JudgeQ[i] == true )
            if(i == min) {
                MinIsSame = true;
            }
    }
    if(MaxIsSame && MinIsSame)
        return true;
    else
        return false;

}

