#include <iostream>
#include <stdio.h>
#include <stack>

using namespace std;

bool judge(string temp);
int main() {
    int count;
    scanf("%d", &count);
    bool result[count];

    for(int i = 0; i < count; i++) {
        string temp;
        cin >> temp;
        result[i] = judge(temp);
    }
    for(int i = 0; i < count; i++) {
        if(result[i] == true)
            printf("Yes\n");
        else
            printf("No\n");
    }
    return 0;
}
bool judge(string temp) {
    stack<char> a;
    char b;
    for(int i = 0; i < temp.size(); i++) {
        b = temp[i];
        if(b == '(' || b == '[')
            a.push(b);
        if(b == ')') {
            if(a.empty())
                return false;
            while( !a.empty() && a.top() != '(' )
                a.pop();
            if(a.empty())
                return false;
            if(a.top() == '(')
                a.pop();
        }
        if(b == ']') {
            if(a.empty())
                return false;
            while( !a.empty() && a.top() != '[' )
                a.pop();
            if(a.empty())
                return false;
            if(a.top() == '[')
                a.pop();
        }
    }
    return true;
}
