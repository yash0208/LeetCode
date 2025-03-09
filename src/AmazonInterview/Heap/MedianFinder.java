package AmazonInterview.Heap;

import java.util.*;

public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    boolean even= true;

    public MedianFinder (){
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public double findMedian() {
        if(!even) return small.peek();
        else return ((double) small.peek() + (double)large.peek()) / 2;
    }

    public void addNum(int num) {
        if(even){
            large.add(num);
            small.add(large.poll());
        }
        else{
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }
}
