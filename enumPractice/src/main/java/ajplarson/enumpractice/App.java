/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.enumpractice;

import java.math.BigDecimal;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) {
        BigDecimal math = new BigDecimal(PLUS, 1, 2);
    }

    public BigDecimal calculate(MathOperator operator, BigDecimal operand1, BigDecimal operand2) {
        switch (operator) {
            case PLUS:
                return operand1.add(operand2);
            case MINUS:
                return operand1.subtract(operand2);
            case MULTIPLY:
                return operand1.multiply(operand2);
            case DIVIDE:
                return operand1.divide(operand2);
            default:
                throw new UnsupportedOperationException();
        }
    }

    public enum MathOperator {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }
}
