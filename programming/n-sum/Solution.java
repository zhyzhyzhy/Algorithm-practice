import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {

    //排序后查找，时间复杂度O(nlgn),空间复杂度O(1),但是会改变原数组
    public static int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            }
            else if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                ans[0] = nums[left];
                ans[1] = nums[right];
                return ans;
            }
        }
        return null;
    }

    //运用Hash查找，时间复杂度O(n), 空间复杂度O(n), 不会改变原数组
    public static int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(target - nums[i]);
            }
            else {
                ans[0] = target - nums[i];
                ans[1] = nums[i];
                return ans;
            }
        }
        return null;
    }


    //可以这么写，但是有点慢
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = - nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                if (!set.contains(nums[j])) {
                    set.add(target - nums[j]);
                }
                else {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(-target);
                    list1.add(nums[j]);
                    list1.add(target - nums[j]);
                    Collections.sort(list1);
                    if (!list.contains(list1)) {
                        list.add(list1);
                    }
                }
            }
        }
        return list;
    }

    //以前自己写的一个，但是效率还是不行
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (Arrays.binarySearch(nums, j + 1, nums.length, 0 - nums[i] - nums[j]) > 0) {
                    lists.add(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]));
                }
            }
        }
        return lists;
    }
    //这个挺快的
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] < target) {
                        left++;
                    }
                    else if (nums[left] + nums[right] > target) {
                        right--;
                    }
                    else {
                        lists.add(Arrays.asList(nums[left], nums[right], 0 - target));
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return lists;
    }
    //和threeSum一个思路
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int threeTarget = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (j == i + 1 || nums[j] != nums[j-1]) {
                        int twoTarget = threeTarget - nums[j];
                        int left = j + 1;
                        int right = nums.length - 1;
                        while (left < right) {
                            if (nums[left] + nums[right] < twoTarget) {
                                left++;
                            }
                            else if (nums[left] + nums[right] > twoTarget) {
                                right--;
                            }
                            else {
                                lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left] == nums[left + 1]) {
                                    left++;
                                }
                                while (left < right && nums[right] == nums[right-1]) {
                                    right--;
                                }
                                left++;
                                right--;
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3,12,3,4,1,5,6}, 5)));
    }
}