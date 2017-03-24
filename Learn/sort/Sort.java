package Sort;

import java.util.Arrays;


public class Sort {
  /**
   * 选择排序，就是每一趟找出最小的，然后与i代表的那个交换
   *
   * 优化就是每次记下最小的那个索引，而不是立即交换两个数
   */
  public static void SelectSort(int[] nums) {
    int min;
    for (int i = 0; i < nums.length; i++) {
      min = i;
      for (int j = i; j < nums.length; j++) {
        if (nums[j] < nums[min])
          min = j;
      }
      if (min != i) {
        int temp = nums[min];
        nums[min] = nums[i];
        nums[i] = temp;
      }
    }
  }
  /**
   * 插入排序
   *
   * 优化就是每次找出最小的位置，然后记下当前的数的值
   * 把前面的每个数向后移，而不是每次都交换
   *
   *
   */

  public static void InsertSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int j = i;
      int temp = nums[i];
      while (j > 0 && nums[j - 1] > temp) {
        nums[j] = nums[j - 1];
        j--;
      }
      nums[j] = temp;
    }
  }

  public static void ShellSort(int[] nums) {
    int N = nums.length;
    int h = 1;
    //选取h的值
    while (h < N / 3)
      h = 3 * h + 1;

    while (h >= 1) {
      for (int i = h; i < nums.length; i++) {
        int k = i;
        int temp = nums[i];
        while (k >= h && nums[k - h] > temp) {
          nums[k] = nums[k - h];
          k = k - h;
        }
        nums[k] = temp;
      }
      h = h / 3;
    }
  }

  // public static void MergeSort(int[] nums) {
  // 	MergeSelf(nums, 0, nums.length-1); 
  // }
  // public static void MergeSelf(int[] nums, int left, int right) {
  //   if(left >= right) 
  //       return;
  //   int mid = left + (right - left)/2;
  //   MergeSelf(nums, left, mid);
  //   MergeSelf(nums, mid+1, right);
  //   Merge(nums, left, mid, mid + 1, right);
  // }

  public static void MergeSort(int[] nums) {
    for(int i = 1; i < nums.length; i += i) {
        for(int j = 0; j < nums.length - i; j = j + 2*i) 
            Merge(nums, j, j + i -1, j + i, Math.min(nums.length - 1, j + 2*i - 1));
    }
  }

  public static void Merge(int[] nums, int i1, int i2, int j1, int j2) {
    int begin = i1;
    int[] temp = new int[j2 - i1 + 1];
    for(int i = 0; i < temp.length; i++) {
        if(i1 > i2)
            temp[i] = nums[j1++];
        else if(j1 > j2)
            temp[i] = nums[i1++];
        else if(nums[i1] > nums[j1])
            temp[i] = nums[j1++];
        else {
            temp[i] = nums[i1++];
        }
    }
    for(int i = 0; i < temp.length; i++) {
        nums[begin++] = temp[i];
    }
    System.out.println(Arrays.toString(temp));
  }

  public static void quickSort(int[] nums, int begin, int end)
  {
    if(begin >= end) 
        return;
    int temp = nums[begin];
    int i = begin;
    int j = end;
    while(begin < end ) {
        while(nums[end] > temp && begin < end)
            end--;
        if(begin < end){
            nums[begin++] = nums[end];
        }
        while(nums[begin] < temp && begin < end)
            begin++;
        if(begin < end) {
            nums[end--] = nums[begin];
        }
    }
    nums[begin] = temp;
    quickSort(nums, i, begin - 1);
    quickSort(nums, begin+1, j);
  }


  public static void main(String[] args) {
    int[] test = new int[] {3,2,1,3,5,1,2,34,43,21,3,1,0,1,3,43,43,1,1,2,2,3,4,5,1,2,4,32,34,4,5,6,7};
    quickSort(test, 0, test.length - 1);
    System.out.println(Arrays.toString(test));
  }
}
