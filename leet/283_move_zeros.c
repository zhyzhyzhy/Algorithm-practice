#include <stdio.h>
void moveZeros(int* nums, int numsSize){
	int i = 0, j = numsSize -1;

	int m;

	while( i < j ){
		while(nums[i] != 0 && i < j)
			i++;
		if(i < j){
			m = i;
			while(m < j){
				nums[m] = nums[m+1];
				m++;
			}
			nums[j] = 0;
			j--;
		}
	}
}
int main(int argc, char *argv[])
{
	int nums[] = {1, 0, 0, 12, 21};
	int i;
	moveZeros(nums, 5);
	for(i = 0; i < 5; i++)
		printf("%d,", nums[i]);
	return 0;
}
