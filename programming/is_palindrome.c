#include <stdio.h>
int isPalindrome1(const char *str, int n) {
    if (str == NULL || n < 1) {
        return 0;
    }
    int i = 0, j = n - 1;
    while (i++ < j--) {
        if (str[i] != str[j]) {
            return 0;
        }
    }
    return 1;
}
int isPalindrome2(const char *str, int n) {
    if (str == NULL || n < 1) {
        return 0;
    }
    int left = (n >> 1) - 1 >= 0 ? (n >> 1) - 1 : 0;
    int right = n - left - 1;
    while (left >= 0) {
        if (str[left--] != str[right++]) {
            return 0;
        }
    }
    return 1;
}
int main(int argc, char* argv[])
{
    printf("%d\n",isPalindrome2("heeeh", 5));
}