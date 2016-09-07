//
// Created by zhy on 9/7/16.
//

#ifndef LIST_SINGLELIST_H
#define LIST_SINGLELIST_H

#include "linearlist.h"
template <class T> class SingleList;
template <class T>
class Node{
private:
    T element;
    Node<T> *link;
    friend class SingleList<T>;
};
template <class T>
class SingleList:public LinearList<T>
{
public:
    SingleList(){
        first = NULL;
        n = 0;
    }
    ~SingleList();
    bool IsEmpty() const;
    int Length() const;
    bool Find(int i, T& x) const;
    int Search(T x) const;
    bool Insert(int i, T x);
    bool Delete(int i);
    bool Update(int i, T x);
//    void Clear();
    void Output(ostream& out) const;

private:
    Node<T> *first;
};
template <class T>
SingleList<T>::~SingleList() {
    Node<T> *p;
    while(first){
        p = first->link;
        delete first;
        first = p;
    }
}
template <class T>
int SingleList<T>::Length() const {
    return LinearList<T>::n;
}
template <class T>
bool SingleList<T>::IsEmpty() const {
    return n == 0;
}
template <class T>
bool SingleList<T>::Find(int i, T &x) const {
    if(i < 0 || i > n-1){
        cout << "Out of Bounds";
        return false;
    }
    Node<T> *p = first;
    for(int j = 0; j < i; j++)
        p = p->link;
    x = p->element;
    return true;
}
template <class T>
int SingleList<T>::Search(T x) const {
    Node<T> *p = first;
    for(int j = 0; p; j++){
        p = p->link;
        if(p->element == x)
            return j;
    }
    return -1;
}
template <class T>
bool SingleList<T>::Insert(int i, T x) {
    if(i < -1 || i > n -1){
        cout << "Out Of Bounds";
        return false;
    }
    Node<T> *q = new Node<T>;
    q->element = x;
    Node<T> *p = first;
    for(int j = 0; j < i; j++)
        p = p->link;
    if(i > -1) {
        q->link = p->link;
        p->link = q;
    } else{
        q->link = first;
        first = q;
    }
    n++;
    return true;
}
template <class T>
bool SingleList<T>::Delete(int i) {
    if(!n){
        cout << "UnderFlow" << endl;
        return false;
    }
    if( i < 0 || i > n-1){
        cout << "Out of Bounds" << endl;
        return false;
    }
    Node<T> *p = first, *q = first;
    for(int j = 0; j < i -1; j++)
        q = q->link;
    if( i == 0)
        first = first->link;
    else {
        p = q->link;
        q->link = p->link;
    }
    delete p;
    n--;
    return true;
}
template <class T>
bool SingleList<T>::Update(int i, T x) {
    if( i < 0 || i > n-1){
        cout << "Out Of Bounds" << endl;
        return false;
    }
    Node<T> *p = first;
    for(int j = 0; j < i; j++)
        p = p->link;
    p->element = x;
    return true;
}
template <class T>
void SingleList<T>::Output(ostream &out) const {
    Node<T> *p = first;
    while(p) {
        out << p->element << " ";
        p = p->link;
    }
    out << endl;
}
#endif //LIST_SINGLELIST_H
