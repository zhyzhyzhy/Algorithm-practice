class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        returnArr(list, nums, 0, nums.length - 1);
        return list;
    }
    public void returnArr(List list, int[] nums, int i, int j) {
        int[] numsNew = nums.clone();
        if (i < j) {
            for (int  k = i; k <= j; k++) {
                swap(numsNew, i, k);
                returnArr(list, numsNew,i + 1, j);
            }
        }
        else {
            List<Integer> list1 = new LinkedList<Integer>();
            for (int num : nums) {
                list1.add(num);
            }
            list.add(list1);
        //    System.out.println(Arrays.toString(nums));
        }
    }
    public void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.permute(new int[]{1,2,3}).toArray()));
        solution.permute(new int[]{1,2,3});
    }
}