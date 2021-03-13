public class Q7 {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        StringBuilder builder = new StringBuilder();
        int sign = x / Math.abs(x);
        x = Math.abs(x);
        while (x > 0) {
            builder.append(x % 10);
            x /= 10;
        }
        try {
            return Integer.parseInt(builder.toString()) * sign;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int res = new Q7().reverse(1534236469);
        System.out.println(res);
    }
}
