package info.woody.java.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstimatePrimitiveTypeSize {

    public static final int SIZE_1K = 1024;
    public static final int SIZE_1M = SIZE_1K * 1024;
    public static final int SIZE_10M = SIZE_1M * 10;
    public static final int SIZE_100M = SIZE_1M * 100;

    public static final Runtime runtime = Runtime.getRuntime();
    public static double lastUsed = 0;
    public static double nowUsed = 0;

    public static void main(String[] args) {
//        System.gc();
//        System.out.printf("Initial used memory: %.4f M\n", (5.12d * SIZE_100M - runtime.maxMemory()) / SIZE_1M);
//        System.out.println("***********************************");
//        new byte[SIZE_100M].toString();
//        new byte[SIZE_100M].toString();
//        new byte[SIZE_100M].toString();
//        new byte[SIZE_100M].toString();
//        new byte[SIZE_100M].toString();
//        new byte[SIZE_100M].toString();
//        new byte[SIZE_100M].toString();
//        new byte[SIZE_100M].toString();
        System.gc();
        System.out.printf("Initial used memory: %.4f M\n", (5.12d * SIZE_100M - runtime.maxMemory()) / SIZE_1M);
        System.out.println("***********************************");

        List<Object> list = new ArrayList<>();

        printTotalMemory(Void.class);

        list.add(new byte[SIZE_100M]);
        printTotalMemory(Byte.class);

        list.add(new byte[SIZE_10M]);
        printTotalMemory(Byte.class);

        list.add(new boolean[SIZE_10M]);
        printTotalMemory(Boolean.class);

        list.add(new short[SIZE_10M]);
        printTotalMemory(Short.class);

        list.add(new char[SIZE_10M]);
        printTotalMemory(Character.class);

        list.add(new int[SIZE_10M]);
        printTotalMemory(Integer.class);

        list.add(new float[SIZE_10M]);
        printTotalMemory(Float.class);

        list.add(new long[SIZE_10M]);
        printTotalMemory(Long.class);

        list.add(new double[SIZE_10M]);
        printTotalMemory(Double.class);

        list.add(new Object[SIZE_10M]);
        printTotalMemory(Object.class);
    }

    private static void printTotalMemory(Class clazz) {
        System.gc();

        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        lastUsed = nowUsed;
        nowUsed = totalMemory - freeMemory;
        System.out.printf("Max memory in bytes: %d\n", maxMemory);
        System.out.printf("Total memory in bytes: %d\n", totalMemory);
        System.out.printf("Free memory in bytes: %d\n", freeMemory);

        System.out.printf("Human-readable max memory: %.4f M\n", maxMemory * 1.0d / SIZE_1M);
        System.out.printf("Human-readable total memory: %.4f M\n", totalMemory * 1.0d / SIZE_1M);
        System.out.printf("Human-readable free memory: %.4f M\n", freeMemory * 1.0d / SIZE_1M);
        System.out.printf("Human-readable used memory: %.4f M\n", (totalMemory - freeMemory) * 1.0d / SIZE_1M);
        System.out.printf("Human-readable used memory increases: %.4f M\n", (nowUsed - lastUsed) * 1.0d / SIZE_1M);
        System.out.println("***********************************" + Optional.ofNullable(clazz).map(Class::getCanonicalName).orElse("Initial state"));

        System.gc();
    }
}
