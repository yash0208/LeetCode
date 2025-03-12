package AmazonInterview.Graph.BFS;

import java.util.*;
import java.util.stream.Collectors;

public class WallsAndGates {
    //Directions to iterate
    static int[] xDirections = {-1,0,1,0};
    static int[] yDirections = {0,1,0,-1};
    public static List<List<Integer>> mapGateDistances(List<List<Integer>> dungeonMap) {
        // WRITE YOUR BRILLIANT CODE HERE
        if(dungeonMap.isEmpty()) return new ArrayList<>();
        //Initialize the solution list
        List<List<Integer>> ans = new ArrayList<>();

        //Take the map and iterate through it to fill up all positions with the respective nearest exit
        for (int i = 0; i < dungeonMap.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < dungeonMap.get(0).size(); j++) {
                if(dungeonMap.get(i).get(j) == Integer.MAX_VALUE) temp.add(findExit(dungeonMap,i,j));
                else temp.add(dungeonMap.get(i).get(j));
            }
            ans.add(temp);
        }
        return ans;
    }

    //Find out the nearest exit with BFS
    public static int findExit(List<List<Integer>> map, int r, int c){
        //Make a queue to do the bfs
        Queue<int[]> queue = new LinkedList<>();
        //Keeping track of exit level
        int steps = 0;
        queue.add(new int[]{r,c});
        boolean flagFound = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int currentX = position[0];
                int currentY = position[1];
                for (int j = 0; j < xDirections.length; j++) {
                    int x = currentX + xDirections[j];
                    int y = currentY + yDirections[j];
                    if(x>=0 && y>=0 && x<map.size() && y<map.get(0).size() && (map.get(x).get(y) != -1)){
                        if(map.get(x).get(y) == 0) {
                            return steps;
                        }
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dungeonMapLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> dungeonMap = new ArrayList<>();
        for (int i = 0; i < dungeonMapLength; i++) {
            dungeonMap.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<List<Integer>> res = mapGateDistances(dungeonMap);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
