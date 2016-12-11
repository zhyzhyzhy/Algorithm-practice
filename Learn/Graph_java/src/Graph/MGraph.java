package Graph;

/**
 * Created by zhy on 12/2/16.
 */

public class MGraph implements Graph {
    private int[][] matrix;
    private int     Length;
    private int     noEdge;
    private int INFTY = 10000;

    public MGraph(int n, int noEdge) {
        matrix = new int[ n ][ n ];
        Length = n;
        this.noEdge = noEdge;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[ i ][ j ] = noEdge;
    }

    @Override
    public boolean Insert(int u, int v, int weight) {
        if (u < 0 || u > Length || v < 0 || v > Length) {
            System.out.println("out of bounce");
            return false;
        }
        matrix[ u ][ v ] = weight;
        return true;
    }

    //无权重的单源最短路径
    public void UnWeight(int u) {
        boolean[] hasCounted = new boolean[ Length ];
        int[]     path       = new int[ Length ];
        int[]     roadLength = new int[ Length ];
        for (int i = 0; i < Length; i++) {
            roadLength[ i ] = -1;
        }

        roadLength[ u ] = 0;

        for (int i = 0; i < Length; i++) {
            for (int k = 0; k < Length; k++) {
                if (hasCounted[ k ] == false && roadLength[ k ] == i) {
                    hasCounted[ k ] = true;
                    for (int j = 0; j < Length; j++)
                        if (matrix[ k ][ j ] != noEdge && hasCounted[ j ] == false) {
                            roadLength[ j ] = roadLength[ k ] + 1;
                            path[ j ] = k;
                        }
                }
            }
        }
        for (int i = 0; i < Length; i++)
            System.out.println(roadLength[ i ]);
    }

    public void Djista(int u) {
        boolean[] hasCounted = new boolean[ Length ];
        int[]     d          = new int[ Length ];
        int[]     path       = new int[ Length ];

       for (int i = 0; i < Length; i++) {
           d[i] = matrix[u][i];
           if(d[i] != INFTY) {
               path[i] = u;
           }
       }
       d[u] = 0;
       hasCounted[u] = true;
        for (int i = 0; i < Length - 1; i++) {
            int minpos = Choose(hasCounted,d);
            if(minpos == -1)
                break;
            hasCounted[minpos] = true;
            for (int j = 0; j < Length; j++) {
                if(hasCounted[j] == false && matrix[minpos][j] + d[minpos] < d[j]) {
                    d[j] = matrix[minpos][j] + d[minpos];
                    path[j] = minpos;
                }
            }
        }
        for (int i = 0; i < Length; i++)
            System.out.print(d[i]+ " ");
    }

    public int Choose(boolean[] hasCounted, int[] d) {
        int min = INFTY;
        int posmin = -1;
        for(int i = 0; i < Length; i++) {
            if(hasCounted[i] == false && d[i] < min) {
                min = d[i];
                posmin = i;
            }
        }
        System.out.println("posmin=" +posmin);
        return posmin;
    }
}
