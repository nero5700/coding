import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.charAt(0) < '0' || token.charAt(0) > '9') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                int res = 0;
                switch (token) {
                    case "+":
                        res = op1 + op2;
                        break;
                    case "-":
                        res = op2 - op1;
                        break;
                    case "*":
                        res = op1 * op2;
                        break;
                    case "/":
                        res = op2 / op1;
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = new Q150().evalRPN(tokens);
        System.out.println(res);
    }
}
