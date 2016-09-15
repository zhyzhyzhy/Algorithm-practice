//
// Created by zhy on 9/14/16.
//

#ifndef REPORT1_STACK_H
#define REPORT1_STACK_H

#include <iostream>
using namespace std;
template <class T>
class Stack
{
public:
    Stack(int mSize);
    ~Stack(){
        top = -1;
    }
    bool IsEmpty() const;
    bool IsFull() const;
    bool Top(T &x) const;
    bool Push(T x);
    bool Pop();
    void clear(){
        top = -1;
    };

private:
    int top;
    int maxTop;
    T *s;
};
template <class T>
Stack<T>::Stack(int mSize) {
    s = new T[mSize];
    top = -1;
    maxTop = mSize - 1;
}
template <class T>
bool Stack<T>::IsEmpty() const {
    return top == -1 ;
}
template <class T>
bool Stack<T>::IsFull() const {
    return top == maxTop;
}
template <class T>
bool Stack<T>::Top(T &x) const {
    if(IsEmpty())
        return false;
    x = s[top];
}
template <class T>
bool Stack<T>::Push(T x) {
    if(IsFull())
        return false;
    s[++top] = x;
}
template <class T>
bool Stack<T>::Pop() {
    if(IsEmpty())
        return false;
    top--;
}
#endif //REPORT1_STACK_H
