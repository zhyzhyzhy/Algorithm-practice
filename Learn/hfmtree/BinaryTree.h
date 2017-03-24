//
// Created by zhy on 10/11/16.
//

#ifndef BTREE_BINARYTREE_H
#define BTREE_BINARYTREE_H

#include <stdio.h>
#include <iostream>
#include <cstring>
#include "BTNode.h"
using namespace std;
template<class T>
class BinaryTree
{
public:
    BinaryTree(){root=NULL;}
//    BinaryTree(const BinaryTree<T>& c);
//    ~BinaryTree(){Clear();}
//    bool IsEmpty()const;
    void Clear();
    bool Root(T &x)const;
    void MakeTree(const T &e ,BinaryTree<T>&left, BinaryTree<T>& right);
    void BreakTree(T &e ,BinaryTree<T>&left, BinaryTree<T>& right);
    void PreOrder(void (*Visit)(T& x));
    void InOrder(void (*Visit)(T& x));
    void PostOrder(void (*Visit)(T& x));
    int  SizeOfOne();
    void Exchange();
    int SizeOfNode();
public:
    BTNode<T>* root;
private:
//    void JustTry(BTNode<T> *a, BTNode<T> *b);
    int SizeofOne(BTNode<T> *t);
    int SizeOfNode(BTNode<T> *t);
    void Exchange(BTNode<T> *t);
    void Clear(BTNode<T>* t);
    void PreOrder(void (*Visit)(T& x),BTNode<T>*t);
    void InOrder(void (*Visit)(T& x),BTNode<T>*t);
    void PostOrder(void (*Visit)(T& x),BTNode<T>*t);
};
template <class T>
int BinaryTree<T>::SizeOfNode() {
    return SizeOfNode(root);
}
template <class T>
int BinaryTree<T>::SizeOfNode(BTNode<T> *t) {
    if(t) {
        return 1 + SizeOfNode(t->lChild) + SizeOfNode(t->rChild);
    }
    return 0;
}
template <class T>
bool BinaryTree<T>::Root(T &x)const
{
    if(root){
        x=root->element; return true;
    }
    else return false;
}
template <class T>
void BinaryTree<T>::MakeTree(const T &x ,BinaryTree<T>&left,BinaryTree<T>& right)
{
    if(root||&left==&right) return;
    root=new BTNode<T>(x,left.root, right.root);
    left.root=right.root=NULL;
}
template <class T>
void BinaryTree<T>::BreakTree(T &x, BinaryTree<T>&left, BinaryTree<T>& right)
{
    if (!root||&left==&right||left.root||right.root)return;
    x=root->element;
    left.root=root->lChild;right.root=root->rChild;
    delete root;
    root=NULL;
}
template <class T>
void BinaryTree<T>::Clear() {
    Clear(root);
}
template <class T>
void BinaryTree<T>::Clear(BTNode<T> *t) {
    if(t){
        Clear(t->lChild);
        Clear(t->rChild);
        delete t;
    }
}
template <class T>
void BinaryTree<T>::PreOrder(void (*Visit)(T& x))
{
    PreOrder(Visit,root);
}
template <class T>
void BinaryTree<T>::PreOrder(void (*Visit)(T& x),BTNode<T>* t)
{
    if (t){
        Visit(t->element);
        PreOrder(Visit,t->lChild);
        PreOrder(Visit,t->rChild);
    }
}
template <class T>
int BinaryTree<T>::SizeOfOne() {
    return SizeofOne(root);
}
template <class T>
int BinaryTree<T>::SizeofOne(BTNode<T> *t) {
    if(t)
    {
        if(!t->lChild && !t->rChild)
            return 1;
        else
            return SizeofOne(t->lChild) + SizeofOne(t->rChild);
    }
    return 0;
}
template <class T>
void BinaryTree<T>::Exchange() {
    Exchange(root);
}
template <class T>
void BinaryTree<T>::Exchange(BTNode<T> *t) {
    if(t->rChild || t->rChild) {
        Exchange(t->lChild);
        Exchange(t->rChild);
        BTNode<T> *temp = new BTNode<T>;
        temp = t->lChild;
        t->lChild = t->rChild;
        t->rChild = temp;
        delete temp;
    }
}
template <class T>
void BinaryTree<T>::InOrder(void (*Visit)(T& x)) {
    InOrder(Visit, root);
}
template <class T>
void BinaryTree<T>::InOrder(void (*Visit)(T& x),BTNode<T>*t) {
    if(t) {
        InOrder(Visit, t->lChild);
        Visit(t->element);
        InOrder(Visit, t->rChild);
    }
}
template <class T>
void BinaryTree<T>::PostOrder(void (*Visit)(T& x)) {
    PostOrder(Visit, root);
}
template <class T>
void BinaryTree<T>::PostOrder(void (*Visit)(T& x), BTNode<T> *t) {
    if(t) {
        PostOrder(Visit,t->lChild);
        PostOrder(Visit,t->rChild);
        Visit(t->element);
    }
}
//template <class T>
//BinaryTree<T>::BinaryTree(const BinaryTree<T> &b) {
//    BTNode<T> *p = b.root;
//    BTNode<T> *q = root;
//    while(p) {
//        q = new BTNode<T>(p->element);
//        if(p->lChild) {
//            JustTry(q->lChild,p->lChild);
//        }
//        if(p->rChild) {
//            q->rChild = new BTNode<T>(p->rChild);
//        }
//    }
//}
//template <class T>
//void BinaryTree<T>::JustTry(BTNode<T> *a, BTNode<T> *b) {
//    if(b) {
//        a = new BTNode<T>(b.element);
//    }
//}


#endif //BTREE_BINARYTREE_H
