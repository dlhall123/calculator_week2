package com.lmig.gfc.calculator.models;

import java.util.ArrayList;

//This class calculates the product of two numbers, based on the data received from the consumer (controller)
//this class also maintains a list of past results for the purpose of history tracking
public class Calculator {
	// Declare and ArrayList (type Results) to store the results history
	private ArrayList<Results> resultList;

	// Constructor - instantiate the resultsList variable to a new ArrayList
	public Calculator() {
		resultList = new ArrayList<Results>();
	}

	// calculates the result of the operation, and returns back the result
	// accepts the information input on the screen by the user from the controller
	// returns a double (result) to the controller to sent to the view to display;
	// type must be double in case of any decimals in the math
	// Switch statement sets the result variable to the correct result, based on
	// operator passed

	public double calculate(String op, double firstNumber, double secondNumber) {
		double result = 0;
		switch (op) {
		case "+":
			result = firstNumber + secondNumber;
			break;
		case "-":
			result = firstNumber - secondNumber;
			break;
		case "*":
			result = firstNumber * secondNumber;
			break;
		case "/":
			result = firstNumber / secondNumber;
			break;
		case "^":
			result = Math.pow(firstNumber, secondNumber);
			break;
		}

		return result;
	}

	// Method to get the list of past results
	// Collections (java.util) method is used to return the ArrayList contents in
	// reverse order
	public ArrayList<Results> getResultList() {
		return resultList;
	}

	// Method to add a result to the Results ArrayList, which keeps track of all
	// results
	//Adds result to the first index in the ArrayList (index 0)
	public void addResult(Results result) {
		resultList.add(0,result);

	}

	//Method to clear the ResultList Array, which cleats the history of calculations performed
	public void clearHistory() {
		resultList.clear();
	}

}
