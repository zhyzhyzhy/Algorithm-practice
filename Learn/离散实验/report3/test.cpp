#include <iostream>
#include <stdio.h>
using namespace std;
//序偶结构
typedef struct {
    char former;
    char after;
}Pair;

int main()
{
    int count = 0;
    char Elements[10];
    printf("输入，以#结束\n");
    scanf("%c", &Elements[count]);
    while(Elements[count] != '#') {
        count++;
        scanf("%c", &Elements[count]);
    }
    getchar();

    Pair pairs[100];
    int total = 0;
    printf("输入序偶，以##结束\n");
    scanf("%c%c", &pairs[total].former, &pairs[total].after );
    getchar();
    while(pairs[total].former != '#' && pairs[total].after != '#') {
        total++;
        scanf("%c%c", &pairs[total].former, &pairs[total].after );
        getchar();
    }

    for(int i = 0; i < total; i++) {
        if(pairs[i].former == pairs[i].after)
            continue;
        for(int j = 0; j < count; j++) {
            Pair testPair1;
            Pair testPair2;
            testPair1.former = pairs[i].former;
            testPair1.after = Elements[j];
            testPair2.former =Elements[j];
            testPair2.after = pairs[i].after;
            int flag = 0;
            for(int k = 0; k < total; k++) {
                if( k == i)
                    continue;
                if(testPair1.former == pairs[k].former && testPair1.after == pairs[k].after)
                    flag++;
                if(testPair2.former == pairs[k].former && testPair2.after == pairs[k].after)
                    flag++;
                if(flag == 2)
                    break;
            }
            if(flag == 2)
                break;
            if(j == count-1)
                printf("<%c,%c> ", pairs[i].former, pairs[i].after);
        }
    }
    return 0;
}
