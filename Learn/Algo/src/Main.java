import Graph.CC;
import Graph.Graph;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph(new File("/home/zhy/git/acm-practice/Learn/Algo/src/Graph/file.txt"));
        System.out.println(graph.toString());
        CC cc  = new CC(graph);
        System.out.println(cc.getCount());
    }
}
