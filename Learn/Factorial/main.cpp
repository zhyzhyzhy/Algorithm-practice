#include <iostream>

using namespace std;

int Factorial(int n);

template<class T>
void Perm(T list[], int k, int m);

template <class T>
inline void Swap(T& a, T& b);
int main()
{
    char a[] = {'a','c','d'};
    Perm(a,0,2);
    return 0;
}
int Factorial(int n){
    if(n == 0)
        return 1;
    return n*Factorial(n-1);
}

template<class T>
void Perm(T list[], int k, int m)
{ //生成list [k： m ]的所有排列方式
                        int i;
        if (k == m) {//输出一个排列方式
                for (i = 0; i <= m; i++)
                        cout << list[i];
                cout << endl;
        }
        else // list[k： m ]有多个排列方式
                // 递归地产生这些排列方式
                for (i=k; i <= m; i++) {
                        Swap (list[k], list[i]);
                        Perm (list, k+1, m);
                        Swap (list[k], list[i]);
                }
}

template <class T>
inline void Swap(T& a, T& b)
{// 交换a和b
T temp = a; a = b; b = temp;
}
