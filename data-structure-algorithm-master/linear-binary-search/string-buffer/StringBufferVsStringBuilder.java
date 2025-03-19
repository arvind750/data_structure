public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        StringBuffer stringBuffer = new StringBuffer();
        long startTime1 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTime1 = System.nanoTime();
        long timeBuffer = endTime1 - startTime1;

        StringBuilder stringBuilder = new StringBuilder();
        long startTime2 = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTime2 = System.nanoTime();
        long timeBuilder = endTime2 - startTime2;

        System.out.println("Time taken by StringBuffer: " + timeBuffer / 1_000_000.0 + " ms");
        System.out.println("Time taken by StringBuilder: " + timeBuilder / 1_000_000.0 + " ms");

        if (timeBuffer > timeBuilder) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }
    }
}
