package AmazonInterview.PreviousQuestions;

import java.util.*;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> dependencyMap = new HashMap<>();
        HashMap<Integer, Integer> inDegreeMap = new HashMap<>();

        // Initialize in-degree map
        for (int i = 0; i < numCourses; i++) {
            inDegreeMap.put(i, 0);
            dependencyMap.put(i, new HashSet<>()); // Ensure all courses exist in map
        }

        // Fill the dependency map and update in-degrees
        for (int[] pair : prerequisites) {
            int course = pair[0], prerequisite = pair[1];
            dependencyMap.get(prerequisite).add(course);
            inDegreeMap.put(course, inDegreeMap.get(course) + 1);
        }

        // Use a queue to process courses with zero in-degree first
        Queue<Integer> queue = new LinkedList<>();
        for (int course : inDegreeMap.keySet()) {
            if (inDegreeMap.get(course) == 0) {
                queue.add(course);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;

            // Reduce in-degree for dependent courses
            for (int dependent : dependencyMap.get(current)) {
                inDegreeMap.put(dependent, inDegreeMap.get(dependent) - 1);
                if (inDegreeMap.get(dependent) == 0) {
                    queue.add(dependent);
                }
            }
        }

        return index == numCourses ? result : new int[]{};
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(cs.findOrder(numCourses, prerequisites)));
    }
}
