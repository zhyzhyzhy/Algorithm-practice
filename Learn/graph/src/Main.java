import Graph.MGraph;

public class Main {

    public static void main(String[] args) {
        MGraph graph = new MGraph(6,10000);
        graph.Insert(0,1,50);
        graph.Insert(0,2,10);
        graph.Insert(0,4,70);
        graph.Insert(1,4,10);
        graph.Insert(1,2,15);
        graph.Insert(2,0,20);
        graph.Insert(2,3,15);
        graph.Insert(3,4,35);
        graph.Insert(3,1,20);
        graph.Insert(4,3,30);
        graph.Insert(5,3,3);
        graph.Djista(0);
    }
}
