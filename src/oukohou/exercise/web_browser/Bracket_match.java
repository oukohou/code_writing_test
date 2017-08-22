package oukohou.exercise.web_browser;

import java.util.Stack;

/**
 * Created by oukohou on 2017/8/28.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * <p>
 * 给定字符串，输出括号是否匹配,
 * 要求必须用递归写，整个实现不可以出现一个循环语句
 * tips:
 * 就是通过递归来实现循环，判断好边界条件。通过额外的栈空间进行匹配。
 */
public class Bracket_match {

    public boolean match_bracket(Stack<Character> stack, String string, int index, boolean flag) {
        // 防御性编程！！！
        if (string.length() == 0 || index < 0) {
            System.out.println("illegal input....");
            return false;
        }

        // 递归终止条件。
        if (index == (string.length())) {
            if (stack.isEmpty()) {
                flag = true;
            }
            return flag;
        }

        if (string.toCharArray()[index] == '(') {
            stack.push('(');
        } else if (string.toCharArray()[index] == ')') {
            if (!stack.isEmpty()) {
                stack.pop();
            } else // 扫描到右括号，但栈空，匹配失败。
                return false;
        }

        // 递归调用。
        flag = match_bracket(stack, string, index + 1, flag);
        return flag;
    }


    public static void main(String[] args) {
        String s = "4()()()fdgda(((fgdfahkjcnxzvewrt`13245$(%$#@#)(q:df)(4)()";
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        boolean result = new Bracket_match().match_bracket(stack, s, 0, flag);
        System.out.println("result is : " + result);
        System.out.println("brackets not match are : " + stack);
    }
}
