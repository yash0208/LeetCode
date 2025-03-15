package AmazonInterview.LastMinuteRead;

import java.util.*;

public class AppPossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //Inorder to find all the reciepes posible we need to eliminate all the dependency
        //lets make a indegree map to check what are all dependency
        HashMap<String,Integer> dependencyIndex = new HashMap<>();
        for(String supply : supplies) dependencyIndex.put(supply,0);
        // Make a map to put the dependecy list
        HashMap<String, Set<String>> dependencyMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for(String ing: ingredients.get(i)){
                dependencyMap.computeIfAbsent(ing,k->new HashSet<>()).add(recipes[i]);
                dependencyIndex.put(recipes[i],dependencyIndex.getOrDefault(recipes[i],0)+1);
            }
        }
        //Now we can make a queue and try to pull all the items with 0 dependecy from it
        Queue<String> queue = new LinkedList<>();
        queue.addAll(List.of(supplies));
        Set<String> recipeSet = new HashSet<>();
        recipeSet.addAll(List.of(recipes));
        List<String> possibleRecipes = new ArrayList<>();
        while (!queue.isEmpty()){
            String currentItem = queue.poll();
            if(currentItem == null) continue;
            if(recipeSet.contains(currentItem)) possibleRecipes.add(currentItem);
            for(String dependy : dependencyMap.getOrDefault(currentItem,new HashSet<>())){
                dependencyIndex.put(dependy,dependencyIndex.getOrDefault(dependy,0)-1);
                if(dependencyIndex.get(dependy) == 0) queue.add(dependy);
            }
        }
        return possibleRecipes;
    }
}
