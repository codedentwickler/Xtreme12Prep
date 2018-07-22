import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShoePairs {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        HashMap<Integer, Integer> leftShoes = new HashMap<>();
        HashMap<Integer, Integer> rightShoes = new HashMap<>();

        int shoeCount = Integer.parseInt(in.nextLine());

        for (int i = 0; i < shoeCount; i++) {

            String[] lines = in.nextLine().trim().split(" ");

            int size = Integer.parseInt(lines[0]);

            if (lines[1].equals("L")) {
                leftShoes.put(size, leftShoes.getOrDefault(size,0) + 1);
            } else if (lines[1].equals("R")) {
                rightShoes.put(size, rightShoes.getOrDefault(size,0) + 1);
            }
        }

        Set<Integer> shoeSizes = leftShoes.size() > rightShoes.size() ? rightShoes.keySet() : leftShoes.keySet();

        int totalSizesOfPairs = 0;
        for (Integer s : shoeSizes) {

            int sizeOfPairs = Integer.min(leftShoes.getOrDefault(s,0), rightShoes.getOrDefault(s,0));
            totalSizesOfPairs += sizeOfPairs;
        }

        System.out.println(totalSizesOfPairs);
    }
}
