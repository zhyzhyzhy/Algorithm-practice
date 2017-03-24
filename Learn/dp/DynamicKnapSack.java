package dp;

/**
 * Created by zhy on 2/5/17.
 */
public class DynamicKnapSack {
    private int[] v;
    private int[] w;
    private int[][] c;
    private int weight;

    public DynamicKnapSack(int length, int weight, int[] vin, int[] win) {
        v = new int[length + 1];
        w = new int[length + 1];
        c = new int[length + 1][weight + 1];
        this.weight = weight;
        for(int i = 0; i < length + 1; i++) {
            v[i] = vin[i];
            w[i] = win[i];
        }
    }

    public void solve() {
        for(int i = 1; i < v.length; i++) {
            for(int j = 1; j <= weight; j++) {
                if(w[i] <= j) {
                    if(c[i][j] < c[i-1][j-w[i]] + v[i])
                        c[i][j] = c[i-1][j-w[i]] + v[i];
                    else
                        c[i][j] = c[i-1][j];
                }
                else {
                    c[i][j] = c[i-1][j];
                }
            }
        }
    }
    public void printResult() {
        for(int i = 0; i < v. length; i++) {
            for(int j = 0; j <= weight; j++)
                System.out.print(c[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] v = {0, 60, 100, 120};
        int[] w = {0, 10, 20, 30};
        int weight = 50;
        DynamicKnapSack knapsack = new DynamicKnapSack(3, weight, v, w);
        knapsack.solve();
        knapsack.printResult();
    }
}
