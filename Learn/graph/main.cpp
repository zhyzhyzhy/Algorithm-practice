#include "Graph.h"
#include "Lgraph.h"
#include "ExtLGraph.h"
#include "ExtLGraph.h"
#include "MGraph.h"
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
    ExtLGraph<int> *p = new ExtLGraph<int>(6);
    int w = 1;
    p->Insert(1,0,w);
    p->Insert(1,3,w);
    p->Insert(2,1,w);
    p->Insert(2,4,w);
    p->Insert(3,2,w);
    p->Insert(3,4,w);
    p->Insert(4,0,w);
    p->Insert(4,1,w);
    p->Insert(4,5,w);
    p->Insert(5,0,w);
    p->DFS();
    putchar('\n');
    MGraph<int> *q = new MGraph<int>(6,0);
    q->Insert(1,0,w);
    q->Insert(1,3,w);
    q->Insert(2,1,w);
    q->Insert(2,4,w);
    q->Insert(3,2,w);
    q->Insert(3,4,w);
    q->Insert(4,0,w);
    q->Insert(4,1,w);
    q->Insert(4,5,w);
    q->Insert(5,0,w);
    q->DFS();
    putchar('\n');
    q->BFS();
    return 0;
}
