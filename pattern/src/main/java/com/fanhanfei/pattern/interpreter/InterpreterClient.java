package com.fanhanfei.pattern.interpreter;

/**
 * @author zhangjunshuai
 * @date 2019/11/25
 * @description
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

abstract class Expression {
    public abstract int interpreter(HashMap<String, Integer> args);
}

class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> args) {
        return args.get(this.key);
    }
}

abstract class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> args) {
        return left.interpreter(args) + right.interpreter(args);
    }
}

class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> args) {
        return left.interpreter(args) - right.interpreter(args);
    }
}

class Calculator {
    /**
     * 定义的表达式
      */
    private Expression expression;

    /**
     * 构造函数传参,并解析
     * @param expStr
     */
    public Calculator(String expStr) {
        // 定义一个堆栈，安排运算的先后顺序
        LinkedList<Expression> stack = new LinkedList<>();
        // 表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();
        // 运算
        Expression left ;
        Expression right ;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                // 加法
                case '+':
                    // 加法结果放到堆栈中
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default: // 公式中的变量
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        // 把运算结果抛出来
        this.expression = stack.pop();
    }

    /**
     * 开始运算
     * @param args
     * @return
     */
    public int run(HashMap<String, Integer> args) {
        return this.expression.interpreter(args);
    }
}

public class InterpreterClient {
    /**
     * 运行四则运算
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        // 赋值
        HashMap<String, Integer> var = getValue(expStr);
        Calculator cal = new Calculator(expStr);
        System.out.println("运算结果为：" + expStr + "=" + cal.run(var));
    }

    /**
     * 获得表达式
     * @return
     * @throws IOException
     */
    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in)))
                .readLine();
    }

    /**
     * 获得值映射
     * @param exprStr
     * @return
     * @throws IOException
     */
    public static HashMap<String, Integer> getValue(String exprStr)
            throws IOException {
        HashMap<String, Integer> map = new HashMap<>(8);
        // 解析有几个参数要传递
        for (char ch : exprStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                // 解决重复参数的问题
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + ch + "的值:");
                    String in = (new BufferedReader(new InputStreamReader(
                            System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
