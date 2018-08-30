package info.woody.java.examples;

public class HowLongStringCouldBe {
    public static void main(String[] args) {

        byte[] byteArray = new byte[Integer.MAX_VALUE];
        String string = null;
        int i = 1;
        System.out.println("start");
        while (i < Integer.MAX_VALUE) {
            string += "1";
            i++;
        }
        System.out.println(string.length());
    }
}
