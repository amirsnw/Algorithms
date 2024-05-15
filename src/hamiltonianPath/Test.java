package hamiltonianPath;

public class Test {

    public static void main(String[] args) {
        int[][][] input = {
                {
                        {4, -10}, {-1, 3}, {4, -3}, {-3, 3}
                },
                {
                        {91207, 59631}, {581, 91207}, {51465, 20358}, {-66119, 94118}, {-7392, 72809},
                        {51465, -7392}, {-98504, -29411}, {-98504, 35968}, {35968, 59631}, {94118, 20358},
                        {72809, 581}, {34348, 43653}, {43653, -29411}
                },
                {
                        {2, 1}, {3, 4}, {3, 2}
                },
                {
                        {4, -2}, {1, 4}, {-3, 1}
                },
                {
                        {100000, -100000}
                }
        };
        SolutionV2 hamiltonianPaths = new SolutionV2();
        for (int[][] edges : input) {
            int[] ints = hamiltonianPaths.restoreArray(edges);
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i]);
                if (i != ints.length - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }
}
