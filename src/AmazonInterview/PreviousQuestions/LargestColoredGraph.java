package AmazonInterview.PreviousQuestions;

import java.util.*;

public class LargestColoredGraph {
    //Class to maintain node and its color
    class Node{
        int index;
        char color;

        public Node(int index,char color){
            this.index = index;
            this.color = color;
        }
    }

    public int largestPathValue(String colors, int[][] edges) {
        //First lets just make sure there is no cycle we can do this with making sure that there is atleast one node with 0 indegrere
        Map<Integer,Integer> inDegreeMap = new HashMap<Integer,Integer>();
        //Also lets make an edge list to make the graph and then do the dfs on it
        Map<Integer, Set<Integer>> edgeList = new HashMap<>();
        //Initialize all colors with 0 indegree
        Set<Node> nodeList = new HashSet<>();
        for(int  i = 0;i<colors.length();i++){
            nodeList.add(new Node(i,colors.charAt(i)));
            inDegreeMap.put(i,0);
            edgeList.put(i,new HashSet<>());
        }
        //Now we have to make indegree and the graph based on the given edges
        for(int i = 0; i < edges.length; i++){
            int source  = edges[i][0];
            int destination = edges[i][1];
            inDegreeMap.put(destination,inDegreeMap.getOrDefault(destination,0)+1);
            edgeList.get(source).add(destination);
        }
        //Now we can find if there is any nodes with 0 indegree and start with those nodes
        Queue<Integer> nodeQueue = new LinkedList<>();
        for(Map.Entry<Integer,Integer> inDegreeEntry : inDegreeMap.entrySet()){
            if(inDegreeEntry.getValue() == 0) nodeQueue.add(inDegreeEntry.getKey());
        }

        //Now we will run dfs on each node to check the color frequeuncy and return the max color from the path
        int processNodes = 0;
        int maxFrequency = 0;
        //create a color count matrix to store the max color for each node
        int[][] colorCount = new int[colors.length()][26];
        while (!nodeQueue.isEmpty()){
            int currentNode = nodeQueue.poll();
            processNodes++;
            int color = colors.charAt(currentNode) - 'a';
            colorCount[currentNode][color]++;
            maxFrequency = Math.max(maxFrequency,colorCount[currentNode][color]);
            for(int neighbour : edgeList.get(currentNode)){
                for (int i = 0; i < 26; i++) {
                    colorCount[neighbour][i] = Math.max(colorCount[neighbour][i],colorCount[currentNode][i]);
                }
                inDegreeMap.put(neighbour,inDegreeMap.getOrDefault(neighbour,0)-1);
                if(inDegreeMap.get(neighbour) == 0) nodeQueue.add(neighbour);
            }
        }
        return processNodes == colors.length() ? maxFrequency : -1;
    }
}
