/**
	File Name: 1-13.c
	Author: zhy
	Created Time: 2017/03/02 - 15:10:54
*/
#include <stdio.h>
int count(int n, int m) {
	if(n == 1)
		return m;
	else if(n == m)
		return 1;
	else
		return count(n, m-1) + count(n-1, m-1);
} 
int main(int argc, char *argv[])
{
	printf("%d\n", count(4,4));
	return 0;
}
