#include <iostream>
#include "seqlist.h"
#include "homework.h"
#include "singlelist.h"
#include "term.h"
#include "poly.h"
using namespace std;
int main() {
    Polynominal *demo1 = new Polynominal();
    Polynominal *demo2 = new Polynominal();
   demo1->AddTerms(cin);
    demo2->AddTerms(cin);
    demo1->PolyMult(*demo2);
    cout << *demo1 << endl;

    return 0;
}