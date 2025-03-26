package Math;

public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {  // Continue until num is a single-digit number
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;  // Assign the sum back to num
        }
        return num;
    }
}
