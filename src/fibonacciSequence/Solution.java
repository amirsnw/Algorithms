package fibonacciSequence;

import java.util.Iterator;

public class Solution implements Iterable<Integer> {

    private final int callCount;

    public Solution(int callCount) {
        this.callCount = callCount;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int first = 0;
            private int second = 1;
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < callCount;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Sequence End Reached");
                }
                if (currentIndex == 0) {
                    currentIndex++;
                    return 0;
                } else if (currentIndex == 1) {
                    currentIndex++;
                    return 1;
                } else {
                    int result = first + second;
                    first = second;
                    second = result;
                    currentIndex++;
                    return result;
                }
            }
        };
    }
}
