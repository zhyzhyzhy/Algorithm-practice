//
// Created by zhy on 11/24/16.
//

#ifndef GRAPH_LGRAPH_H
#define GRAPH_LGRAPH_H

#include "Graph.h"
#include <stdio.h>
template<class T >
struct ENode
{
    ENode()  { nextArc=NULL; }
    ENode(int vertex,T weight, ENode* next)
    {
        adjVex=vertex; w=weight; nextArc=next;
    }
    int adjVex;
    T w;
    ENode* nextArc;
};
template<class T>
class LGraph: public Graph<T>
{
public:
    LGraph(int mSize);
    ~LGraph();
    int Insert(int u,int v, T& w) ;
    int Remove(int u,int v) ;
    bool Exist(int u,int v)const ;
    int TotalInDu(int n);
protected:
    ENode<T>** a;
};
template<class T>
LGraph<T >::LGraph(int mSize)
{
    Graph<T>::n=mSize;Graph<T>::e=0;
    a=new ENode<T>* [Graph<T>::n];
    for (int i=0;i<Graph<T>::n;i++) a[i]=NULL;
}
template<class T>
LGraph<T >::~LGraph()
{
    ENode<T>* p,*q;
    for(int i=0;i<Graph<T>::n;i++){
        p=a[i];q=p;
        while (p) {
            p=p->nextArc;delete q;q=p;
        }
    }
    delete[] a;
}
template<class T>
bool LGraph<T >::Exist(int u,int v)const
{
    if(u<0||v<0||u>Graph<T>::n-1||v>Graph<T>::n-1||u==v) return false;
    ENode<T>* p=a[u];
    while (p&& p->adjVex!=v) p=p->nextArc;
    if (!p) return false;
    else return true;
}
template<class T>
int LGraph<T >::Insert(int u,int v, T& w)
{
    if(u<0||v<0||u>Graph<T>::n-1||v>Graph<T>::n-1||u==v) return 1;
    if(Exist(u,v))return 4;
    ENode<T>* p=new ENode<T>(v,w,a[u]);
    a[u]=p;
    Graph<T>::e++;
    return 0;
}
template<class T>
int LGraph<T>::Remove(int u,int v)
{
    if(u<0||v<0||u>Graph<T>::n-1||v>Graph<T>::n-1||u==v) return 1;
    ENode<T>* p=a[u],*q=NULL;
    while (p&& p->adjVex!=v){
        q=p;p=p->nextArc;
    }
    if (!p) return 2;
    if (q) q->nextArc=p->nextArc;
    else a[u]=p->nextArc;
    delete p;
    Graph<T>::e--;
    return 0;
}
template <class T>
int LGraph<T>::TotalInDu(int n) {
    int total = 0;
    for (int i = 0; i < Graph<T>::n; ++i) {
        ENode<T> *p = a[i];
        while (p != NULL) {
            if(p->adjVex == n)
                total++;
            p = p->nextArc;
        }
    }
    return total;
}



#endif //GRAPH_LGRAPH_H
