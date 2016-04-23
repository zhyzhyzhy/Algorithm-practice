/*
   偷懒写的一个快速排序，，直接调用的函数
*/
#include <stdio.h>
#include <stdlib.h>
int com(const void *a, const void *b){
	return *(int*)a - *(int*)b;
}
int main(int argc, char *argv[])
{
	int N;
	int i;
	int *arr;
	scanf("%d", &N);
	arr = (int *)malloc(sizeof(int)*N);
	for(i = 0; i < N; i++)
		scanf("%d", &arr[i]);
	qsort(arr, N, sizeof(int), com);
	for(i = 0; i < N-1; i++)
		printf("%d ", arr[i]);
	printf("%d ", arr[i]);
	putchar('\n');
	free(arr);
	return 0;
}
