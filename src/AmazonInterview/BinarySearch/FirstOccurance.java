package AmazonInterview.BinarySearch;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstOccurance {
    class Solution {
        public static int findFirstOccurrence(List<Integer> arr, int target) {
            // WRITE YOUR BRILLIANT CODE HERE
            int len = arr.size();
            if(arr.get(0) == target) return 0;
            int left = 1;
            int right = len - 1;
            int possibleIndex = -1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(arr.get(mid) == target){
                    possibleIndex = mid;
                    right = mid -1;
                }
                else if(arr.get(mid) > target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }

            }
            return possibleIndex;
        }

        public static List<String> splitWords(String s) {
            return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
            int target = Integer.parseInt(scanner.nextLine());
            scanner.close();
            int res = findFirstOccurrence(arr, target);
            System.out.println(res);
        }
    }

}
