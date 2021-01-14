/* Bryan Bennett
CSC201 Fall 2020
Programming Assignment 1 – Part 1b
September 15, 2020
 */

/* Main Description: This program uses exprs.txt as an input, which contains postfix arithmetic expressions.
It reads in all operators and operands and creates an "expression" object using the expression class.
This object stores each individual expression and then evaluates it using a stack.
The loop in this main navigates each expression and individually evaluates them, printing the results with each iteration.
* */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Open file and create input file stream
        //NOTE: This did not work with the relative path. Each user must put full path below
        FileInputStream expressions = new FileInputStream("/Users/bryanbennett/IdeaProjects/Project1a_BryanBennett/src/exprs.txt");

        //Create scanner to read in text file
        Scanner scanner = new Scanner(expressions);

        //run loop until there are no more expressions in the txt file
        while (scanner.hasNextLine()) {

            //Create string that stores current line
            String currentLine = scanner.nextLine();

            //Create object "expression" that represents individual line in exprs.txt file
            Expression currentExpression = new Expression(currentLine);

            //Call evaluate method and store in "result"
            BigDecimal result = currentExpression.evaluate();

            //Print current expression and result
            System.out.println(currentLine + "\n" + " = " + result);
        }
    }
}

