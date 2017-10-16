import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLastNumber1(5,3));

    }
    public int getLastNumber(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            ListIterator<Integer> iterator = list.listIterator(0);
            while (iterator.hasNext()) {
                i++;
                iterator.next();
                if (i == k) {
                    i = 0;
                    iterator.remove();
                }
            }
        }
        return list.get(0);
    }
    //假设n个人，每隔m踢出一个
    //那么第一个人是m%n，那么从余下的第一个人开始重新报数
    //f(n) = (f(n-1) + m) % i

    public int getLastNumber1(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }



















}