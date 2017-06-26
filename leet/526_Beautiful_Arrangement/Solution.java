/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/05/26 - 17:15:43
*/
public class Solution{
	public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countArrangement(2));
	}
    int count = 0;
	public int countArrangement(int N) {
		if (N == 1) 
			return 1;
        traceback(1,N, new boolean[N+1]);
		return count;
    }
    public void traceback(int i,int n, boolean[] used) {
       if (i > n)  {
            count++;
            return;
       }
       for (int j = 1; j < n + 1; j++) {
           if (used[j] == false && (j % i == 0 || i % j == 0)) {
               used[j] = true;
               traceback(i+1, n, used);
               used[j] = false;
           }
       }

    }
}

