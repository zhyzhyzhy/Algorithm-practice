import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        TreeMap<Integer, List<Integer>> map1 = new TreeMap<>();
        for (Integer num : map.keySet()) {
            if (!map1.containsKey((map.get(num)))) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                map1.put(map.get(num), list);
            }
            else {
                map1.get(map.get(num)).add(num);
            }
        }
        int i = 0;
        List<Integer> result = new LinkedList<>();
        for (Integer num : map1.descendingKeySet()) {
            result.addAll    (map1.get(num));
            i += map1.get(num).size();
            if (i >= k) {
                break;
            }
        }
        return result;
    }
}