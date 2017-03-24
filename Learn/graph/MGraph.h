//
// Created by zhy on 11/24/16.
//

#ifndef GRAPH_MGRAPH_H
#define GRAPH_MGRAPH_H


#include "Graph.h"
#include <queue>
#include <iostream>
using namespace std;
template<class T>
class MGraph:public Graph<T>
{
public:
    MGraph(int mSize,const T& noedg);
    ~MGraph();
    int Insert(int u,int v, T w);
    int Remove(int u,int v);
    bool Exist(int u,int v)const;
    void DFS();
    void BFS();

protected:
    void DFS(int v, bool *visited);
    void BFS(int v, bool *visited);
    T**a;
    T noEdge;
};
template<class T>
MGraph<T>::MGraph(int mSize, const T& noedg)
{
    Graph<T>::n=mSize;
    Graph<T>::e=0;
    noEdge=noedg;
    a= new T*[Graph<T>::n];
    for(int i=0;i<Graph<T>::n;i++){
        a[i]=new T [Graph<T>::n];
        for (int j=0;j<Graph<T>::n;j++) a[i][j]=noEdge;
        a[i][i]=0;
    }
}
template<class T>
MGraph<T>::~MGraph()
{
    for(int i=0;i<Graph<T>::n;i++) delete []a[i];
    delete []a;
}


template<class T>
bool MGraph<T>::Exist(int u,int v)const
{
    if(u<0||v<0||u>Graph<T>::n-1||v>Graph<T>::n-1||u==v||a[u][v]==noEdge) return false;
    return true;
}
template <class T>
int MGraph<T>::Insert(int u,int v, T w)
{
    if(u<0||v<0||u>Graph<T>::n-1||v>Graph<T>::n-1||u==v) return 1;
    if(a[u][v]!=noEdge) return 4;
    a[u][v]=w; Graph<T>::e++; return 0;
}
template<class T>
int MGraph<T>::Remove(int u,int v)
{
    if(u<0||v<0||u>Graph<T>::n-1||v>Graph<T>::n-1||u==v) return 1;
    if(a[u][v]==noEdge) return 2;
    a[u][v]=noEdge;Graph<T>::e--; return 0;
}
template <class T>
void MGraph<T>::DFS() {
    bool visited[Graph<T>::n];
    for (int i = 0; i < Graph<T>::n; ++i) {
        visited[i] = false;
    }
    for (int i = 0; i < Graph<T>::n; ++i) {
        if(visited[i] == false)
            DFS(i, visited);
    }
}
template <class T>
void MGraph<T>::DFS(int v, bool *visited) {
    visited[v] = true;
    cout << " " << v ;
    for (int i = 0; i < Graph<T>::n; ++i) {
        if(visited[i] == false && a[v][i] != 0)
            DFS(i,visited);
    }
}
template <class T>
void MGraph<T>::BFS() {
    bool visited[Graph<T>::n];
    for (int i = 0; i < Graph<T>::n; ++i)
        visited[i] = false;
    for (int i = 0; i < Graph<T>::n; ++i) {
        if(visited[i] == false)
            BFS(i,visited);
    }
}
template <class T>
void MGraph<T>::BFS(int v, bool *visited) {
    visited[v] = true;
    cout << " " << v;
    queue<int> q;
    q.push(v);
    while(!q.empty()) {
        v = q.front();
        q.pop();
        for (int i = 0; i < Graph<T>::n; ++i) {
            if(visited[i] == false && a[v][i] != 0) {
                visited[i] = true;
                cout << " " << i;
                q.push(i);
            }
        }
    }
}


#endif //GRAPH_MGRAPH_H
