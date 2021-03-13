public class Q6 {
    public String convert(String s, int numRows) {
        StringBuilder builder = new StringBuilder();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            if (i == numRows - 1 || i == 0) {
                int gap = 2 * numRows - 2;
                for (int j = i; j < s.length(); j += gap) {
                    builder.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                while (true) {
                    if (j < s.length()) {
                        builder.append(s.charAt(j));
                    } else {
                        break;
                    }
                    if (flag) {
                        j += 2 * (numRows - i - 1);
                    } else {
                        j += 2 * (i);
                    }
                    flag = !flag;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String res = new Q6().convert("PAYPALISHIRING", 4);
        System.out.println(res);
    }
}
