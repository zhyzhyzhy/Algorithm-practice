//
// Created by zhy on 11/24/16.
//

#ifndef GRAPH_GRAPH_H
#define GRAPH_GRAPH_H

template<class T>
class Graph
{
public:
    virtual int Insert(int u,int v, T w)=0;
    virtual int Remove(int u,int v)=0;
    virtual bool Exist(int u,int v)const=0;
    virtual int Vertices()const {return n;}
protected:
    int n,e;
};


#endif //GRAPH_GRAPH_H
