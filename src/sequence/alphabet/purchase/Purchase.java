package sequence.alphabet.purchase;

import java.util.List;

public class Purchase {
    public static int[] min(List<String> words) {
        int[] need = new int[26];
        for (String word : words) {
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char ch = Character.toLowerCase(word.charAt(i));
                if (ch >= 'a' && ch <= 'z') {
                    freq[ch - 'a']++;
                }
            }
            for (int i = 0; i < 26; i++) {
                need[i] = Math.max(need[i], freq[i]);
            }
        }
        return need;
    }

    public static int totalCount(int[] need) {
        int sum = 0;
        for (int x : need) {
            sum += x;
        }
        return sum;
    }

    public static String prettyPrint(int[] need) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (need[i] > 0) {
                sb.append((char) ('a' + i))
                        .append(": ")
                        .append(need[i])
                        .append(", ");
            }
        }
        if (sb.length() >= 2) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
