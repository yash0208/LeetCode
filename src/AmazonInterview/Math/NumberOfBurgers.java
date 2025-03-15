package AmazonInterview.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfBurgers {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // Check if tomatoSlices is even and within valid bounds.
        if (tomatoSlices % 2 != 0 || tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices)
            return new ArrayList<>();

        int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
        int small = cheeseSlices - jumbo;

        // Both counts must be non-negative.
        if (jumbo < 0 || small < 0)
            return new ArrayList<>();

        return Arrays.asList(jumbo, small);
    }
}
