package com.lmig.gfc.calculator.models;

import java.util.ArrayList;

//This class calculates the product of two numbers, based on the data received from the consumer (controller)
//this class also maintains a list of past results for the purpose of history tracking
public class Calculator {
	// Declare and ArrayList (type Results) to store the results history
	private ArrayList<Results> resultList;
	// variable to hold the memory for the calculator
	private double memory;
	// variable to hold the calculated result
	double result;

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
	// creates a new instance of the Results class and passes to the addResult
	// method
	//This method calculates the product of two numbers

	public void calculate(String op, double firstNumber, double secondNumber) {
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
		addResult(new Results(firstNumber, secondNumber, result, op));
	}
	
	//This method calculates the product of one number
	public void calculate(String op, double firstNumber) {
		switch (op) {
		case "sin":
			result = Math.sin(firstNumber);
			break;
		case "cos":
			result = Math.cos(firstNumber);
			break;
		case "tan":
			result = Math.tan(firstNumber);
			break;
		}
		addResult(new Results(firstNumber, 0, result, op));
	}

	// Method to add a result to the Results ArrayList, which keeps track of all
	// results
	// Adds result to the first index in the ArrayList (index 0)
	public void addResult(Results result) {
		resultList.add(0, result);

	}

	// Method to clear the ResultList Array, which clears the history of
	// calculations performed
	public void clearHistory() {
		resultList.clear();
	}

	// Adds the last calculated result to the memory
	public void addMemory() {
		memory += result;
	}

	// Removes last calculated result from the memory
	public void removeMemory() {
		memory -= result;
	}

	// Clears the Accumulated memory
	public void clearMemory() {
		memory = 0;
	}

	// method which gets the current value stored in Memory, and sets it to the
	// result, so the user can see the current amount in memory
	public void getMemory() {
		result = memory;
	}

}
