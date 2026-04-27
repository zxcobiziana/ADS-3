import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        Quick quick = new Quick();
        Binary binary = new Binary();

        int[] sizes = {10, 100, 1000};
        Random rand = new Random();

        for (int size : sizes) {
            System.out.println("\nArray size: " + size);
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = rand.nextInt(1000);

            int[] bubbleArr = arr.clone();
            long startBubble = System.nanoTime();
            bubble.sort(bubbleArr);
            long endBubble = System.nanoTime();
            System.out.println("Bubble Sort time: " + (endBubble - startBubble) + " ns");

            int[] quickArr = arr.clone();
            long startQuick = System.nanoTime();
            quick.sort(quickArr);
            long endQuick = System.nanoTime();
            System.out.println("Quick Sort time: " + (endQuick - startQuick) + " ns");

            int target = quickArr[size / 2];
            long startBinary = System.nanoTime();
            int index = binary.search(quickArr, target);
            long endBinary = System.nanoTime();
            System.out.println("Binary Search time: " + (endBinary - startBinary) + " ns");
            System.out.println("Target " + target + " found at index: " + index);
        }
    }
}
