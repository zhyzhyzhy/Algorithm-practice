//
// Created by zhy on 10/27/16.
//

#ifndef HFMTREE_HFMTREE_H
#define HFMTREE_HFMTREE_H

#include <stdlib.h>
#include "BinaryTree.h"
#include "prioqueue.h"

template <class T>
class HfmTree:public BinaryTree<T>
{
public:
    operator T()const {return weight;}                //重载类型转换运算符[ C++语言机制]
    T getW(){return weight;}
    void putW(const T& x){ weight=x;}
    void putC(const char& x) { BinaryTree<T>::root->represent = x;}
    void SetNull(){BinaryTree<T>::root=NULL;}
    void decode(int code[], int n);
    void encode();
private:
    void encode(BTNode<T> *root);
    T weight;
};
template <class T>
HfmTree<T> CreateHfmTree (char characs[], T w[],int n)
{
    PrioQueue <HfmTree<T>> pq(n);        //定义一个元素类型为HfmTree<T>的优先权队列
    HfmTree<T> x,y,z;
    for (int i=0;i<n;i++){
        z.MakeTree(w[i],x,y);
        z.putW(w[i]);                      //构造树中只有一个结点的哈夫曼树对象
        z.putC(characs[i]);
        pq.Append(z);                      //将哈夫曼树对象进优先权队列
        z.SetNull();                       //将z置成空树
    }
    for (int i=1;i<n;i++){
        pq.Serve(x);
        pq.Serve(y);                        //取出最小和次小权值哈夫曼树对象x和y
        z.MakeTree(x.getW()+y.getW(),x,y); //构造一个新哈夫曼树对象
        z.putW(x.getW()+y.getW());
        pq.Append(z);                      //新哈夫曼树对象进优先权队列
        z.SetNull();                       //将z置成空树
    }
    pq.Serve(z);                           //从队列中取出构造完毕的哈夫曼树对象
    return z;                              //返回构造完成的哈夫曼树对象
}
template <class T>
void HfmTree<T>::decode(int *code, int n) {
    BTNode<T> *p = BinaryTree<T>::root;
    for(int i = 0; i < n; i++) {
        if(code[i] == 0) {
            p = p->lChild;
            if(p->represent != '#') {
                cout << p->represent << " ";
                p = BinaryTree<T>::root;
            }
        }
        if(code[i] == 1) {
            p = p->rChild;
            if(p->represent != '#') {
                cout << p->represent << " ";
                p = BinaryTree<T>::root;
            }
        }
    }
}
template <class T>
void HfmTree<T>::encode() {
    int i = 0;
    BTNode<T> *p = BinaryTree<T>::root;
    int temp[100];
    int TotalofTemp = 0;
    while(i < BinaryTree<T>::SizeOfOne()) {
        int random = rand()%2;
        if(random == 0 && p->represent == '#') {
            temp[TotalofTemp++] = 0;
            p = p->lChild;
        }
        if(random == 1 && p->represent == '#') {
            temp[TotalofTemp++] = 1;
            p = p->rChild;
        }
        if(p->represent != '#') {
            if(p->hasEncode == 1) {
                p = BinaryTree<T>::root;
                TotalofTemp = 0;
                continue;
            }
            for(int i = 0; i < TotalofTemp; i++)
                cout << temp[i] << " ";
            cout << p->represent << endl;
            p->hasEncode = 1;
            i++;
            TotalofTemp = 0;
            p = BinaryTree<T>::root;
        }
    }
}
template <class T>
void HfmTree<T>::encode(BTNode<T> *root) {
}
#endif //HFMTREE_HFMTREE_H
