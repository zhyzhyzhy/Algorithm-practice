package Graph;

import java.util.*;

/**
 * Created by zhy on 2/8/17.
 */
public class Search {
    private Graph graph;

    public Search(Graph graph) {
        this.graph = graph;
    }
    public Iterator<Integer> adjust(int v) {
        List<Integer> list = new LinkedList<>();
        Node temp = graph.getNodes()[v];
        while(temp != null) {
            list.add(temp.v);
            temp = temp.next;
        }
        return list.listIterator();
    }
    public void  DFS() {
        boolean[] visited = new boolean[graph.getVertex()];
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == false) {
                DFS(visited, i);
                System.out.println();
            }
        }
    }
    private void DFS(boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(" " + v + " ");
        Node temp = graph.getNodes()[v];
        while(temp != null) {
            if(visited[temp.v] == false)
                DFS(visited, temp.v);
            temp = temp.next;
        }
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[graph.getVertex()];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.add(v);
        System.out.print(" " + v + " ");
        while(!queue.isEmpty()) {
            int i = queue.poll();
            Node temp = graph.getNodes()[i];
            while(temp != null) {
                if(visited[temp.v] == false) {
                    queue.add(temp.v);
                    visited[temp.v] = true;
                    System.out.print(" " + temp.v + " ");
                }
                temp = temp.next;
            }

        }
    }

    public void Paths(int v) {
        int[] edgeTo = new int[graph.getVertex()];
        boolean[] visited = new boolean[graph.getVertex()];

        visited[v] = true;
        Node temp = graph.getNodes()[v];
        edgeTo[temp.v] = v;
        DFS(temp.v, edgeTo, visited);

        for(int i = 0; i < graph.getVertex(); i++) {
            System.out.println(i+" : " + edgeTo[i]);
        }
    }
    public void DFS(int x, int[] edgeTo, boolean[] visited) {
        visited[x] = true;
        Node temp = graph.getNodes()[x];
        while(temp != null) {
            if(visited[temp.v] == false) {
                edgeTo[temp.v] = x;
                DFS(temp.v, edgeTo, visited);
            }
            temp = temp.next;
        }
    }
}
