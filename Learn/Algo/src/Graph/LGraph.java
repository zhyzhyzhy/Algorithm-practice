package Graph;

import java.util.*;

/**
 * Created by zhy on 2/4/17.
 */
public class LGraph {

    private int Vertex;

    private int Edge;

    private Node[] nodes;

    public LGraph(int total) {
        Vertex = total;
        nodes = new Node[total];
    }

    public int getVertex() {
        return Vertex;
    }

    public int getEdge() {
        return Edge;
    }

    public boolean Exist(int u, int v) {
        Node temp = nodes[u];
        while(temp != null) {
            if(temp.v == v)
                return true;
            temp = temp.next;
        }
        return false;
    }
    public void InsertEdge(int u, int v) {
        if(!Exist(u,v)) {
            Node node = new Node(v,nodes[u]);
            nodes[u] = node;
            node = new Node(u,nodes[v]);
            nodes[v] = node;
            Edge++;
        }
    }

    public Iterator<Integer> adjust(int v) {
        List<Integer> list = new LinkedList<>();
        Node temp = nodes[v];
        while(temp != null) {
            list.add(temp.v);
            temp = temp.next;
        }
        return list.listIterator();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < Vertex; i++) {
            builder.append(i + " : " );
            Node temp = nodes[i];
            while(temp != null) {
                builder.append(temp.v + " ");
                temp = temp.next;
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public void  DFS() {
        boolean[] visited = new boolean[Vertex];
        for(int i = 0; i < Vertex; i++) {
            if(visited[i] == false) {
                DFS(visited, i);
                System.out.println();
            }
        }
    }
    private void DFS(boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(" " + v + " ");
        Node temp = nodes[v];
        while(temp != null) {
            if(visited[temp.v] == false)
                DFS(visited, temp.v);
            temp = temp.next;
        }
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[Vertex];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.add(v);
        System.out.print(" " + v + " ");
        while(!queue.isEmpty()) {
            int i = queue.poll();
            Node temp = nodes[i];
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
        int[] edgeTo = new int[Vertex];
        boolean[] visited = new boolean[Vertex];

        visited[v] = true;
        Node temp = nodes[v];
        edgeTo[temp.v] = v;
        DFS(temp.v, edgeTo, visited);

        for(int i = 0; i < Vertex; i++) {
            System.out.println(i+" : " + edgeTo[i]);
        }
    }
    public void DFS(int x, int[] edgeTo, boolean[] visited) {
        visited[x] = true;
        Node temp = nodes[x];
        while(temp != null) {
            if(visited[temp.v] == false) {
                edgeTo[temp.v] = x;
                DFS(temp.v, edgeTo, visited);
            }
            temp = temp.next;
        }
    }
}
