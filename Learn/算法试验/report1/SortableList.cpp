#include "SortableList.h"
#include <cstdio>
#include <iostream>
using namespace std;
void SortableList::Input() {
    int x;
    while (scanf("%d", &x) != EOF) {
        l[n++] = x;
    }
}

void SortableList::Output() {
    for (int i = 0; i < n; i++) {
        cout << l[i] << " ";
    }
    cout << endl;
}
void SortableList::MergeSort() {
    MergeSort(0, n - 1);
}
void SortableList::MergeSort(int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        MergeSort(left, mid);
        MergeSort(mid + 1, right);
        Merge(left, mid, right);
    }
}

void SortableList::Merge(int left, int mid, int right) {
    int temp[right - left + 1];
    int n = 0;
    int i = left;
    int j = mid + 1;
    while (n < right - left + 1) {
        if (i > mid) {
            while(j <= right) {
                temp[n++] = l[j++];
            }
        }
        else if ( j > right) {
            while(i <= mid) {
                temp[n++] = l[i++];
            }
        }
        else if (l[i] <= l[j]) {
            temp[n++] = l[i++];
        }
        else {
            temp[n++] = l[j++];
        }
    }
    for(int k = 0; k < n; k++) {
        l[left++] = temp[k];
    }
}
void SortableList::QuickSort() {
    QuickSort(0, n - 1);
}
void SortableList::QuickSort(int left, int right) {
    int i,j;
    if (left<right){
        i=left; j=right+1;
        do{
            do i++;while (l[i]<l[left]);
            do j--; while (l[j]>l[left]);
            if (i<j) swap(i,j);
        }while (i<j);
            swap(left,j);
            QuickSort(left,j-1);
            QuickSort(j+1,right);
    }
}
