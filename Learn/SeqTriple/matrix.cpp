#include "matrix.h"
#include <iostream>
using namespace std;
template <class T>
SeqTriple<T>::SeqTriple(int  mSize) {
    maxSize = mSize;
}
template <class T>
void SeqTriple<T>::Create(int mm, int nn, int tt) {
    m = mm;
    t = nn;
    t = tt;
    trip = new Terms<T>[t];

    for(int i = 0; i < t; i++) {
        cout << "行，列，值" << endl;
        cin >> trip[i].row >> trip[i].col >> trip[i].value;
    }
}
template <class T>
void SeqTriple<T>::Add(const SeqTriple<T> &B, SeqTriple<T> &C) const {
    T temp[B.m][B.n];
    for(int i = 0; i < B.m; i++)
        for (int j = 0; j < B.n; j++) {
            temp[i][j] = 0;
        }
    for(int i = 0; i < B.t; i++){
        temp[B.trip[i].row][B.trip[i].col] = B.trip[i].value;
        i++;
    }
    for(int i = 0; i < C.t; i++) {
        temp[C.trip[i].row][C.trip[i].col] = C.trip[i].value;
        i++;
    }
    Terms<T> tp[B.t+C.t];
    int count = 1;

    for(int i = 0; i < B.m; i++)
        for (int j = 0; j < B.n; j++) {
            if(temp[i][j] != 0) {
                tp[count].row = i;
                tp[count].col = j;
                tp[count].value = temp[i][j];
                count++;
            }
        }
    delete [] C.trip;
    C.trip = new Terms<T>[count];
    for(int i = 0; i < count; i++){
        C.trip[i].row = tp[count].row;
        C.trip[i].col = tp[count].col;
        C.trip[i].value = tp[count].value;
    }

}
template <class T>
ostream &operator <<(ostream &output, const SeqTriple<T> &demo) {
    int count = 0;
    for(int i = 0; i < demo.m; i++){
        for (int j = 0; j < demo.n; j++) {
            if(demo.trip[count].row == i && demo.trip[count].col == j) {
                output << demo.trip[count].value << " ";
                count++;
                continue;
            }
            output << "0 ";
        }
        cout << endl;
    }
    return output;
}
