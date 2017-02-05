import Graph.LGraph;

public class Main {

    public static void main(String[] args) {
        LGraph graph = new LGraph(7);
        graph.InsertEdge(0,1);
        graph.InsertEdge(0,2);
        graph.InsertEdge(0,6);
        graph.InsertEdge(0,5);
        graph.InsertEdge(3,5);
        graph.InsertEdge(3,4);
        graph.InsertEdge(5,4);
        graph.BFS(0);

    }
}
