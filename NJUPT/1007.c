/*
   珍惜生命，少用pow
   */
#include <stdio.h>
#include <math.h>
int main(int argc, char *argv[])
{
	int N;
	int data[100][4];
	int swap[4];
	scanf("%d", &N);
	int a, b, c, d;
	int i = 0;
	int j, k;
	for(a = 2; a <= N; a++)
		for(d = 2; d < a; d++)
			for(c = 2; c <= d; c++)
				for(b = 2; b <= c; b++ )
					if(a*a*a == b*b*b + c*c*c + d*d*d){
						data[i][0] = a;
						data[i][1] = b;
						data[i][2] = c;
						data[i][3] = d;
						i++;
					}
	for(j = 0; j < i -1; j++)
		for(k = j + 1; k < j+4; k++)
			if(data[j][0] == data[k][0]){
				if(data[j][1] > data[k][1]){
					swap[0] = data[j][0];
					swap[1] = data[j][1];
					swap[2] = data[j][2];
					swap[3] = data[j][3];
					data[j][0] = data[k][0];
					data[j][1] = data[k][1];
					data[j][2] = data[k][2];
					data[j][3] = data[k][3];
					data[k][0] = swap[0];
					data[k][1] = swap[1];
					data[k][2] = swap[2];
					data[k][3] = swap[3];
					continue;
				}
				else if(data[j][1] == data[k][1]&&data[j][2] > data[k][2]){
					swap[0] = data[j][0];
					swap[1] = data[j][1];
					swap[2] = data[j][2];
					swap[3] = data[j][3];
					data[j][0] = data[k][0];
					data[j][1] = data[k][1];
					data[j][2] = data[k][2];
					data[j][3] = data[k][3];
					data[k][0] = swap[0];
					data[k][1] = swap[1];
					data[k][2] = swap[2];
					data[k][3] = swap[3];
					continue;
				}
				else if(data[j][1] == data[k][1]&&data[j][2] == data[k][2]&&data[j][3] > data[k][3]){
					swap[0] = data[j][0];
					swap[1] = data[j][1];
					swap[2] = data[j][2];
					swap[3] = data[j][3];
					data[j][0] = data[k][0];
					data[j][1] = data[k][1];
					data[j][2] = data[k][2];
					data[j][3] = data[k][3];
					data[k][0] = swap[0];
					data[k][1] = swap[1];
					data[k][2] = swap[2];
					data[k][3] = swap[3];
					continue;
				}
			}
	for(j = 0; j < i; j++)
		printf("Cube = %d, Triple = (%d,%d,%d)\n", data[j][0], data[j][1], data[j][2], data[j][3]);
	return 0;
}
