//
// Created by zhy on 10/11/16.
//
//
// Created by zhy on 10/11/16.
//

#ifndef BTREE_BTNODE_H
#define BTREE_BTNODE_H

#include <stdio.h>
template<class T>
struct BTNode
{
    BTNode(){ lChild=rChild=NULL;}
    BTNode(const T& x)
    {
        element=x; lChild=rChild=NULL;
    }
    BTNode(const T& x, BTNode<T>* l,BTNode<T>* r)
    {
        element=x; lChild=l; rChild=r;
    }
    T element;
    char represent = '#';
    BTNode<T>* lChild, *rChild;
};

#endif //BTREE_BTNODE_H

