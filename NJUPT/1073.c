/*
   看来自己要好好看看内存检测工具了
   但是写的感觉还不错，尤其是那几个动态数组分配，指针的使用
   */
#include <stdio.h>
#include <stdlib.h>
struct data{
	int rank;
	char id[20];
	int score;
};
typedef struct data data;
void sort(data *raw_data, int sum);
int main(int argc, char *argv[])
{
	int N;
	int i, j, k;
	int *sum;
	scanf("%d", &N);
	sum = (int *)malloc(sizeof(int)*N);
	data *raw_data[N];
	for(i = 0; i < N; i++){
		scanf("%d", &sum[i]);
		raw_data[i] = (data*)malloc(sizeof(data)*sum[i]);
		for(j = 0; j < sum[i]; j++){
			scanf("%s", raw_data[i][j].id);
			scanf("%d", &raw_data[i][j].score);
		}
		sort(raw_data[i], sum[i]);
	}
	for(i = 0; i < N; i++){
		printf("Case %d:\n", i+1);
		for(j = 0; j < sum[i]; j++){
			printf("%d %s %d\n", raw_data[i][j].rank, raw_data[i][j].id, raw_data[i][j].score);
		}
	}
	for(i = 0; i < N; i++)
		free(raw_data[i]);
	free(sum);	
	return 0;
}
void sort(data *raw_data, int sum){
	data swap;
	int i, j, k = 1;
	int flag;
	for(i = 0; i < sum - 1 ; i++)
		for(j = sum - 2; j >= i; j--)
			if(raw_data[j].score < raw_data[j+1].score){
				swap = raw_data[j];
				raw_data[j] = raw_data[j+1];
				raw_data[j+1] = swap;
			}
	for(i = 0; i < sum; i++){
		j = i + 1;
		flag = 0;
		raw_data[i].rank = k;
		while(j < sum&&raw_data[i].score == raw_data[j].score){
			raw_data[j].rank = k;
			j++;
			flag++;
		}
		k += flag+1;
		i = j - 1;
	}
}
