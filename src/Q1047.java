import java.util.Arrays;
import java.util.LinkedList;


public class Q1047 {
    public String removeDuplicates(String S) {
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        while (true) {
            if (list.isEmpty() && !S.isEmpty()) {
                list.add(S.charAt(0));
                S = S.substring(1);
            }
            if (S.isEmpty()) {
                while (!list.isEmpty()) {
                    res.append(list.pollLast());
                }
                break;
            }
            if (!list.isEmpty() && list.peek() == S.charAt(0)) {
                list.pop();
            } else {
                list.push(S.charAt(0));
            }
            S = S.substring(1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = new Q1047().removeDuplicates("abbaca");
        System.out.println(res);
    }
}
