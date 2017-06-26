#include <iostream>
#include "LCS.h"
using namespace std;

int main() {

    LCS *lcs = new LCS(7,6,"abcbdab","bdcaba");
    cout << lcs->LCSLength() << endl;
    lcs->CLCS();

    return 0;
}