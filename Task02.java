import java.util.*;

public class Task02 {
    static void testList(String name, List<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) list.add(i);
        long addEnd = System.nanoTime();

        list.add(0, -1);
        list.add(list.size() / 2, -2);
        long insertEnd = System.nanoTime();

        int value = list.get(list.size() / 2);
        long accessEnd = System.nanoTime();

        long sum = 0;
        for (int x : list) sum += x;
        long iterateEnd = System.nanoTime();

        list.remove(0);
        list.remove(list.size() / 2);
        long removeEnd = System.nanoTime();

        System.out.println("\n" + name);
        System.out.println("Add end: " + (addEnd - start) / 1_000_000.0 + " ms");
        System.out.println("Insert front and middle: " + (insertEnd - addEnd) / 1_000_000.0 + " ms");
        System.out.println("Get middle: " + (accessEnd - insertEnd) / 1_000_000.0 + " ms");
        System.out.println("Iteration: " + (iterateEnd - accessEnd) / 1_000_000.0 + " ms");
        System.out.println("Remove front and middle: " + (removeEnd - iterateEnd) / 1_000_000.0 + " ms");
        System.out.println("Sample value: " + value + ", Sum: " + sum);
    }

    public static void main(String[] args) {
        int n = 10000;
        testList("ArrayList", new ArrayList<>(), n);
        testList("LinkedList", new LinkedList<>(), n);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) queue.addLast(i);
        for (int i = 0; i < n / 2; i++) queue.removeFirst();
        long end = System.nanoTime();
        System.out.println("\nArrayDeque addLast/removeFirst: " + (end - start) / 1_000_000.0 + " ms");
    }
}
