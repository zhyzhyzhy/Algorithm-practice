/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/11/13 - 16:28:00
*/
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        recursionAdd(new ArrayList<Integer>(), 1, n, k);
        return lists;
    }
    public void recursionAdd(List<Integer> list, int current, int n, int k) {
        if (list.size() == k) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        if (current > n) {
            return;
        }
        list.add(current);
        recursionAdd(list, current + 1, n, k);
        list.remove(list.size() -1);
        recursionAdd(list, current + 1, n, k);
    }
}
