#include <iostream>
#include "seqlist.h"
#include "homework.h"
#include "singlelist.h"
using namespace std;
int main() {
    SingleList<int> *demo1 = new SingleList<int>();
    demo1->Insert(-1,0);
    demo1->Insert(0,1);
    demo1->Insert(1,2);
    demo1->Insert(2,3);
    demo1->Insert(3,1);
    demo1->Output(cout);
    demo1->DeleteElementsInRange(2,3);
    demo1->Output(cout);
    return 0;
}