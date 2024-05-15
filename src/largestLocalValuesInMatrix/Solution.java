package largestLocalValuesInMatrix;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length - 3 + 1][grid[0].length - 3 + 1];
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[i].length - 3; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (max < grid[k][l]) {
                            max = grid[k][l];
                        }
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}
