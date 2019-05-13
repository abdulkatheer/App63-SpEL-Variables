package org.katheer.test;

import org.katheer.bean.Calculator;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Client {
    public static void main(String[] args) {
        /*
        '#' is used to refer a variable in SpEL
         */
        ExpressionParser parser = new SpelExpressionParser();
        Calculator calculator = new Calculator();
        StandardEvaluationContext context =
                new StandardEvaluationContext(calculator);

        //creating variables and setting values
        context.setVariable("number1", 30);
        context.setVariable("number2", 20);

        System.out.println("num1    : " + calculator.getNum1());
        System.out.println("num2    : " + calculator.getNum2());

        //setting values to properties
        parser.parseExpression("num1 = #number1").getValue(context);
        parser.parseExpression("num2 = #number2").getValue(context);

        System.out.println("num1    : " + calculator.getNum1());
        System.out.println("num2    : " + calculator.getNum2());

        System.out.println("Add     : " + calculator.add());
        System.out.println("Sub     : " + calculator.sub());
        System.out.println("Mul     : " + calculator.mul());
        System.out.println("Div     : " + calculator.div());
    }
}
