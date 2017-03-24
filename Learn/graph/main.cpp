#include "Graph.h"
#include "MGraph.h"
#include "ExtMGraph.h"
#include <iostream>
/**
 * ResultCode
 * 0 Success
 * 1 Failure
 * 2 NotPressent
 * 4 deduplicate
 */
using namespace std;
int main() {
//    ExtLGraph<int> *p = new ExtLGraph<int>(6);
//    int w = 1;
//    p->Insert(1,0,w);
//    p->Insert(1,3,w);
//    p->Insert(2,1,w);
//    p->Insert(2,4,w);
//    p->Insert(3,2,w);
//    p->Insert(3,4,w);
//    p->Insert(4,0,w);
//    p->Insert(4,1,w);
//    p->Insert(4,5,w);
//    p->Insert(5,0,w);
//    p->DFS();
//    putchar('\n');
//    MGraph<int> *q = new MGraph<int>(6,0);
//    q->Insert(1,0,w);
//    q->Insert(1,3,w);
//    q->Insert(2,1,w);
//    q->Insert(2,4,w);
//    q->Insert(3,2,w);
//    q->Insert(3,4,w);
//    q->Insert(4,0,w);
//    q->Insert(4,1,w);
//    q->Insert(4,5,w);
//    q->Insert(5,0,w);
//    q->DFS();
//    putchar('\n');
//    q->BFS();
    cout << "----------" << endl;
//    ExtMGraph<int> *q = new ExtMGraph<int>(6,100001);
//    q->Insert(0,1,50);
//    q->Insert(0,2,10);
//    q->Insert(0,4,70);
//    q->Insert(1,2,15);
//    q->Insert(1,4,10);
//    q->Insert(2,0,20);
//    q->Insert(2,3,15);
//    q->Insert(3,1,20);
//    q->Insert(3,4,35);
//    q->Insert(4,3,30);
//    q->Insert(5,3,3);
//    q->Plane(0,4);
    ExtMGraph<int> *q = new ExtMGraph<int>(6,100001);
    q->Insert(0,1,1);
    q->Insert(0,2,1);
    q->Insert(0,4,1);
    q->Insert(1,2,1);
    q->Insert(1,4,1);
    q->Insert(2,0,1);
    q->Insert(2,3,1);
    q->Insert(3,1,1);
    q->Insert(3,4,1);
    q->Insert(4,3,1);
    q->Insert(5,3,1);
    q->Plane(0,3);
    return 0;
}
