package WeeklyContests.BiWeek152;

import java.util.HashSet;
import java.util.Set;

public class Unique3Digits {
    public static int totalNumbers(int[] digits) {
        HashSet<Integer> map = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && i != k && j != k) {
                        if (digits[i] != 0) {
                            if (digits[k] % 2 == 0) {
                                int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                                map.add(number);
                            }
                        }
                    }
                }
            }
        }
        return map.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,2};
        System.out.println(totalNumbers(nums));
    }
}
