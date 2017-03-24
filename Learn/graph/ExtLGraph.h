//
// Created by zhy on 11/24/16.
//

#ifndef GRAPH_EXTLGRAPH_H
#define GRAPH_EXTLGRAPH_H

#include "Lgraph.h"
#include <iostream>
using namespace std;
template <class T>
class ExtLGraph: public LGraph<T>
{
public:
    ExtLGraph(int mSize):LGraph<T>(mSize){}
    void DFS();
    void BFS();

private:
    void DFS(int v,bool* visited);
    void BFS(int v,bool* visited);
};
template<class T>
void ExtLGraph<T >::DFS()
{
    bool* visited=new bool [Graph<T>::n];
    int i;
    for(i=0;i<Graph<T>::n;i++) visited[i]=false;
    for (i=0;i<Graph<T>::n;i++)
        if (!visited[i]) DFS(i,visited);
    delete[]visited;
}
template<class T>
void ExtLGraph<T >::DFS(int v,bool* visited)
{
    visited[v]=true;
    cout<<" "<<v;
    for (ENode<T> *w=LGraph<T>::a[v]; w; w=w->nextArc) {
        if (!visited[w->adjVex])
            DFS(w->adjVex,visited);
    }
}

template<class T>
void ExtLGraph<T >::BFS(int v, bool* visited)
{
    SeqQueue<int> q(QSize);
    visited[v]=true; cout<<" "<<v;
    q.EnQueue(v);
    while (! q.IsEmpty()){
        q.Front(v);q. DeQueue();
        for (ENode<T> *w=a[v];w;w=w->nextArc)
            if (!visited[w->adjVex]){
                visited[w->adjVex]=true;cout<<" "<< w->adjVex;
                q.EnQueue(w->adjVex);
            }
    }
}

#endif //GRAPH_EXTLGRAPH_H
