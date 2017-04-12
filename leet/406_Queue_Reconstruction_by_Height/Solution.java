import java.util.Arrays;
import java.util.Comparator;
public class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        int[][] queue = new int[people.length][2];
        for (int i = 0; i < queue.length; i++ ){
            queue[i][0] = -1;
        }
            
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return b[1] - a[1];
                return a[0] - b[0];
            }
        });

        for ( int min = 0; min < people.length; min++) {
            int hasHeigherCount = 0;
            int emptyCount = 0;
            for (int i = 0; i < people[min][1]; i++) {
                if ( queue[i][0] == -1) {
                    emptyCount++;
                }
                else if ( queue[i][0] >= people[min][0]) {
                    hasHeigherCount++;
                }
            }

            if ( hasHeigherCount == people[min][1]) {
                int i = people[min][1];
                while (queue[i][0] != -1) {
                    i++;
                }
                queue[i][0] = people[min][0];
                queue[i][1] = people[min][1];
            }
            else if (hasHeigherCount < people[min][1]) {
                int i = 0;
                int position = 0;
                while (position < people[min][1]) {
                   if ( queue[i][0] == -1 || queue[i][0] == people[min][0]) {
                       i++;
                       position++;
                   } 
                   else {
                       i++;
                   }
                }
                while (queue[i][0] != -1) {
                    i++;
                }
                queue[i][0] = people[min][0];
                queue[i][1] = people[min][1];
            }
            people[min][0] = -1;
            System.out.println(Arrays.deepToString(queue));
        }
        return queue;
        
    }
    public static int findMin(int[][] people) {
        int[][] min = {
            {Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        
        int position = -1;
        for ( int i = 0; i < people.length; i++) {
            if ( people[i][0] == -1) {
                continue;
            }
            else if ( people[i][0] < min[0][0]) {
                min[0][0] = people[i][0];
                min[0][1] = people[i][1];
                position = i;
            }
            else if (people[i][0] == min[0][0] && people[i][1] < min[0][1]) {
                min[0][1] = people[i][1];
                position = i;
            }
        }
        return position;
    }
    public static void main(String[] args) {
       int[][] people = {
           {7,0},
           {4,4},
           {7,1},
           {5,0},
           {6,1},
           {5,2}
       } ;
       System.out.println(Arrays.deepToString(people));
       System.out.println();
       System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }
}