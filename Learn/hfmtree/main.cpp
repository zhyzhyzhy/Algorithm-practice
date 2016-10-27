#include <iostream>
#include "HfmTree.h"
#include "prioqueue.h"
#include "BTNode.h"
#include "BinaryTree.h"
using namespace std;
template <class T>
void Visit(T& x)
{
    cout<<x<<"  ";
}
int main()
{
    char test[4] = {'a', 'b', 'c', 'd'};
    int test2[4] = {1,2,3,4};
    HfmTree<int> demo = CreateHfmTree(test, test2, 4);
    demo.PreOrder(Visit);
    putchar('\n');
    int code[6] = {0,0,0,0,0,0};
    demo.decode(code, 6);
    demo.Clear();
    return 0;
}