//
// Created by zhy on 9/6/16.
//

#ifndef HOMEWORK_H
#define HOMEWORK_H
#include "seqlist.h"
//2-1
template <class T>
void Intersection(SeqList<T>& LA, SeqList<T> LB){
    T x, y;
    for(int i = 0; i < LA.Length(); i++){
        LA.Find(i, x);
        for(int j = 0; j < LB.Length(); j++){
            LB.Find(j, y);
            if(x == y)
                break;
            if(j == LB.Length() - 1){
                LA.Delete(i);
                i--;
            }
        }
    }
}

template <class T>
void Minus(SeqList<T>& LA, SeqList<T> LB){
    T x,y;
    for(int i = 0; i < LA.Length(); i++){
        LA.Find(i, x);
        for(int j = 0; j < LB.Length(); j++){
            LB.Find(j, y);
            if(x == y){
                LA.Delete(i);
                i--;
            }
        }
    }
}

#endif // HOMEWORK_H
