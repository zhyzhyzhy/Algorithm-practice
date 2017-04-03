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

    cout << list->select(2) <<  endl;

   //list->InsertSort(0, 6);
    list->Output();
    list->QuickSort();
    list->Output();
    return 0;
}
