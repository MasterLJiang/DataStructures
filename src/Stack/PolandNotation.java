package Stack;

import java.util.*;

/**
 * @author Dark
 * @2019/7/13 9:54
 */
public class PolandNotation {
    public static void main(String[] args) {
//        String expression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> list = getListString(expression);
//        System.out.println(cal(list));
        String s = "1+((2+3)*4)-5";
        List<String> list = fixtoListString(s);
        System.out.println(cal(toPolandNotation(list)));
    }

    public static List<String> getListString(String string) {
        String split[] = string.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    /*
    将中缀表达式String类型转换成List<String>类型
     */
    public static List<String> fixtoListString(String string) {
        int index = 0;
        List<String> res = new ArrayList<>();
        String s;
        while (index < string.length()) {
            if (string.charAt(index) < 48 || string.charAt(index) > 57) {
                res.add("" + string.charAt(index));
                index++;
            } else {
                s = "";
                while (index < string.length() && string.charAt(index) >= 48 && string.charAt(index) <= 57) {
                    s += string.charAt(index);
                    index++;
                }

                res.add(s);
            }
        }
        return res;
    }

    /*
    将中缀表达式转换成后缀（逆波兰）表达式
     */
    public static List<String> toPolandNotation(List<String> list) {
        Stack<String> stack = new Stack<>();
        //用于存放逆波兰计算
        Queue<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        for (String s : list) {
            //如果是操作数
            if (s.matches("\\d+")) {
                queue.offer(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    queue.offer(stack.pop());
                }
                //将"("弹栈
                stack.pop();
            } else {
                if (stack.isEmpty() || stack.peek() == "(") {
                    stack.push(s);
                } else if (level(s) > level(stack.peek())) {
                    stack.push(s);
                } else {
                    while (stack.size() != 0 && level(stack.peek()) > level(s)) {
                        queue.offer(stack.pop());
                    }
                    stack.push(s);
                }
            }
        }

        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        while (queue.size() != 0) {
            res.add(queue.poll());
        }

        return res;
    }

    public static int level(String s) {
        if (s.equals("+") || s.equals("-")) {
            return 1;
        } else if (s.equals("*") || s.equals("/")) {
            return 2;
        } else {
            return 0;
        }

    }

    /*
    逆波兰表达式运算
     */
    public static int cal(List<String> list) {
        Stack<String> stack = new Stack<>();

        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("符号错误");
                }
                stack.push("" + res);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
