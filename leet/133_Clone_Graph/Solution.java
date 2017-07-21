import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
	File Name: Solution.java
	Author: zhy
	Created Time: 2017/07/18 - 10:46:01
*/
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode graph = new UndirectedGraphNode(node.label);
		Set<Integer> set = new HashSet<>();
		set.add(node.label);
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		for (int i = 0; i < node.neighbors.size() ; i++) {
			UndirectedGraphNode node1 = node.neighbors.get(i);
			if (node1.label == node.label) {
				graph.neighbors.add(graph);
			}
			else if (!set.contains(node1.label)) {
				UndirectedGraphNode node2 = new UndirectedGraphNode(node1.label);
				graph.neighbors.add(node2);
				map.put(node1.label, node2);
				recursion(map, set, node2, node1);
			}
			else {
				graph.neighbors.add(map.get(node1.label));
			}
		}
		return graph;
    }
	public void recursion(Map<Integer, UndirectedGraphNode> map, Set<Integer> set, UndirectedGraphNode node1, UndirectedGraphNode node) {
		if (set.contains(node1.label)) {
			return;
		}
		set.add(node1.label);
		for (int i = 0; i < node.neighbors.size() ; i++) {
			UndirectedGraphNode node2 = node.neighbors.get(i);
			if (node.label == node2.label) {
				node1.neighbors.add(node1);
			}
			else if (!set.contains(node2.label)) {
				UndirectedGraphNode node3 = new UndirectedGraphNode(node2.label);
				node1.neighbors.add(node3);
				map.put(node3.label, node3);
				recursion(map, set, node3, node2);
			}
			else {
				node1.neighbors.add(map.get(node2.label));
			}
		}

	}
	public static void main(String[] args) {
		
	}
}
