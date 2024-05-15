package fibonacciSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution(10);
        Iterator<Integer> generator = solution.iterator();
        List<Integer> result = new ArrayList<>(10);
        while (generator.hasNext()) {
            result.add(generator.next());
        }
        System.out.println("using iterator: " + result);

        SolutionV2 solution2 = new SolutionV2(10);
        System.out.println(
                "using for-loop: " +
                        Arrays.toString(solution2.generate())
        );
    }
}
