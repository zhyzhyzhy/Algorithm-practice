/*
**不知道问题在哪尔
*/
#include <stdio.h>
#include <stdlib.h>
struct data_int{
	int sum;
	int *save;
	int data_del;
};
struct data_char{
	int sum;
	char *save;
	char data_del;
};
struct data_float{
	int sum;
	float *save;
	float data_del;
};
int main(int argc, char *argv[])
{
	int i;
	struct data_int first;
	struct data_char second;
	struct data_float third;

	scanf("%d", &first.sum );
	first.save = (int*)malloc(sizeof(int)*first.sum);	
	for(i = 0; i < first.sum; i++)
		scanf("%d", &first.save[i]);
	scanf("%d", &first.data_del);
	
	scanf("%d", &second.sum);
	second.save = (char*)malloc(sizeof(char)*second.sum); 
	for(i = 0; i < second.sum; i++){
		scanf("%c", &second.save[i]);
		while(second.save[i] == ' ' || second.save[i] == '\n')
			scanf("%c", &second.save[i]);
	}
	scanf("%c", &second.data_del);
	getchar();

	scanf("%d", &third.sum);
	third.save = (float*)malloc(sizeof(float)*third.sum);
	for(i = 0; i < third.sum; i++)
		scanf("%f", &third.save[i]);
	scanf("%f", &third.data_del);

	for(i = first.sum-1; i >= 0; i--)
		printf("%d ", first.save[i]);
	putchar('\n');
	for(i = first.sum-1; i >= 0; i--){
		if(first.save[i] == first.data_del)
			continue;
		printf("%d ", first.save[i]);
	}
	putchar('\n');

	for(i = second.sum-1; i >= 0; i--)
		printf("%c ", second.save[i]);
	putchar('\n');
	for(i = second.sum-1; i >= 0; i--){
		if( second.save[i] == second.data_del)
			continue;
		printf("%c ", second.save[i]);
	}
	putchar('\n');

	for(i = third.sum-1; i >= 0; i--)
		printf("%.1f ", third.save[i]);
	putchar('\n');
	for(i = third.sum-1; i >= 0; i--){
		if(third.save[i] ==third.data_del)
			continue;
		printf("%.1f ",third.save[i]);
	}

	free(first.save);
	free(second.save);
	free(third.save);

	return 0;
}
