//
// Created by zhy on 10/27/16.
//

#ifndef HFMTREE_PRIOQUEUE_H
#define HFMTREE_PRIOQUEUE_H

#include <stdio.h>
template<class T>
class PrioQueue
{
public:
    PrioQueue(int mSize=20);
    ~PrioQueue(){delete[] q;};
    bool IsEmpty() const{return  n==0;}
    bool IsFull() const{return  n==maxSize;}
    void Append( T &x);
    void Serve(T &x);
private:
    void AdjustDown (int r, int j);
    void AdjustUp (int j);
    T *q;
    int n,maxSize;
};
template <class T>
PrioQueue<T>::PrioQueue(int mSize)
{
    maxSize=mSize;
    n=0;
    q=new T[maxSize];
}



//程序5.13 函数AdjustUp
template <class T>
void PrioQueue<T>::AdjustUp (int j)
{
    T temp=q[j];
    int i=j;
    while  (i>0 && temp.root->element < q[(i-1)/2].root->element){
        q[i]=q[(i-1)/2];
        i=(i-1)/2;
    }
    q[i]=temp;
}
template <class T>
void PrioQueue<T>::AdjustDown(int r, int j) {
    T temp=q[r];
    int child=2*r+1;
    while  (child<=j) {
        if (( child <j) && ( q[child].root->element > q[child+1].root->element))
            child++;
        if(temp.root->element <= q[child].root->element)
            break;
        q[(child-1)/2] = q[child];
        child=2*child+1;
    }
    q[(child-1)/2]=temp;
}
//程序5.14 函数Append和Serve
template <class T>
void PrioQueue<T>::Append(T& x)
{
    if(IsFull()) return;
    q[n++]=x;
    AdjustUp(n-1);
}
template <class T>
void PrioQueue<T>::Serve(T &x)
{
    if(IsEmpty()) return;
    x=q[0];
    q[0]=q[--n];
    AdjustDown(0, n-1);
}
#endif //HFMTREE_PRIOQUEUE_H
