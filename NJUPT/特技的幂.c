/*
*求x的y次方对1000000007取模的值
*没写出来，小谷说可以用数组去存一个大数
*改天试试
*这个里面我愚蠢的想要求log
*/
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
struct divide{
        int x;
        int y;
        int ret;
};
int main()
{
        int n;
        int i,j,k;
        long long a;
        float b;
        struct divide *p;
        scanf("%d", &n);
        p = (struct divide *)malloc(sizeof(struct divide)*n);
        for(i = 0; i < n; i++){
                scanf("%d %d", &(p+i)->x, &(p+i)->y);
        }
        for(i = 0; i < n; i++)
                for(j = 0;; j++ )
                        for(k = 0; k < 1000000007; k++)
                                if(pow((p+i)->x,(p+i)->y) == j*1000000007 +k){
                        // {
        //                         if(k==17)
        //                                 goto heihei;
        //                         a = j*1000000007 + k;
        //                         printf("%d\n",a);
        //                         a = (double)log((double)a);
        //                         b = (double)log((double)(p+i)->x);
        //                         printf("j=%d,k=%d,a=%d,b=%lf\n",j,k,a,b);
        //                         if( (((p+i)->x)*log(a)-b) < 10e-100)
        //                         {
                                        (p+i)->ret = k;
                                        goto heihei;
                                }
                        // }
        heihei:;
        for(i = 0; i < n; i++)
                printf("%d\n", (p+i)->ret);
        free(p);

}
