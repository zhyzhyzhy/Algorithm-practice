#include <iostream>
#include <math.h>
#include "stack.h"
#include "extra.h"
using namespace std;

//合取是^
//析取是V
//非是!
int main() {
    int n;
    cout << "input number:";
    cin >> n;

    char **demo = new char *[n];
    for (int i = 0; i < n; i++)
        demo[i] = new char[2];
    cout << "输入命题公式的名字：";
    for (int i = 0; i < n; i++) {
        cin >> demo[i][0];
    }


    //输入中缀表达式
    cout << "输入表达式，以#结尾：";
    char temp = ' ';
    char MiddleExpression[100];
    int i = 0;
    while (temp != '#') {
        cin >> temp;
        MiddleExpression[i++] = temp;
    }

    //把中缀表达式转换为后缀表达式，存在tempFixExpression
    Stack<char> *tempStack = new Stack<char>(100);
    char tempFixExpression[100];
    i = 0;
    int j = 0;
    while (MiddleExpression[i] != '#') {
        //如果是命题公式，直接输出
        for (int k = 0; k < n; k++) {
            if (MiddleExpression[i] == demo[k][0])
                tempFixExpression[j++] = MiddleExpression[i];
        }
        //如果是运算符
        if (isWord(MiddleExpression[i]) >= 0) {
            //如果栈为空
            if (tempStack->IsEmpty()) {
                tempStack->Push(MiddleExpression[i]);
            }
                //如果栈不是空
            else {
                char temp;
                tempStack->Top(temp);
                if (isWord(temp) <= isWord(MiddleExpression[i]))
                    tempStack->Push(MiddleExpression[i]);
                else {
                    while (isWord(temp) > isWord(MiddleExpression[i])) {
                        tempFixExpression[j++] = temp;
                        tempStack->Pop();
                        if (tempStack->Top(temp))
                            continue;
                        else
                            break;
                    }
                }

            }
        }
        //如果是左括号
        if (MiddleExpression[i] == '(')
            tempStack->Push(MiddleExpression[i]);
        //如果是右括号
        if (MiddleExpression[i] == ')') {
            char temp;
            tempStack->Top(temp);
            while (temp != '(') {
                tempFixExpression[j++] = temp;
                tempStack->Pop();
                tempStack->Top(temp);
            }
            tempStack->Pop();
        }
        i++;
    }
    while (!tempStack->IsEmpty()) {
        tempStack->Top(temp);
        tempFixExpression[j++] = temp;
        tempStack->Pop();
    }
    tempFixExpression[j] = '#';

    cout << "主析取范式：\n";
    getResult1(0, demo, n, tempFixExpression);
    cout << "\b";
    cout << " ";
    cout << endl;
    cout << "主和取范式：\n";
    getResult2(0, demo, n, tempFixExpression);
    printf("\b");
    printf(" ");
    cout << endl;

    for(int i = 0; i < n; i++)
        delete [] demo[i];
    delete[] demo;
    delete tempStack;
    return 0;
}
