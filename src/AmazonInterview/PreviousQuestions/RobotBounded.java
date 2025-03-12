package AmazonInterview.PreviousQuestions;

public class RobotBounded {
    public boolean isRobotBounded(String instructions) {
        char[] chars = instructions.toCharArray();
        int x = 0, y = 0;
        char d = 'N'; // Direction: 'N' = North, 'E' = East, 'S' = South, 'W' = West

        for (char c : chars) {
            if (d == 'N') {
                switch (c) {
                    case 'G': y++; break;
                    case 'R': d = 'E'; break;  // 'R' should turn right to East
                    case 'L': d = 'W'; break;  // 'L' should turn left to West
                }
            } else if (d == 'E') {
                switch (c) {
                    case 'G': x++; break;
                    case 'R': d = 'S'; break;
                    case 'L': d = 'N'; break;
                }
            } else if (d == 'W') {
                switch (c) {
                    case 'G': x--; break;
                    case 'R': d = 'N'; break;
                    case 'L': d = 'S'; break;
                }
            } else { // d == 'S'
                switch (c) {
                    case 'G': y--; break;
                    case 'R': d = 'W'; break;
                    case 'L': d = 'E'; break;
                }
            }
        }

        // Robot is bounded in a circle if it's back at (0,0) or it's not facing North
        return (x == 0 && y == 0) || (d != 'N');
    }

}
