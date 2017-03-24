#include <iostream>

using namespace std;
//6-5
struct Node {
    int a;
    Node *next;
};
bool Search(int str[], int n, int index, int number) {
    if(index < n) {
        if (str[index] == number)
            return true;
        else
            return Search(str, n, index+1, number);
    }
    else
        return false;
}
bool Search(Node *head,int number) {
    Node *demo = head;
    while( !demo) {
        if(demo->a == number)
            return true;
        demo = demo->next;
    }
}
int main() {
    int a[] = {1,2,3,4,5,6,7};
    if(Search(a,7,0,8))
        cout << "yes" << endl;
    return 0;
}