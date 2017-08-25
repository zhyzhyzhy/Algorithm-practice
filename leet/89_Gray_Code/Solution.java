import java.util.ArrayList;
import java.util.List;


//感觉像找规律。。。
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int cur = 1 << i;
            for (int j = list.size() - 1; j >=0; j--) {
                list.add(list.get(j) + cur);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}