/*
描述
今天是阴历七月初五，acm队员zb的生日。
zb正在和C小加、never在武汉集训。
他想给这两位兄弟买点什么庆祝生日，经过调查，zb发现C小加和never都很喜欢吃西瓜，而且一吃就是一堆的那种，
zb立刻下定决心买了一堆西瓜。当他准备把西瓜送给C小加和never的时候，遇到了一个难题，
never和C小加不在一块住，只能把西瓜分成两堆给他们，为了对每个人都公平，他想让两堆的重量之差最小。
每个西瓜的重量已知，你能帮帮他么？
输入
多组测试数据（<=1500）。数据以EOF结尾
第一行输入西瓜数量N (1 ≤ N ≤ 20)
第二行有N个数，W1, …, Wn (1 ≤ Wi ≤ 10000)分别代表每个西瓜的重量
输出
输出分成两堆后的质量差
样例输入
5
5 8 13 27 14
样例输出
3
*/


import java.util.*;
public class Solution325 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int total;
        int[] weight = new int[22];
        while(scanner.hasNext()) {
           total = scanner.nextInt();
            for(int i = 1; i < total + 1; i++) {
                weight[i] = scanner.nextInt();
            }
            Arrays.sort(weight);
            int sum = 0;
            for(int i = 1; i < total + 1; i++) {
                sum += weight[i];
            }
            int halfSum = sum/2;
            // System.out.println("halfSum = " + halfSum);
            int[][] v = new int[total + 1][halfSum+1];
            for(int i = 1; i <= total; i++) {
                // System.out.println("weight[i]" + weight[i]);
                for(int j = 0; j <= halfSum; j++) {
                    if(weight[i] <= j) {
                        if(v[i - 1][j - weight[i]] + weight[i] > v[i - 1][j] && v[i - 1][j - weight[i]] + weight[i] <= halfSum) {
                            v[i][j] = v[i-1][j-weight[i]] + weight[i];
                        }
                        else {
                            v[i][j] = v[i-1][j];
                        }
                    }
                    else {
                        v[i][j] = v[i-1][j];
                    }
            // System.out.print(v[i][j] + "  ");
                }
            }
        // System.out.println("result = " +(sum-2*v[total][halfSum]));
            System.out.println(sum-2*v[total][halfSum]);
        }
    }
}