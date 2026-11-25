import java.util.*;

public class Task04 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> linkedMap = new LinkedHashMap<>();

        String[] codes = {"M103", "M101", "M104", "M102"};
        int[] stocks = {25, 40, 15, 30};

        for (int i = 0; i < codes.length; i++) {
            hashMap.put(codes[i], stocks[i]);
            treeMap.put(codes[i], stocks[i]);
            linkedMap.put(codes[i], stocks[i]);
        }

        System.out.println("HashMap lookup M101: " + hashMap.get("M101"));
        System.out.println("TreeMap - code order: " + treeMap);
        System.out.println("LinkedHashMap - insertion order: " + linkedMap);

        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) hashMap.get("M101");
        long end = System.nanoTime();
        System.out.println("100000 HashMap lookups: " + (end - start) / 1_000_000.0 + " ms");
    }
}
