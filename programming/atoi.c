/**
	File Name: atoi.c
	Author: zhy
	Created Time: 2017/07/21 - 14:59:37
*/
#include <stdio.h>
#include <string.h>
#include <math.h>
int str_to_int(const char *str);
int main(int argc, char *argv[])
{
	printf("%d\n", str_to_int("123"));
	return 0;
}
int str_to_int(const char *str) {
	if (str == NULL) {
		return 0;
	}
	int is_negative = 0;
	if (str[0] == '-') {
		is_negative = 1;
		str = str + 1;
	}
	int length = strlen(str);
	int result = 0;
	int carry = 1;
	for (int i = 0; i < length; i++) {
		result += (str[length - i - 1] - '0') * carry;
		carry *= 10;
	}
	return is_negative ? -result : result;
}
