package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * First create a map for array value and occurrence and add count for each value
 * them take a set to insert each count and check if we can insert it or not
 */
public class UniqueNumberOfOccurrence {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        Set<Integer> set = new HashSet<>(arr.length);
        for (int i : arr) {
            Integer count = map.get(i);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(i, count);
        }
        for (int count : map.values()) {
            if (!set.add(count)) {
                return false;
            }
        }
        return true;
    }

    /**
     * create an array of whole size and create a count array of possible counts then if count exist make the boolean true and return if true occur
     * @param arr
     * @return
     */
    public boolean uniqueOccurrencesWithArray(int[] arr) {
        int[] numberOfOccurrences = new int[2001];
        boolean[] used = new boolean[1001];

        for (int i : arr) {
            numberOfOccurrences[1000 + i]++;
        }

        for (int i : arr) {
            int count = numberOfOccurrences[1000 + i]; // идем по исходному массиву
            numberOfOccurrences[1000 + i] = 0; // достаем кол-во повторений и зануляем его
            if (count > 0) {
                if (used[count]) return false;
                else used[count] = true;
            }
        }
        return true;
    }
}
