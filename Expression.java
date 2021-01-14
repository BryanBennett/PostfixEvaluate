import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Stack;

public class Expression {

    // Declaring field variables
    private String currentExpression;

    //Default Constructor
    public Expression(String expression) {currentExpression = expression;}

    // Evaluate method, which uses a stack to navigate the expression and perform arithmetic.
    // I used BigDecimal here instead of double because double did not return the correct answer for expression 5
    // BigDecimal would also make this program more accurate for other sets of numbers
    public BigDecimal evaluate() {
        BigDecimal solution;
        BigDecimal tmpResult;
        //These are used for arithmetic in the if branches
        BigDecimal a; BigDecimal b;

        //Declare scanner for parsing expression
        Scanner scanner = new Scanner(currentExpression);

        //Initialize stack
        Stack<BigDecimal> expression = new Stack<BigDecimal>();

        //While there is another term in the expression...
        while(scanner.hasNext()){

            //Pull in next term and make it a string. Then look at first char to determine if its an operator or operand
            String currentTerm = scanner.next();
            char currentChar = currentTerm.charAt(0);

            if(Character.isDigit(currentChar)){
                BigDecimal currentBD = BigDecimal.valueOf(Double.parseDouble(currentTerm));
                expression.push(currentBD);
            }
            else if(currentChar == '/'){
                a = expression.pop(); b = expression.pop();
                tmpResult = b.divide(a, 10, RoundingMode.HALF_UP);
                expression.push(tmpResult);
            }
            else if(currentChar == '*'){
                a = expression.pop(); b = expression.pop();
                tmpResult = a.multiply(b);
                expression.push(tmpResult);
            }
            else if(currentChar == '-'){
                a = expression.pop(); b = expression.pop();
                tmpResult = b.subtract(a);
                expression.push(tmpResult);
            }
            else if(currentChar == '+'){
                a = expression.pop(); b = expression.pop();
                tmpResult = a.add(b);
                expression.push(tmpResult);
            }
            else{System.out.println("ERROR!! Exiting Program Now"); break;}
        }
        //Here I truncated the solution to 5 decimal places
        solution = expression.pop().setScale(5,RoundingMode.FLOOR);
        return solution;
    }
}
