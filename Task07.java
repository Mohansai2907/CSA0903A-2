import java.util.*;

public class Task07 {
    public static void main(String[] args) {
        int n = 100000;

        // Original design: removing from the front of an ArrayList shifts elements.
        List<Integer> oldList = new ArrayList<>();
        long startOld = System.nanoTime();
        for (int i = 0; i < n; i++) oldList.add(i);
        while (!oldList.isEmpty()) oldList.remove(0);
        long endOld = System.nanoTime();

        // Redesigned solution: ArrayDeque efficiently removes from the front.
        Deque<Integer> newQueue = new ArrayDeque<>();
        long startNew = System.nanoTime();
        for (int i = 0; i < n; i++) newQueue.addLast(i);
        while (!newQueue.isEmpty()) newQueue.removeFirst();
        long endNew = System.nanoTime();

        System.out.println("ArrayList front removal: " +
            (endOld - startOld) / 1_000_000.0 + " ms");
        System.out.println("ArrayDeque front removal: " +
            (endNew - startNew) / 1_000_000.0 + " ms");
        System.out.println("Both structures processed " + n + " items.");
    }
}
