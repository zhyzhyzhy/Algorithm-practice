package Graph;

/**
 * Created by zhy on 2/8/17.
 */
public class CC {
    private Graph graph;
    private int count;
    private int[] id;
    private int Vertex;


    public CC(Graph graph) {
        this.graph = graph;
        Vertex = graph.getVertex();
        id  = new int[Vertex];
        boolean[] visited = new boolean[Vertex];
        for(int i = 0; i < Vertex; i++) {
            if(visited[i] == false) {
                DFS(i, visited, id);
                count++;
            }

        }
    }

    private void DFS(int v, boolean[] visited, int[] id) {
        visited[v] = true;
        id[v] = count;
        Node temp = graph.getNodes()[v];
        while(temp != null) {
            if(visited[temp.v] != true) {
                DFS(temp.v, visited, id);
            }
            temp = temp.next;
        }
    }

    public boolean isConnect(int u, int v) {
        return id[u] == id[v];
    }

    public int getCount() {
        return count;
    }

    int id(int v) {
        return id[v];
    }
}
