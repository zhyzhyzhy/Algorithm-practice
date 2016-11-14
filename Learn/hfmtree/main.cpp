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
    cout << "前序遍历:"<<endl;
    demo.PreOrder(Visit);
    putchar('\n');
    cout << "哈夫曼编码:" <<endl;
    demo.encode();
    int code[6] = {1,0,1,1,1,0};
    cout << "哈夫曼解码:" << endl;
    demo.decode(code, 6);
    demo.Clear();
    return 0;
}