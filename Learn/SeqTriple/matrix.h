#ifndef SEQTRIPLE_H_
#define SEQTRIPLE_H_

#include <iostream>
using namespace std;
template <class T>
struct Terms
{
    int row,col;
    T value;
};

template <class T>
class SeqTriple
{
public:
    SeqTriple(int  mSize);
    ~SeqTriple(){ delete [] trip; };
    void Create(int m, int n, int t);
    void Add(const SeqTriple<T> &B, SeqTriple<T> &C) const;
    void Mul(const SeqTriple<T> &B, SeqTriple<T> &C) const;
//    void Transpose(SeqTriple<T> &B)const;
//    friend istream &operator >>(istream &input, const SeqTriple<T> &);
//    friend std::ostream &operator <<(ostream &output, const SeqTriple<T> &);
    void print();
private:
    int maxSize;                               //最大元素个数
    int m,n,t;                                 //稀疏矩阵的行数、列数和非零元素个数
    Terms<T> *trip;                             //动态一维数组的指针
};
template <class T>
SeqTriple<T>::SeqTriple(int  mSize) {
    maxSize = mSize;
}
template <class T>
void SeqTriple<T>::Create(int mm, int nn, int tt) {
    m = mm;
    n = nn;
    t = tt;
    trip = new Terms<T>[t];

    for(int i = 0; i < t; i++) {
        cout << "行，列，值" << endl;
        cin >> trip[i].row >> trip[i].col >> trip[i].value;
    }
}
4.16
template <class T>
void SeqTriple<T>::Add(const SeqTriple<T> &B, SeqTriple<T> &C) const {
    T temp[B.m][B.n];
    for(int i = 0; i < B.m; i++)
        for (int j = 0; j < B.n; j++) {
            temp[i][j] = 0;
        }
    for(int i = 0; i < B.t; i++){
        temp[B.trip[i].row][B.trip[i].col] = B.trip[i].value;
    }
    for(int i = 0; i < C.t; i++) {
        temp[C.trip[i].row][C.trip[i].col] = C.trip[i].value;
    }
    Terms<T> tp[B.t+C.t];
    int count = 0;

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
    C.trip = new Terms<T>[count+1];
    for(int i = 0; i < count; i++){
        C.trip[i].row = tp[i].row;
        C.trip[i].col = tp[i].col;
        C.trip[i].value = tp[i].value;
    }
}
template <class T>
void SeqTriple<T>::Add(const SeqTriple<T> &B, SeqTriple<T> &C) const {
    Terms<T> *temp = new Terms<T>[B.t + C.t];
    int pB = 0;
    int pC = 0;
    int pTemp = 0;
    while (pB < B.t || pC < C.t) {
        if (B.trip[pB].row == C.trip[pC].row) {
            if (B.trip[pB].col > C.trip[pC].col) {
                temp[pTemp].row = C.trip[pC].row;
                temp[pTemp].col = C.trip[pC].col;
                temp[pTemp].value = C.trip[pC].value;
                pTemp++;
                pC++;
                continue;
            }
            if (B.trip[pB].col < C.trip[pC].col) {
                temp[pTemp].row = B.trip[pB].row;
                temp[pTemp].col = B.trip[pB].col;
                temp[pTemp].value = B.trip[pB].value;
                pTemp++;
                pB++;
                continue;
            }
            if (B.trip[pB].col == C.trip[pC].col) {
                temp[pTemp].row = B.trip[pB].row;
                temp[pTemp].col = B.trip[pB].col;
                int value = B.trip[pB].value + C.trip[pC].value;
                if(value != 0) {
                    temp[pTemp].value = value;
                    pTemp++;
                }
                pB++;
                pC++;
                continue;
            }
        }
        if (B.trip[pB].row > C.trip[pC].row) {
            temp[pTemp].row = C.trip[pC].row;
            temp[pTemp].col = C.trip[pC].col;
            temp[pTemp].value = C.trip[pC].value;
            pTemp++;
            pC++;
            continue;
        }
        if (B.trip[pB].row < C.trip[pC].row) {
            temp[pTemp].row = B.trip[pB].row;
            temp[pTemp].col = B.trip[pB].col;
            temp[pTemp].value = B.trip[pB].value;
            pTemp++;
            pB++;
            continue;
        }
    }
    while(pB < B.t) {
        temp[pTemp].row = B.trip[pC].row;
        temp[pTemp].col = B.trip[pC].col;
        temp[pTemp].value = B.trip[pC].value;
        pTemp++;
        pB++;
    }
    while(pC < C.t) {
        temp[pTemp].row = C.trip[pC].row;
        temp[pTemp].col = C.trip[pC].col;
        temp[pTemp].value = C.trip[pC].value;
        pTemp++;
        pC++;
    }
    delete [] C.trip;
    C.trip = new Terms<T>[pTemp];
    for(int i = 0; i < pTemp; i++) {
        C.trip[i].row = temp[i].row;
        C.trip[i].col = temp[i].col;
        C.trip[i].value = temp[i].value;
    }

}
template <class T>
void SeqTriple<T>::Mul(const SeqTriple<T> &B, SeqTriple<T> &C) const {
    int pB = 0;
    int pC = 0;
    int pTemp = 0;
    Terms<T> *temp = new Terms<T>[B.t+C.t];
    for(int i = 0; i < B.t + C.t; i++)
        temp[i].value = 0;
    for(pB = 0; pB < B.t; pB++) {
        for(pC = 0; pC < C.t; pC++){
            if(B.trip[pB].col == C.trip[pC].row) {
                int i;
                for(i = 0; i < pTemp; i++) {
                    if(temp[i].row == B.trip[pB].row && temp[i].col == C.trip[pC].col) {
                        temp[pTemp].value += B.trip[pB].value + C.trip[pC].value;
                    }
                }
                if(i == pTemp) {
                    temp[pTemp].row = B.trip[pB].row;
                    temp[pTemp].col = C.trip[pC].col;
                    temp[pTemp].value += B.trip[pB].value * C.trip[pC].value;
                    pTemp++;
                }
            }
        }
    }
    delete [] C.trip;
    C.trip = new Terms<T>[pTemp];
    for(int i = 0; i < pTemp; i++){
        C.trip[i].row = temp[i].row;
        C.trip[i].col = temp[i].col;
        C.trip[i].value = temp[i].value;
    }
}
//template <class T>
//std::ostream& operator <<(ostream &output, const SeqTriple<T> &demo) {
//    int count = 0;
//    for(int i = 0; i < demo.m; i++){
//        for (int j = 0; j < demo.n; j++) {
//            if(demo.trip[count].row == i && demo.trip[count].col == j) {
//                output << demo.trip[count].value << " ";
//                count++;
//                continue;
//            }
//            output << "0 ";
//        }
//        cout << endl;
//    }
//    return output;
//}
template <class T>
void SeqTriple<T>::print() {
    int count = 0;
    for(int i = 0; i < m; i++){
        for (int j = 0; j < n; j++) {
            if(trip[count].row == i && trip[count].col == j) {
                cout << trip[count].value << " ";
                count++;
                continue;
            }
            cout << "0 ";
        }
        cout << endl;
    }
}
#endif