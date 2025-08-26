package sequence.alphabet.purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sequence.alphabet.purchase.Purchase.min;
import static sequence.alphabet.purchase.Purchase.totalCount;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfClass = scanner.nextInt();

        for (int i = 0; i < numbersOfClass; i++) {
            int students = scanner.nextInt();
            List<String> words = new ArrayList<>(students);
            for (int j = 0; j < students; j++) {
                words.add(scanner.next());
            }
            int[] need = min(words);
            System.out.println(totalCount(need));
        }
    }
}
