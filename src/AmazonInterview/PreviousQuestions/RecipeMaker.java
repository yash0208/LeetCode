package AmazonInterview.PreviousQuestions;

import java.util.*;

public class RecipeMaker {

        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            // Inorder to identify which recipes we can make we need to check if all the dependecies are available
            // This means we can make a graph showing the incoming nodes for all recipes and if all the incoming nodes are present in the supplies we can make that recipe
            //We can start by making a indegreeMap for all items
            HashMap<String,Integer> inDegreeMap = new HashMap<>();
            for(String supply: supplies) inDegreeMap.put(supply,0);
            for(String recipe: recipes) inDegreeMap.put(recipe,0);
            Set<String> recipeSet = new HashSet<>(List.of(recipes));
            HashMap<String,Set<String>> ingredientMap = new HashMap<>();
            for(int i = 0; i < recipes.length;i++){
                for(String ing : ingredients.get(i)){
                    ingredientMap.computeIfAbsent(ing,k -> new HashSet<>()).add(recipes[i]);
                    inDegreeMap.put(recipes[i],inDegreeMap.getOrDefault(recipes[i],0)+1);
                }
            }
            //Now we can traverse through the map and remove the nodes that are getting indegree 0
            Queue<String> supplyQueue = new LinkedList<>(List.of(supplies));
            List<String> resultSet = new ArrayList<>();
            while (!supplyQueue.isEmpty()){
                String currentItem = supplyQueue.poll();
                if(recipeSet.contains(currentItem)) resultSet.add(currentItem);
                    for(String item: ingredientMap.get(currentItem)){
                        inDegreeMap.put(item,inDegreeMap.get(item) -1);
                        if(inDegreeMap.get(item) == 0)  supplyQueue.add(item);
                    }
            }
            return resultSet;
        }

}
