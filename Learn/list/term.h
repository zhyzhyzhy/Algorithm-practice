//
// Created by zhy on 9/18/16.
//

#ifndef LIST_TERM_H
#define LIST_TERM_H

#include <iostream>
using namespace std;
class Term
{
public:
    Term(int c, int e);
    Term(int c, int e, Term *nxt);
    Term* InsertAfter(int c, int e);

private:
    int coef;
    int exp;
    Term *link;
    friend ostream &operator<<(ostream &, const Term &);
    friend class Polynominal;
};
Term::Term(int c,int e):coef(c),exp(e)
{
    link=0;
}
Term::Term(int c,int e,Term *nxt):coef(c),exp(e)
{
    link=nxt;
}
Term* Term::InsertAfter(int c,int e)
{	                                     //为新项申请结点的存储单元，并用Term函数将
    link=new Term(c,e,link);              //c,e和this->link的值填入新结点的相应域
    return link;
}
ostream &operator <<(ostream & out, const Term& val)
{ //重载“<<”，输出多项式的一项，用coef X^exp表示coef Xexp
    if(val.coef==0) return out;
    out<<val.coef;
    switch(val.exp){
        case 0:break;
        case 1:out<<"X"; break;
        default:out<<"X^"<<val.exp; break;
    }
    return out;
}

#endif //LIST_TERM_H
