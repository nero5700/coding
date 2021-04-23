import java.util.Arrays;
import java.util.PriorityQueue;


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        int[] dp_left = new int[n];
        int[] dp_right = new int[n];
        dp_left[0] = height[0];
        dp_right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            dp_left[i] = Math.max(dp_left[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp_right[i] = Math.max(dp_right[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(dp_left[i], dp_right[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
