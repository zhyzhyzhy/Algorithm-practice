//
// Created by zhy on 12/2/16.
//

#ifndef GRAPH_EXTMGRAPH_H
#define GRAPH_EXTMGRAPH_H

#include <iostream>
#include "MGraph.h"
#define INFTY 100000

using namespace std;
template <class T>
class ExtMGraph : public MGraph<T> {
public:
    ExtMGraph(int mSize, const T &noedg) : MGraph<T>(mSize, noedg) {}
    int Choose(int *d, bool *s);
    //飞机问题
    void Plane(int v, int u);
private:
    void Dijkstra(int v, T* d,int *path);
};

template <class T>
int ExtMGraph<T>::Choose(int* d, bool* s)
{
    int i,minpos;
    T min;
    min=INFTY;
    minpos=-1;
    for (i=1;i<Graph<T>::n;i++)
        if (d[i]<min &&!s[i]){
            min=d[i];
            minpos=i;
        }
    return minpos;
}
template <class T>
void ExtMGraph<T>::Dijkstra(int v,T* d,int* path) {
    int i, k, w;
    if (v < 0 || v > Graph<T>::n - 1) {
        cout << "out of bound" << endl;
        return;
    }
    bool *s = new bool[Graph<T>::n];
    for (i = 0; i < Graph<T>::n; i++) {
        s[i] = false;
        d[i] = MGraph<T>::a[v][i];
        if (i != v && d[i] < INFTY)
            path[i] = v;
        else
            path[i] = -1;
    }
    s[v] = true;
    d[v] = 0;
    for (i = 1; i < Graph<T>::n-1; i++) {
        k = Choose(d, s);
        s[k] = true;       //选择当前路径最短者，加入S
        for (w = 0; w < Graph<T>::n; w++)             //更新d和path
            if (!s[w] && d[k] + MGraph<T>::a[k][w] < d[w]) {
                d[w] = d[k] + MGraph<T>::a[k][w];
                path[w] = k;
            }
    }
}

template <class T>
void ExtMGraph<T>::Plane(int v, int u) {
    T *d = new T[Graph<T>::n];
    int *path = new int[Graph<T>::n];
    Dijkstra(v, d, path);
    cout << "From " << v << " to " << u << endl;
    cout << "路径：";
    //qiu lu jing
    T road[Graph<T>::n];
    int count = 0;
    int i = u;
    while(i != 0) {
        i = path[i];
        road[count++] = i;
    }
    for (int j = count-1; j >= 0; --j) {
        cout << road[j] << " ";
    }
    cout << u << endl;

    //
    cout << "长度:" << d[u] << endl;
    cout << endl;
    delete d;
    delete path;
}


#endif //GRAPH_EXTMGRAPH_H
