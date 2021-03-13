public class Q547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j]==1){
                    join(parent, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i]==i){
                res++;
            }
        }
        return res;
    }

    public static int find(int[] parent, int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }

    public static void join(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }


    public static void main(String[] args) {

    }
}
