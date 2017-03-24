#include <iostream>
#include "relation.h"

using namespace std;
int main() {
    relation *demo = new relation();
    demo->initialize();
    demo->show();
    demo->judge();
    return 0;
}
