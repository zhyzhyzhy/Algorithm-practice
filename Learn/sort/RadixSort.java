package org.zhy;

import java.util.Arrays;

/**
 * Created by zhy on 3/19/17.
 */
public class RadixSort{
        public static void main(String[] args) {
            radixSort(new int[]{12,3,56,32,45,78,32});
        }

        //基数排序，只做一个简单的实现，两位数
        public static void radixSort(int[] nums) {
            int[][] nums1 = new int[10][10];
            //第一次入
            for (int i : nums) {
                int k = i % 10;
                for (int j = 0; j < 10; j++) {
                    if (nums1[k][j] == 0) {
                        nums1[k][j] = i;
                        break;
                    }
                }
            }
            //第一次拿
            int m = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (nums1[i][j] != 0) {
                        nums[m++] = nums1[i][j];
                        nums1[i][j] = 0;
                    }
                }
            }
            //
            //第二次入
            for (int i : nums) {
                int k = i / 10;
                for (int j = 0; j < 10; j++) {
                    if (nums1[k][j] == 0) {
                        nums1[k][j] = i;
                        break;
                    }
                }
            }
            //第二次拿
            m = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (nums1[i][j] != 0) {
                        nums[m++] = nums1[i][j];
                    }
                }
            }
            Arrays.stream(nums).forEach(System.out::println);
        }
}
