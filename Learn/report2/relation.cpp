//
// Created by zhy on 10/19/16.
//

#include "relation.h"
#include <iostream>
using namespace std;
relation::relation(int x) {
    dense = x;
    matrix = new int*[x];
    for(int i = 0; i < x; i++)
        matrix[i] = new int[x];
    for(int i= 0; i < dense; i++)
        for(int j = 0; j < dense; j++)
            matrix[i][j] = 0;
}
relation::~relation() {
    for(int i = 0; i < dense; i++)
        delete matrix[i];
    delete matrix;
}
void relation::initialize() {
    cout << "输入矩阵对，以-1结束,注意第一个元素是1,1" << endl;
    int i = 0;
    int j = 0;

    while(true) {
        cin >> i;
        if( i == -1)
            break;
        cin >> j;
        matrix[i-1][j-1] = 1;
    }
}
bool relation::isReflexive() {
    for(int i = 0;i < dense; i++)
        if(matrix[i][i] == 0)
            return false;
    return true;
}
bool relation::isSymmetry() {
    for(int i = 0; i < dense; i++)
        for(int j = 0; j < i; j++)
            if(matrix[i][j] != matrix[j][i])
                return false;
    return true;
}
bool relation::isTransitivity() {
    int mDotm[dense][dense] = {0};
    for(int i = 0; i < dense; i++)
        for(int j = 0; j < dense; j++)
            for(int k = 0; k < dense; k++)
                mDotm[i][j] = mDotm[i][j] + matrix[i][k] * matrix[k][j];

    for(int i = 0; i < dense; i++)
        for(int j = 0; j < dense; j++) {
            if (matrix[i][j] == 1) {
                if (mDotm[i][j] == 0) {
                    return false;
                }
            }
        }
    return true;
}
bool relation::isNotReflexive() {
    for(int i = 0; i < dense; i++)
        if(matrix[i][i] != 0)
            return false;
    return true;
}
bool relation::isNotSymmetry() {
    for(int i = 0; i < dense; i++)
        for(int j = 0; j <= i; j++) {
            if(matrix[i][j] == 1 && matrix[j][i] == 1)
                if(i != j)
                    return false;
        }
    return true;
}
void relation::show() {
    for(int i = 0; i < dense; i++) {
        for(int j = 0; j < dense; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}
void relation::judge() {
    if(isReflexive())
        cout << "具有自反性" << endl;
    else
        cout << "不具有自反性" << endl;
    if(isSymmetry())
        cout << "具有对称性" << endl;
    else
        cout << "不具有对称性" << endl;
    if(isTransitivity())
        cout << "具有传递性" << endl;
    else
        cout << "不具有传递性" << endl;
    if(isNotReflexive())
        cout << "具有反自反性" << endl;
    else
        cout << "不具反自反性" << endl;
    if(isNotSymmetry())
        cout << "具有反对称性" << endl;
    else
        cout << "不具有反对称性" << endl;

}
