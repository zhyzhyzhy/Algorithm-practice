public class CountingSort {
   public static void main(String[] args) {
    countingSort(new int[]{0,3,2,4,5,2,2,1}, 5);
}

public static void countingSort(int[] nums, int max) {
    int[] nums1 = new int[max+1];
    int[] nums2 = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        nums1[nums[i]] += 1;
    }

    for (int i = 1; i < nums1.length; i++) {
        nums1[i] = nums1[i] + nums1[i-1];
    }
//            Arrays.stream(nums1).forEach(System.out::println);

    for (int i = nums.length - 1; i >= 0; i--) {
        int x = nums[i];
        nums2[nums1[x] - 1] = x;
        nums1[x] = nums1[x] - 1;
    }
    Arrays.stream(nums2).forEach(System.out::println);
}
}
