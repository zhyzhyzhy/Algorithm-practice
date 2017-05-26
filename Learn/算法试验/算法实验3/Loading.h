//
// Created by zhy on 5/26/17.
//

#ifndef INC_3_LOADING_H
#define INC_3_LOADING_H

#include <iostream>

using namespace std;

template<class T>
class Loading {
private:
    int n, //集装箱数
            *x, //当前解
            *bestx; //当前第一艘船的最优解
    T c1, //第一艘轮船的核定载重量
            c2, //第二艘轮船的核定载重量
            *w, //集装箱重量数组
            total, //所有集装箱重量之和
            cw, //当前第一艘船的载重量
            bestw, //当前第一艘船的最优载重量
            r; //剩余集装箱总重量
public:
    Loading(int n, int c1, int c2, int *w) //构造函数
    {
        this->n = n;
        x = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            x[i] = -1;
        }
        bestx = new int[n + 1];
        this->c1 = c1;
        this->c2 = c2;
        this->w = new int[n + 1];
        this->total = 0;
        for (int i = 1; i < n + 1; i++) {
            this->w[i] = w[i - 1];
            this->total += w[i];
        }
        this->w[0] = 0;
        this->r = this->total;
    }

    ~Loading() //析构函数
    {
        delete x;
        delete bestx;
        delete w;
    }

    void Backtrack(int i);//找到最接近第一艘轮船载重c1的最佳装载方案，
    //最优载重值bestw，最优解数组bestx。
    void Iteration(); //迭代找出
    void Show();//输出整个装载方案

};

template<class T>
void Loading<T>::Backtrack(int i) { //搜索第i层结点
    if (i > n) {//到达叶节点
        if (cw > bestw) {
            for (int j = 1; j <= n; j++)
                bestx[j] = x[j];
            bestw = cw;
        }
        return;
    }

    //搜索子树
    r -= w[i];
    if (cw + w[i] <= c1) //x[i]=1时的可行解约束条件
    {//搜索左子树
        x[i] = 1;
        cw += w[i];
        Backtrack(i + 1);
        cw -= w[i];
    }
    if (cw + r > bestw) //x[i]=0时增加的约束函数，剪去不含最优解的分枝
    {//搜索右子树
        x[i] = 0;
        Backtrack(i + 1);
    }
    r += w[i];
}

template<class T>
void Loading<T>::Iteration() {
    int i = 1;
    while (i > 0) {
        if (i > n) {
            if (cw > bestw) {
                for (int j = 1; j <= n; j++)
                    bestx[j] = x[j];
                bestw = cw;
            }
            i--;
            continue;
        }
        if (x[i] == -1) {
            if (cw + w[i] <= c1 && cw + r > bestw) {
                x[i] = 1;
                cw += w[i];
                i++;
                continue;
            }
            else {
                x[i] = 0;
                i++;
                continue;
            }
        }
        if (x[i] == 1) {
            x[i] = 0;
            cw -= w[i];
            i++;
            continue;
        }
        if (x[i] == 0) {
            x[i] = -1;
            i--;
        }
    }


}
template<class T>
void Loading<T>::Show() {
    for (int i = 1; i < n + 1; i++) {
        cout << bestx[i] << " ";
    }
    cout << endl;
    cout << bestw << endl;
}

#endif //INC_3_LOADING_H
