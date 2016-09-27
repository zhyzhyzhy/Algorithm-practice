#include <iostream>
#include "matrix.h"
using namespace std;
int main() {
    SeqTriple<int> *demo1 = new SeqTriple<int>(10);
    SeqTriple<int> *demo2 = new SeqTriple<int>(10);
    demo1->Create(3,3,2);
    demo2->Create(3,3,3);
    demo1->print();
    demo2->print();
    demo1->Add(*demo1, *demo2);
    demo2->print();
    demo1->Mul(*demo1, *demo2);
    demo2->print();
    return 0;
}