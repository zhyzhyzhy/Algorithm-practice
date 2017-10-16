/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/10/15 - 16:33:43
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b) {
               return a.start - b.start;
           } 
        });
        int i = 1;
        Interval in = intervals.get(0);
        List<Interval> lists = new ArrayList<>();
        while (i < intervals.size()) {
            Interval cur = intervals.get(i);
            if (cur.start >= in.start && in.end >= cur.start) {
                in.start = in.start < cur.start ? in.start : cur.start;
                in.end = cur.end > in.end ? cur.end : in.end;
            }
            else {
                lists.add(in);
                in = cur;
            }
            i++;
        }
        lists.add(in);
        return lists;
    }
}
