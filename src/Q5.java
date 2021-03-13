public class Q5 {
    public String longestPalindrome(String s) {
        if (s.isEmpty())
            return "";
        int n = s.length();
        int[][] dp = new int[n][n];
        int max_length = 0, max_i = 0, max_j = 0;
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                if (s.charAt(i) == s.charAt(i + len)) {
                    if (len <= 1 || dp[i + 1][i + len - 1] == 1) {
                        dp[i][i + len] = 1;
                        if (len > max_length) {
                            max_length = len;
                            max_i = i;
                            max_j = i + len;
                        }
                    }
                }
            }
        }
        return s.substring(max_i, max_j + 1);
    }

    public static void main(String[] args) {
        String res = new Q5().longestPalindrome("babad");
        System.out.println(res);
    }
}
