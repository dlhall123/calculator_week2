package com.lmig.gfc.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;
import com.lmig.gfc.calculator.models.Results;

@Controller
public class CalculatorController {
	//declare double variable to store the result of the calculation
	double result;
	//declare and instantiate an instance of the Calculator class
	private Calculator calc = new Calculator();

	//RequestMapping for when the user navigates to localhost:8080
	//Creates and instance of the ModelAndView class and returns it
	//Sets the view to calculator.html
	//adds the result and calls a method to get the list of past results (will be empty when first run)
	@RequestMapping("/")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("resultList", calc.getResultList());
		return mv;
	}

	//RequestMapping for when the form is submitted
	//Instantiates a ModelAndView instance to be returned
	//populates the result variable with the result from the Calculator class instance
	//Creates a new instance of Results to store the information about the result
	//Calls a method on the Calculator class to add the result to history
	//sets view and adds appropriate data to the ModelAndView instance
	@RequestMapping("/calculate")
	public ModelAndView calculate(String op, double firstNumber, double secondNumber) {
		result = calc.calculate(op, firstNumber, secondNumber);
		Results resultAdd = new Results(firstNumber, secondNumber, result, op);
		calc.addResult(resultAdd);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("resultList", calc.getResultList());
		return mv;
	}
 
}
