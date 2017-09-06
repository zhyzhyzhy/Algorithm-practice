import com.sun.imageio.plugins.bmp.BMPCompressionTypes;

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean isHasOne = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1] ) {
                if ((i != 0 && nums[i-1] >= nums[i+1]) && (i < nums.length - 2 && nums[i] > nums[i + 2])) {
                    return false;
                }
                else if (isHasOne){
                    return false;
                }
                else {
                    isHasOne = true;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}