package com.lmig.gfc.calculator.models;

import java.util.ArrayList;

public class Calculator {
	ArrayList<Results> resultList;
	//calculates the result of the operation, and returns back the result
	public double calculate(String op, double firstNumber, double secondNumber) {
		double result = 0;
		if(op.equals("add")){
			result = firstNumber + secondNumber;
		}
		if(op.equals("subtract")) {
			result = firstNumber - secondNumber;
		}
		if(op.equals("multiply")){
			result = firstNumber * secondNumber;
		}
		if(op.equals("divide")) {
			result = firstNumber / secondNumber;
		}
		if(op.equals("exponent")) {
			result = Math.pow(firstNumber, secondNumber);
		}
		return result;
	}
	public ArrayList<Results> getResultList() {
		return resultList;
	}
	

}
