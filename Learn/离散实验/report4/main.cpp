//欧拉图的判定和输出
/**
	File Name: main.cpp
	Author: zhy
	Created Time: 2016/12/14 - 09:48:06
*/
#include <iostream>
#include <queue>
#include <stack>
using namespace std;
int n;
int mgraph[100][100];
int visit[100][100];
bool flag = true;
stack<int> stv;
queue<int> quv;

void create();
void print();
void DFS();
void DFS(int v, bool *visited);
bool IsOla();
void printOla(int start);
int main(int argc, char *argv[])
{
    freopen("file.txt", "r", stdin);
    scanf("%d", &n);
    create();
    print();
    DFS();
    if(flag == false){
        printf("不是连通图\n");
        return 1;
    }
    if(IsOla() == false) {
        printf("不是欧拉图\n");
        return 2;
    }
    printOla(0);
    while(!quv.empty()) {
        printf("%d ", quv.front());
        quv.pop();
    }
    return 0;
}
void create() {
    int i, j;
    for(int i = 0; i < 100; i++)
        for(int j = 0; j < 100; j++)
            visit[i][j] = visit[j][i] = mgraph[i][j] = mgraph[j][i] = 0;
    while(scanf("%d,%d", &i, &j) != EOF) {
      visit[i][j] = visit[j][i] = mgraph[i][j] = mgraph[j][i] = 1;
    }
}
void print() {
    int i, j;
    for (i = 0; i < n; ++i) {
        for(j = 0; j < n; j++){
            printf("%d ", mgraph[i][j]);
        }
        putchar('\n');
    }
}
void DFS(int v, bool *visited) {
    visited[v] = true;
    for (int i = 0; i < n; ++i) {
        if(visited[i] == false && mgraph[v][i] != 0)
            DFS(i,visited);
    }
}
void DFS() {
    bool visited[n];
    for (int i = 0; i < n; ++i) {
        visited[i] = false;
    }
    DFS(0, visited);
    for (int i = 0; i < n; ++i) {
        if (visited[i] == false) {
            flag = false;
        }
    }
}
bool IsOla() {
    int arr[n];
    for(int i = 0; i < n; i++)
        arr[i] = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(mgraph[i][j] == 1)
                arr[j]++;
        }
    }
    for(int i = 0; i < n; i++) {
        if(arr[i]%2 != 0)
            return false;
    }
    return true;
}
void printOla(int start) {
    stv.push(start);
    for(int i = 0; i < n; i++) {
        if( visit[start][i] != 0) {
            visit[start][i] = visit[i][start] = 0;
            printOla(i);
        }
    }
    quv.push(stv.top());
    stv.pop();
}
