package AmazonInterview.PreviousQuestions;

import java.util.PriorityQueue;

public class MaxScore {
    //1799
    public int maxScore(int[] nums) {
        PriorityQueue<Pair> pairs = new PriorityQueue<>((a,b) -> a.gcd - b.gcd );
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                pairs.add(new Pair(nums[i],nums[j]));
            }
        }
        int i = 0;
        int ans = 0;

        while (i < (nums.length / 2)) {
            Pair p = pairs.poll();
            System.out.println("p: " +p);
            ans = ans + p.gcd;
            i++;
        }
        return ans;
    }
    class Pair{
        int a;
        int b;
        public  int gcd;

        Pair(int a, int b){
            this.a = a;
            this.b = b;
            this.gcd = calcGCD(a,b);
        }

        private int calcGCD(int a, int b) {
            if (b==0) return a;
            return calcGCD(b,a%b);
        }
    }
}
