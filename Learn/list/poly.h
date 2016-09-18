//
// Created by zhy on 9/18/16.
//

#ifndef LIST_POLY_H
#define LIST_POLY_H

#include "term.h"
#include <iostream>
class Polynominal
{
public:
    Polynominal();
    ~ Polynominal();
    void AddTerms(istream& in);                        //输入多项式的各项，构造多项式链表
    void AddTerms(int coef, int exp);         //按降幂输入各项，构造单循环链表
    void Output(ostream& out)const;                //将多项式送输出流
    void PolyAdd(Polynominal& r);                      //多项式相加
    void PolyMult(Polynominal& r);
private:
    Term* theList;                                    //单循环链表的表头指针
    friend ostream & operator << (ostream &, const Polynominal &);
    friend istream& operator >>(istream&, Polynominal &);
    friend Polynominal& operator +(Polynominal &, Polynominal &);
    friend Polynominal& operator *(Polynominal &, Polynominal &);
};

Polynominal::Polynominal()                           //创建多项式的空的单循环链表
{
    theList=new Term(0,-1);	                     //分配表头结点的存储单元
    theList->link=theList;                           //构成循环链表
}
Polynominal::~Polynominal()                           //撤消多项式的单循环链表
{
    Term* p=theList->link;
    while(p!=theList){
        theList->link=p->link;                        //删除p结点
        delete p;                                     //释放p之存储空间
        p=theList->link;                              //p指向下1个待删除结点
    }
    delete theList;                                    //释放表头结点的存储单元
}
void Polynominal:: AddTerms(istream & in)         //按降幂输入各项，构造单循环链表
{
    Term* q=theList;
    int c,e;
    for(;;){
        cout<<"Input a term(coef,exp):\n"<<endl;
        cin>>c>>e;
        if (e<0) break;                          //当输入的指数小于0时，构造过程结束
        q=q->InsertAfter(c,e);                   //将c,e插入表尾结点q之后
    }
}
void Polynominal:: AddTerms(int coef, int exp)         //按降幂输入各项，构造单循环链表
{
    Term* q=theList;
    Term* p=q->link;
    while(p->exp>=0){
        q = p;
        p = p->link;
    }
    q->InsertAfter(coef,exp);                   //将c,e插入表尾结点q之后
}
void Polynominal::Output(ostream& out)const
{
    int first=1;  Term *p=theList->link;
    cout<<"The polynominal is:\n"<<endl;
    for ( ; p!=theList ; p=p->link){
        if (!first && (p->coef>0)) out<<"+";      //在非第一项的正系数前输出  号
        first=0;
        out<<*p;                                  //调用Term类上重载的"<<"操作
    }
    cout<<"\n"<<endl;
}
void Polynominal::PolyAdd(Polynominal& r)
{//将多项式r加到多项式this上
    Term* q,*q1=theList,*p;                 //q1指向表头结点
    p=r.theList->link;                       //p指向第一个要处理的结点
    q=q1->link;                           //q1是q的前驱，p和q就指向两个当前进行比较的项
    while (p->exp>=0){                       //对r的单循环链表遍历,直到全部结点都处理完
        while (p->exp<q->exp){                //跳过q->exp大的项
            q1=q;  q=q->link;
        }
        if (p->exp==q->exp) {                    //当指数相等时，系数相加
            q->coef=q->coef+p->coef;
            p = p->link;
            if (q->coef==0){                   //若相加后系数为0，则删除q
                q1->link=q->link; delete(q);
                q=q1->link;                    //重置q指针
            }
            else {
                q1=q; q=q->link;             //若相加后系数不为0，则移动q1和q
            }
        }
        else{                                   //p->exp>q->exp的情况
            q1=q1->InsertAfter(p->coef,p->exp);   //以p的系数和指数生成新结点，插入q1
            p=p->link;
        }
    }
}
void Polynominal::PolyMult(Polynominal& r){
    Term* q,*q1=theList,*p;                 //q1指向表头结点
    p=r.theList->link;                       //p指向第一个要处理的结点
    q=q1->link;                           //q1是q的前驱，p和q就指向两个当前进行比较的项
    q1=q->link;
    int a,b;
    Polynominal *new1 = new Polynominal();
    while (p->exp>=0){                       //对r的单循环链表遍历,直到全部结点都处理完
        Polynominal *new2 = new Polynominal();
        while(q->exp>=0){
            a = (p->coef)*(q->coef);
            b = (p->exp)+(q->exp);
            new2->AddTerms(a, b);
            q = q1;
            q1 = q->link;
        }
        new1->PolyAdd(*new2);
        cout << *new1 << "ccd" << endl;
        p = p->link;
        q1 = theList;
        q = q1->link;
        q1 = q->link;
    }
    q1 = theList;
    q = q1->link;
    q1 = q->link;
    Term *newp1 = new1->theList->link;
    bool hasdone = false;
    while(newp1->exp>=0) {
        if(hasdone == false)
            while(q->exp>=0 && newp1->exp>=0 ) {
                q->exp= newp1->exp;
                q->coef = newp1->coef;
                newp1 = newp1->link;
                q = q->link;
                cout << *this << "cd" << endl;
            }
        hasdone = true;
        if(newp1->exp>=0) {
            this->AddTerms(newp1->coef, newp1->exp);
            q = q->link;
            newp1 = newp1->link;
            cout << *this << "cdd" << endl;
        }
    }
}
ostream& operator <<(ostream &out,const Polynominal &x)
{
    x.Output(out); return out;
}

istream& operator >>(istream& in, Polynominal &x)
{
    x.AddTerms(in);  return in;
}

Polynominal& operator +(Polynominal &a, Polynominal &b)
{
    a.PolyAdd(b); return a;
}
Polynominal& operator *(Polynominal &a, Polynominal &b)
{
    a.PolyMult(b); return a;
}

#endif //LIST_POLY_H
