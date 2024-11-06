package SupportingFunctions;
import java.util.List;
import java.util.Map;

public class MapPrint {
        public void printAdjacencyList( Map<Integer, List<Integer>> map) {
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                System.out.print(entry.getKey() + ": ");
                for (int neighbor : entry.getValue()) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }

    }
}
