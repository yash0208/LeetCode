package AUDAYDEV;

import java.util.*;

public class TheDetectiveGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        String[] firstLine = scanner.nextLine().split(" ");
        long n = Long.parseLong(firstLine[0]);
        long m = Long.parseLong(firstLine[1]);

        String[] arrStr = scanner.nextLine().split(" ");
        long[] arr = new long[(int)n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(arrStr[i]);
        }

        long[] queries = new long[(int)m];
        for (int i = 0; i < m; i++) {
            queries[i] = Long.parseLong(scanner.nextLine());
        }

        // Create deque and find max element
        Deque<Long> q = new ArrayDeque<>();
        long maxElem = Long.MIN_VALUE;
        for (long num : arr) {
            q.addLast(num);
            maxElem = Math.max(maxElem, num);
        }

        // Store (a, b) pairs
        List<long[]> steps = new ArrayList<>();

        // Simulate until max element reaches front
        while (true) {
            long a = q.removeFirst();
            long b = q.removeFirst();
            steps.add(new long[]{a, b});

            if (a > b) {
                q.addFirst(a);
                q.addLast(b);
            } else {
                q.addFirst(b);
                q.addLast(a);
            }

            if (q.peekFirst() == maxElem) {
                break;
            }
        }

        // Remaining queue after stabilization (excluding max element)
        List<Long> stableCycle = new ArrayList<>();
        Iterator<Long> iterator = q.iterator();
        boolean first = true;

        while (iterator.hasNext()) {
            long val = iterator.next();
            if (first) {
                first = false;
                continue; // Skip the max element
            }
            stableCycle.add(val);
        }

        // Process queries
        for (long i : queries) {
            if (i <= steps.size()) {
                long[] pair = steps.get((int)i - 1);
                System.out.println(pair[0] + " " + pair[1]);
            } else {
                // After stabilization
                int idx = (int)((i - steps.size() - 1) % stableCycle.size());
                System.out.println(maxElem + " " + stableCycle.get(idx));
            }
        }

        scanner.close();
    }
}
