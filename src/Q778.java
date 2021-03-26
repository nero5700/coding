import java.util.HashMap;

public class Q778 {
    public int swimInWater(int[][] grid) {
        int t = grid[0][0];
        int n = grid.length;
        int[] parent = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
        }
        while (true) {
            for (int i = 0; i < n * n; i++) {
                int[] arr_j = {
                        i + n, i + 1
                };
                for (int j : arr_j) {
                    if (j >= n * n || j % n == 0 && j == i + 1) {
                        continue;
                    }
                    if (grid[i / n][i % n] <= t && grid[j / n][j % n] <= t){
                        union(parent, i, j);
                    }
                }
            }
            if (find(parent, 0) == find(parent, n * n - 1)) {
                return t;
            }
            t++;
        }
    }

    static int find(int[] parent, int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }

    static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }

    public static void main(String[] args) {
        int[][] in = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        int res = new Q778().swimInWater(in);
        System.out.println(res);
    }
}
