#include <iostream>
#include <stack>
#include <sstream>
using namespace std;
float stringToNum(const string& str)
{
    istringstream iss(str);
    float num;
    iss >> num;
    return num;
}
int getpriority(char a)
{
    switch(a)
    {
        case '+': return 2;
        case '-': return 2;
        case '*': return 3;
        case '\\': return 3;
    }
}
int main(int argc, char const *argv[]) {
    int total;
    scanf("%d", &total);
    float result[total];
    for (int i = 0; i < total; i++) {
        string in;
        std::cin >> in;

        stack<char> temp;
        stack<string> expression;
        for(int j = 0; j < (int)in.length(); i++ )
        {
            string oneNumber = "";
            while(in[j] != '+' && in[j] != '-' &&in[j] != '*'&&in[j] != '/'&&in[j] != '('&&in[j] != ')'&& j < (int)in.length())
            {
                oneNumber = oneNumber+in[j];
                j++;
            }
            if(oneNumber != ""){
                expression.push(oneNumber);
                if(j == (int)in.length())
                break;
            }
            else
                {
                    if(temp.empty())
                        temp.push(in[j]);
                    else
                        {
                            if(in[j] == ')') {
                                while(temp.top() != '('){
                                    expression.push((char)temp.top());
                                    temp.pop();
                                }
                            }
                            while(getpriority(in[j]) <= getpriority(temp.top())) {
                                expression.push(temp.top());
                                temp.pop();
                            }
                            if(getpriority(in[j]) > getpriority(temp.top())) {
                                temp.push(in[j]);
                            }
                        }
                    }

        }
    }
    return 0;
}
