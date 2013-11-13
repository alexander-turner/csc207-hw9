/*
 * CSC-207 HW 9
 * Alex Turner '16
 * ---------
 * Problem 1
 * ---------
 * f0(n) = 2n-1
 * f1(n) = .5n(n+1)
 * f2(n) = c(n-1)+1
 * f3(n) = c(log(n)/log(2))+1
 * f4(n) = n(log(2n)/log(2))
 * f5(n) = c(log(2n)/log(2)) + n
 * f6(n) = c(2^n)+1 
 * I checked my answers on www.wolframalpha.com.
 * 
 * ---------
 * Problem 2
 * ---------
 */
package edu.grinnell.csc207.rpn;

import java.util.Scanner;
import java.util.Stack;

public class RPN {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Stack<Double> numbers = new Stack<Double>();
	// stackoverflow.com/questions/5287538/how-to-get-basic-user-input-for-java
	Scanner reader = new Scanner(System.in);
	char operator = 'c';
	double temp = 0;

	while (reader.hasNext()) {
	    // read in real numbers
	    if (reader.hasNextDouble()) {
		numbers.push(reader.nextDouble());
	    } else {
		// if the stack is empty, operator can't be applied to anything.
		if (numbers.empty()) {
		    continue;
		} // if

		operator = (char) reader.next(".").charAt(0);
		switch (operator) {
		case '+':
		    if (numbers.size() > 1) {
			numbers.push(numbers.pop() + numbers.pop());
		    } // if
		    break;
		case '-':
		    if (numbers.size() > 1) {
			temp = numbers.pop();
			numbers.push(numbers.pop() - temp);
		    } // if
		    break;
		case '*':
		    if (numbers.size() > 1) {
			numbers.push(numbers.pop() * numbers.pop());
		    } // if
		    break;
		case '/':
		    if (numbers.size() > 1) {
			temp = numbers.pop();
			numbers.push(numbers.pop() / temp);
		    } // if
		    break;
		// exponentiation
		case '^':
		    if (numbers.size() > 1) {
			temp = numbers.pop();
			numbers.push(Math.pow(numbers.pop(), temp));
		    } // if
		    break;
		// print the top element in the stack
		case 'p':
		    System.out.println(numbers.peek());
		    break;
		// print the stack
		case 's':
		    System.out.println(numbers.toString());
		    break;
		// clear the stack
		case 'c':
		    numbers.removeAllElements();
		    break;
		} // switch
	    } // if / else
	} // while
	reader.close();

    } // main(String[])

} // RPN
