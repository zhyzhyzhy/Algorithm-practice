#ifndef SEQLIST_H
#define SEQLIST_H
#include "linearlist.h"
#include "seqlist.h"
#include <iostream>
#include <stdlib.h>
#include <malloc.h>

using namespace std;

template <class T>
class SeqList:public LinearList<T>
{
public:
    SeqList(int mSize);
    ~SeqList(){ delete [] elements; }
    bool IsEmpty() const;
    int Length() const;
    bool Find(int i, T& x) const;
    int Search(T x) const;
    bool Insert(int i, T x);
    bool Delete(int i);
    bool Update(int i, T x);
    void Output(ostream& out) const;
    void Reverse();
    void DeleteSameElements(T x);
private:
    int maxLength;
    T *elements;
};

template <class T>
SeqList<T>::SeqList(int mSize){
    maxLength = mSize;
    elements = new T[maxLength];
    LinearList<T>::n = 0;
}
template <class T>
bool SeqList<T>::IsEmpty() const{
    return LinearList<T>::n == 0;
}
template <class T>
int SeqList<T>::Length() const {
    return LinearList<T>::n;
}
template <class T>
bool SeqList<T>::Find(int i, T &x) const{
    if( i < 0 || i > LinearList<T>::n-1){
        cout << "Out of Bounds" << endl;
        return false;
    }
    x = elements[i];
    return true;
}
template <class T>
int SeqList<T>::Search(T x) const{
    for(int j = 0; j < LinearList<T>::n; j++){
        if(elements[j] == x)
            return j;
    }
    return -1;
}
template <class T>
bool SeqList<T>::Insert(int i, T x){
    if(i < -1 || i > LinearList<T>::n-1){
        cout << "Out of Bounds" << endl;
        return false;
    }
    //2-3
    if( LinearList<T>::n == maxLength) {
        T *newbuf = new T(LinearList<T>::n*2);
        for(int j = 0; j < LinearList<T>::n; j++)
            newbuf[j] = elements[j];
        delete[](elements);
        elements = newbuf;
        maxLength = maxLength*2;
    }
    for(int j = LinearList<T>::n-1; j > i; j--)
        elements[j+1] = elements[j];
    elements[i+1] = x;
    LinearList<T>::n++;
    return true;
}
template <class T>
bool SeqList<T>::Delete(int i){
    if(!LinearList<T>::n){
        cout << "UnderFlow" << endl;
        return false;
    }
    if(i < 0 || i > LinearList<T>::n-1){
        cout << "Out of Bounds" << endl;
        return false;
    }
    for(int j=i+1; j < LinearList<T>::n; j++)
        elements[j-1] = elements[j];
    LinearList<T>::n--;
    return true;
}
template <class T>
bool SeqList<T>::Update(int i, T x){
    if(i < 0 || i > LinearList<T>::n-1){
        cout << "Out of Bounds" << endl;
        return false;
    }
    elements[i] = x;
    return true;
}
template <class T>
void SeqList<T>::Output(ostream &out) const{
    for(int i = 0; i < LinearList<T>::n; i++){
        out <<  elements[i] << ' ';
        out << endl;
    }
}
//2-2
//template <class T>
//void SeqList<T>::Reverse() {
//    T x;
//    for(int i = 0; i < Length(); i++){
//        x = elements[Length()-1];
//        Delete(Length()-1);
//        Insert(i - 1,x);
//    }
//}
template <class T>
void SeqList<T>::Reverse() {
    int i = 0, j = LinearList<T>::n - 1;
    while(i < j)
        swap(elements[i++], elements[j--]);
}
//2-4
template <class T>
void SeqList<T>::DeleteSameElements(T x){
    for(int i = 0; i < Length(); i++){
        if(elements[i] == x){
            Delete(i);
            i--;
        }
    }
}

#endif // SEQLIST_H