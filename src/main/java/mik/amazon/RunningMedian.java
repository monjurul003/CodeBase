package mik.amazon;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    static double[] runningMedian(int[] a) {
        PriorityQueue<Integer> lower = new PriorityQueue(a.length, Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue();
        double[] median = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            addToHeap(a[i], lower, higher);
            rebalanceHeap(lower, higher);
            median[i] = getMedian(lower, higher);
        }
        return median;
    }

    private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> bigger = lower.size() < higher.size() ? higher : lower;
        PriorityQueue<Integer> smaller = lower.size() < higher.size() ? lower : higher;

        if (smaller.size() == bigger.size()) {
            return ((double) smaller.peek() + bigger.peek()) / 2.0;
        } else {
            return bigger.peek();
        }
    }

    private static void rebalanceHeap(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> bigger = lower.size() < higher.size() ? higher : lower;
        PriorityQueue<Integer> smaller = lower.size() < higher.size() ? lower : higher;
        if (bigger.size() - smaller.size() >= 2) {
            smaller.offer(bigger.poll());
        }
    }

    private static void addToHeap(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.isEmpty() ||  number < lower.peek()) {
            lower.offer(number);
        } else {
            higher.offer(number);
        }
    }
}
