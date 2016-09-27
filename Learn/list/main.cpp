#include <iostream>
#include "seqlist.h"
#include "homework.h"
#include "singlelist.h"
#include "term.h"
#include "poly.h"
using namespace std;
int main() {
    double a=1,x;
    char c;
    do{
        scanf("%lf",&x);
        a*=x;
    } while(getchar(c)&&c==' ' );
    printf("%lf\n",a);
    return 0;
}