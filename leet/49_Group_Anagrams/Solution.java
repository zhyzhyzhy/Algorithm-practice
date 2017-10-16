/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/16 - 22:30:14
*/
//直接new一个和addAll性能差好多
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String value = String.valueOf(chs);
            if (!map.containsKey(value)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(value, list);
            } else {
                map.get(value).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}

