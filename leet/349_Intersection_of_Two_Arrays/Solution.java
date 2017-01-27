import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

/**
        File Name: Solution.java
        Author: zhy
        Created Time: 2017/01/23 - 23:21:07
*/
public class Solution {
  public static int[] intersection(int[] nums1, int[] nums2) {
    int[] result =
        new int[nums1.length > nums2.length ? nums2.length : nums1.length];
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
	int k = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        result[k++] = nums1[i];
        while (i + 1 < nums1.length && nums1[i] == nums1[i+1]) {
          i++;
        }
        while (j + 1 < nums2.length && nums2[j] == nums2[j+1]) {
          j++;
        }
		i++;
		j++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      }
    }
	int[] finalArray = new int[k];
	for(int m = 0; m < k; m++)
		finalArray[m] = result[m];
    return finalArray;
  }
  public static void main(String[] args) {
	  int[] nums1 = new int[]{1,2,2,1};
	  int[] nums2 = new int[]{2,2};
	  System.out.println(Arrays.toString(intersection(nums1, nums2)));
  }
}
