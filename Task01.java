public class Task01 {
    static String usingString(int fields) {
        String ticket = "";
        for (int i = 1; i <= fields; i++) ticket += "Field" + i + ":Value" + i + "\n";
        return ticket;
    }

    static String usingBuilder(int fields) {
        StringBuilder ticket = new StringBuilder();
        for (int i = 1; i <= fields; i++)
            ticket.append("Field").append(i).append(":Value").append(i).append('\n');
        return ticket.toString();
    }

    static String usingBuffer(int fields) {
        StringBuffer ticket = new StringBuffer();
        for (int i = 1; i <= fields; i++)
            ticket.append("Field").append(i).append(":Value").append(i).append('\n');
        return ticket.toString();
    }

    static void measure(String name, int fields, int runs, java.util.function.IntFunction<String> method) {
        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < runs; i++) result = method.apply(fields);
        long end = System.nanoTime();
        System.out.println(name + " time: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println("Sample ticket length: " + result.length());
    }

    public static void main(String[] args) {
        int fields = 50;
        int tickets = 10000;
        measure("String (+)", fields, tickets, Task01::usingString);
        measure("StringBuilder", fields, tickets, Task01::usingBuilder);
        measure("StringBuffer", fields, tickets, Task01::usingBuffer);
    }
}
