package com.demo.test;

import com.demo.beans.Calculator;
import com.demo.exception.WrongOperatorException;

public class Main {

	public static void main(String[] args) {
		 int number1 = 20;
	        int number2 = 6;
	        String[] operators = {"+", "-", "*", "/", "%", "^"}; // ^ is invalid

	        for (String op : operators) {
	            try {
	                int result = Calculator.calculate(number1, number2, op);
	                System.out.println(number1 + " " + op + " " + number2 + " = " + result);
	            } catch (WrongOperatorException e) {
	                System.out.println("Error: " + e.getMessage());
	            } catch (ArithmeticException e) {
	                System.out.println("Math Error: " + e.getMessage());
	            }
	        }

	}

}
