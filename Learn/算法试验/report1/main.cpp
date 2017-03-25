#include <iostream>
#include <stdio.h>
#include "SortableList.h"

using namespace std;

int main()
{
    freopen("file.txt", "r", stdin);
    SortableList  *list = new SortableList(10);
    list->Input();
    list->Output();
    list->QuickSort();
    list->Output();
    return 0;
}
