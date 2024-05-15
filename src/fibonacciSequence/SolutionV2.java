package fibonacciSequence;

public class SolutionV2 {

    private int first = 0;
    private int second = 1;
    private int callCount;

    public SolutionV2(int callCount) {
        this.callCount = callCount;
    }

    public int[] generate() {
        int[] result = new int[10];
        for (int i = 0; i < callCount; i++) {
            if (i == 0) {
                result[i] = 0;
            } else if (i == 1) {
                result[i] = 1;
            } else {
                int temp = second;
                second = first + second;
                first = temp;
                result[i] = second;
            }
        }
        return result;
    }
}
