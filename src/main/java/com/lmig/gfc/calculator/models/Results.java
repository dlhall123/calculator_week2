package com.lmig.gfc.calculator.models;

//Class to house the results of calculations performed
public class Results {
	// class-level variables to house calculation results data
	private double firstNumber;
	private double secondNumber;
	private double result;
	private String op;

	// Constructor, which takes in the various pieces of the calculation and stores
	// them in class-level variables
	public Results(double firstNumber, double secondNumber, double result, String op) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
		this.op = op;
	}

	// Getters
	public double getFirstNumber() {
		return firstNumber;
	}

	public double getSecondNumber() {
		return secondNumber;
	}

	public String getOp() {
		return op;
	}

	public double getResult() {
		return result;
	}

}
