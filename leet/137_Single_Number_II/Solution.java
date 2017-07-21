/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/07/18 - 09:46:22
*/
public class Solution {
    public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for(int i = 0; i < A.length; i++){
        ones = (ones ^ A[i]) & ~twos;
        twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
}
}

