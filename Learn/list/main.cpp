#include <iostream>
#include "seqlist.h"
#include "homework.h"
using namespace std;
int main() {

    SeqList<int> *demo1 = new SeqList<int>(3);
    SeqList<int> *demo2 = new SeqList<int>(3);
    demo1->Insert(-1,0);
    demo1->Insert(0,1);
    demo1->Insert(1,2);
    demo1->Reverse();
    demo1->DeleteSameElements(0);
    demo1->Output(cout);
    return 0;
}