package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by zhy on 2/4/17.
 */
public class Graph {

    private int Vertex;

    private int Edge;

    private Node[] nodes;

    public Graph(int total) {
        Vertex = total;
        nodes = new Node[total];
    }
    public Graph(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Vertex = scanner.nextInt();
        nodes = new Node[Vertex];
        while(scanner.hasNext()) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            InsertEdge(u, v);
        }
    }

    public int getVertex() {
        return Vertex;
    }

    public int getEdge() {
        return Edge;
    }

    public Node[] getNodes() {
        return nodes;
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

    public void InsertEdge(int u, int v, int weight) {
        if(!Exist(u,v)) {
            Node node = new Node(v,weight,nodes[u]);
            nodes[u] = node;
            node = new Node(u,nodes[v]);
            nodes[v] = node;
            Edge++;
        }
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
}
