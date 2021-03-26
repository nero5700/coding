import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] < dp[j] + 1 && nums[j] < nums[i]) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {
                10,9,2,5,3,7,101,18
        };
        int res = new Q300().lengthOfLIS(nums);
        System.out.println(res);
    }
}
