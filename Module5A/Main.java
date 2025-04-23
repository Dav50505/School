import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Stack<Double> numberStack = new Stack<>();
    private static Stack<String> operatorStack = new Stack<>();

    public static void main(String[] args) {
        // Test code will go here
        String expression = "2 + 5 * ( 10 - 4 ) / 6";
        double result = evaluateExpression(expression);
        System.out.println("Final result: " + result);
    }

    public static double evaluateExpression(String expression) {
        Scanner scanner = new Scanner(expression);
        String token = getNextToken(scanner);
        
        while (token != null) {
            processToken(token);
            token = getNextToken(scanner);
        }
        
        while (!operatorStack.isEmpty()) {
            processOneOperation();
        }
        
        return numberStack.pop();
    }

    public static String getNextToken(Scanner scanner) {
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return null;
    }

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    public static boolean isParenthesis(String token) {
        return token.equals("(") || token.equals(")");
    }

    public static boolean isHighPrecedence(String token) {
        return token.equals("*") || token.equals("/");
    }

    public static boolean isLowPrecedence(String token) {
        return token.equals("+") || token.equals("-");
    }

    public static void processToken(String token) {
        if (isNumber(token)) {
            processNumber(token);
        } else if (isOperator(token)) {
            processOperator(token);
        } else if (isParenthesis(token)) {
            processParenthesis(token);
        }
    }

    public static void processNumber(String token) {
        double number = toNumber(token);
        numberStack.push(number);
        
        if (!operatorStack.isEmpty() && isHighPrecedence(operatorStack.peek())) {
            processOneOperation();
        }
    }

    public static void processOperator(String token) {
        if (isLowPrecedence(token) && !operatorStack.isEmpty() && !isParenthesis(operatorStack.peek())) {
            processOneOperation();
        }
        operatorStack.push(token);
    }

    public static void processParenthesis(String token) {
        if (token.equals("(")) {
            operatorStack.push(token);
        } else {
            while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                processOneOperation();
            }
            operatorStack.pop(); // Remove the opening parenthesis
        }
    }

    public static double toNumber(String token) {
        return Double.parseDouble(token);
    }

    public static void processOneOperation() {
        double rightOperand = numberStack.pop();
        double leftOperand = numberStack.pop();
        String operator = operatorStack.pop();
        
        double result = evaluateOperation(leftOperand, rightOperand, operator);
        numberStack.push(result);
    }

    public static double evaluateOperation(double left, double right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                System.out.println("!!! Invalid operator !!!");
                return 0.0;
        }
    }
}
