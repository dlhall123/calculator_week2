package com.lmig.gfc.calculator.models;

public class Results {
	private double firstNumber;
	private double secondNumber;
	private double result;
	private String op;
	public Results(double firstNumber, double secondNumber, double result, String op) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
		this.op = op;
	}
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
