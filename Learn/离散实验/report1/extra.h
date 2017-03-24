//
// Created by zhy on 9/14/16.
//

#ifndef REPORT1_EXTRA_H
#define REPORT1_EXTRA_H
//联接词的栈外优先级
int isWord(const char c)
{
    int result = -1;
    switch(c)
    {
        case '#': result = 0; break;
        case '!': result = 8; break;
        case '^': result = 7; break;
        case 'V': result = 5; break;
        case '>': result = 3; break;
    }
    return result;

}
void getResult1(int index, char **demo, int n, char *fixExpression) {
    if(index == n) {
        //计算能否得出结果
        Stack<char> *tempStack = new Stack<char>(30);
        int i = 0;
        char temp1 = fixExpression[i];
        char temp2;
        char temp3;
        int a, b;
        while(temp1 != '#') {
            if(isWord(temp1) == -1) {
                tempStack->Push(temp1);
            }
            if(temp1 == '!') {
                tempStack->Top(temp2);
                a = temp2;
                for(int j = 0; j < n; j++) {
                    if (temp2 == demo[j][0])
                        a = demo[j][1];
                }
                if(a == '0') {
                    tempStack->Pop();
                    tempStack->Push('1');
                }
                if(a == '1') {
                    tempStack->Pop();
                    tempStack->Push('0');
                }
            }
            if(isWord(temp1) >=0 && isWord(temp1) <= 7) {
                tempStack->Top(temp2);
                tempStack->Pop();
                tempStack->Top(temp3);
                tempStack->Pop();

                a = temp2;
                b = temp3;
                for(int j = 0; j < n; j++){
                    if(temp2 == demo[j][0])
                        a = demo[j][1];
                    if(temp3 == demo[j][0])
                        b = demo[j][1];
                }
                if(temp1 == '^') {
                    if(a == '0' || b == '0' )
                        tempStack->Push('0');
                    else
                        tempStack->Push('1');
                }
                if(temp1 == 'V') {
                    if(a == '1' || b == '1' )
                        tempStack->Push('1');
                    else
                        tempStack->Push('0');
                }
                if(temp1 == '>') {
                    if(a == '0' && b == '1' )
                        tempStack->Push('0');
                    else
                        tempStack->Push('1');
                }
            }
            i++;
            temp1 = fixExpression[i];
        }
        char temp;
        tempStack->Top(temp);
        if( temp == '0') {
            return;
        }
        else {
            cout << "(";
            for (int j = 0; j < n; j++) {
                if(demo[j][1] == '0' && j != n-1)
                    cout << "!" << demo[j][0] << "^";
                if(demo[j][1] == '1' && j != n-1)
                    cout << demo[j][0] << "^";
                if(demo[j][1] == '0' && j == n-1)
                    cout << "!" << demo[j][0];
                if(demo[j][1] == '1' && j == n-1)
                    cout << demo[j][0];
            }
            cout << ")V";
        }
    }
    else {
        demo[index][1] = '0';
        getResult1(index+1,demo,n,fixExpression);
        demo[index][1] = '1';
        getResult1(index+1,demo,n,fixExpression);
    }
}
void getResult2(int index, char **demo, int n, char *fixExpression) {
    if (index == n) {
        //计算能否得出结果
        Stack<char> *tempStack = new Stack<char>(30);
        int i = 0;
        char temp1 = fixExpression[i];
        char temp2;
        char temp3;
        int a, b;
        while (temp1 != '#') {
            if (isWord(temp1) == -1) {
                tempStack->Push(temp1);
            }
            if (temp1 == '!') {
                tempStack->Top(temp2);
                a = temp2;
                for (int j = 0; j < n; j++) {
                    if (temp2 == demo[j][0])
                        a = demo[j][1];
                }
                if (a == '0') {
                    tempStack->Pop();
                    tempStack->Push('1');
                }
                if (a == '1') {
                    tempStack->Pop();
                    tempStack->Push('0');
                }
            }
            if (isWord(temp1) >= 0 && isWord(temp1) <= 7) {
                tempStack->Top(temp2);
                tempStack->Pop();
                tempStack->Top(temp3);
                tempStack->Pop();

                a = temp2;
                b = temp3;
                for (int j = 0; j < n; j++) {
                    if (temp2 == demo[j][0])
                        a = demo[j][1];
                    if (temp3 == demo[j][0])
                        b = demo[j][1];
                }
                if (temp1 == '^') {
                    if (a == '0' || b == '0')
                        tempStack->Push('0');
                    else
                        tempStack->Push('1');
                }
                if (temp1 == 'V') {
                    if (a == '1' || b == '1')
                        tempStack->Push('1');
                    else
                        tempStack->Push('0');
                }
                if (temp1 == '>') {
                    if (a == '0' && b == '1')
                        tempStack->Push('0');
                    else
                        tempStack->Push('1');
                }
            }
            i++;
            temp1 = fixExpression[i];
        }
        char temp;
        tempStack->Top(temp);
        if (temp == '1') {
            return;
        } else {
            cout << "(";
            for (int j = 0; j < n; ++j) {
                if(demo[j][1] == '0' && j != n-1)
                    cout << "!" << demo[j][0] << "V";
                if(demo[j][1] == '1' && j != n-1)
                    cout << demo[j][0] << "V";
                if(demo[j][1] == '0' && j == n-1)
                    cout << "!" << demo[j][0];
                if(demo[j][1] == '1' && j == n-1)
                    cout << demo[j][0];
            }
            cout << ")^";
        }
    } else {
        demo[index][1] = '0';
        getResult2(index + 1, demo, n, fixExpression);
        demo[index][1] = '1';
        getResult2(index + 1, demo, n, fixExpression);
    }
}
#endif //REPORT1_EXTRA_H
