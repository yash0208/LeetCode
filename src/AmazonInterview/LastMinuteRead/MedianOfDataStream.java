package AmazonInterview.LastMinuteRead;

import java.util.PriorityQueue;

public class MedianOfDataStream {
    class MedianFinder {

        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        boolean even = true;
        public MedianFinder() {
            min = new PriorityQueue<>((a,b) -> a - b);
            max = new PriorityQueue<>((a,b) -> b - a);

        }

        public void addNum(int num) {
            if(even){
                max.add(num);
                min.add(max.poll());
            }
            else{
                min.add(num);
                max.add(min.poll());
            }
            even = !even;

        }

        public double findMedian() {
            if(even) return (double) (min.peek() + max.peek()) / 2;
            else return min.peek();
        }
    }
}
