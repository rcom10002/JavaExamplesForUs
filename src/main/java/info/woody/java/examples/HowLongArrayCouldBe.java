package info.woody.java.examples;

public class HowLongArrayCouldBe {

    public static void main(String[] args) {
        final byte[] byteArray = new byte[Integer.MAX_VALUE - 2];
        System.out.println(byteArray.length);

    }

}
