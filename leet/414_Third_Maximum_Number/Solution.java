import java.util.*;
public class Solution {
    public static int thirdMax(int[] nums) {
        int[] temp = new int[3];
        int i = 0;
        int j = 0;
        while(j < 3 && i < nums.length) {
            int k;
            for(k = 0; k < j; k++) {
                if(temp[k] == nums[i]) {
                    i++;
                    break;
                }
            }
            if( k == j)
                temp[j++] = nums[i++];
        }
        if(j < 3) {
            if(j == 1)
                return temp[0];
            else {
                if(temp[0] > temp[1])
                    return temp[0];
                else
                    return temp[1];
            }
        }
        Arrays.sort(temp);
        for(; i < nums.length; i++) {
            if(nums[i] <= temp[0] || nums[i] == temp[2])
                continue;
            else if(nums[i] > temp[2]) {
                temp[0] = temp[1];
                temp[1] = temp[2];
                temp[2] = nums[i];
            }
            else if(nums[i] > temp[1]){
                temp[0] = nums[1];
                temp[1] = nums[i];
            }
            else if(nums[i] < temp[1]){
                temp[0] = nums[i];
            }
        }
        return temp[0];
    }
    public static void main(String[] args) {
        Scanner Love = new Scanner();
        Integer i = new Integer();
        System.out.println(thirdMax(new int[]{5,2,4,1,3,6,0}));
    }
}