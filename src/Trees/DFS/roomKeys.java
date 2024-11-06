package Trees.DFS;

import java.util.HashSet;
import java.util.List;

public class roomKeys {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> keys=new HashSet<>();

        for(int i=0;i<rooms.size();i++){
            for (int j = 1; j < rooms.get(i).size(); j++) {
                if(i==0) keys.add(rooms.get(i).get(j));
                else {
                    if(keys.contains(i)){
                        keys.add(rooms.get(i).get(j));
                    }
                }
            }
        }
        return keys.size()==rooms.size()-1;
    }
}
