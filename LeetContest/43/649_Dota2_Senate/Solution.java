import java.awt.image.IndexColorModel;

public class Solution {
    public String predictPartyVictory(String senate) {
        int[] nums = new int[senate.length()];
        int sumD = 0;
        int sumR = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') 
                sumR++;
            else 
                sumD++;
        }
        if (sumD == 0) {
            return "Radiant";
        }
        if (sumR == 0) {
            return "Dire";
        }
        while (true) {
            for (int i = 0; i < senate.length(); i++) {
                if (nums[i] == -1)
                    continue;
                if (senate.charAt(i) == 'R') {
                    for (int j = i + 1; j < senate.length() + i; j++) {
                        int k = j % senate.length() - 1 ;
                        if (nums[k] == -1)
                            continue;
                        if (senate.charAt(k) == 'D') {
                            nums[k] = -1;
                            if (--sumD == 0) {
                                return "Radiant";
                            }
                            break;
                        }
                    }
                } else {
                    for (int j = i + 1; j < senate.length() + i; j++) {
                        int k = j % senate.length() - 1;
                        if (nums[k] == -1)
                            continue;
                        if (senate.charAt(k) == 'R') {
                            nums[k] = -1;
                            if (--sumR == 0) {
                                return "Dire";
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}