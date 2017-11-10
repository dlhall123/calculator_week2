package com.lmig.gfc.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;
import com.lmig.gfc.calculator.models.Results;

//Controller class for the Calculator application
@Controller
public class CalculatorController {
	// declare double variable to store the result of the calculation
	double result;

	// declare and instantiate an instance of the Calculator class
	private Calculator calc = new Calculator();

	// RequestMapping for when the user navigates to localhost:8080
	// Creates and instance of the ModelAndView class and returns it
	// Sets the view to calculator.html
	// adds the result and Calculator class instance to the ModelAndView
	@RequestMapping("/")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		clearHistory(); //Clear the history when navigating back to "/"
		memoryClear();  //Clear the memory when navigating back to "/"
		result = 0; //Set result = 0 when navigating back to "/"
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("calculator", calc);
		return mv;
	}

	// RequestMapping for when the form is submitted
	// Instantiates a ModelAndView instance to be returned
	// populates the result variable with the result from the Calculator class
	// instance
	// Creates a new instance of Results to store the information about the result
	// Calls a method on the Calculator class to add the result to history
	// sets view and adds appropriate data to the ModelAndView instance
	@RequestMapping("/calculate")
	public ModelAndView calculate(String op, double firstNumber, double secondNumber) {
		result = calc.calculate(op, firstNumber, secondNumber);
		Results resultAdd = new Results(firstNumber, secondNumber, result, op);
		calc.addResult(resultAdd);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("calculator", calc);
		return mv;
	}

	// RequestMapping to clear the ArrayList containing history
	@RequestMapping("/clear")
	public ModelAndView clearHistory() {
		calc.clearHistory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("calculator", calc);
		return mv;
	}

	// RequestMapping to add to the accumulated memory
	@RequestMapping("/memadd")
	public ModelAndView memoryAdd() {
		calc.addMemory(result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("calculator", calc);
		return mv;

	}

	// RequestMapping to subtract from the accumulated memory
	@RequestMapping("/memsub")
	public ModelAndView memorySub() {
		calc.removeMemory(result);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("calculator", calc);
		return mv;

	}

	// RequestMapping to clear the accumulated memory
	@RequestMapping("/memclear")
	public ModelAndView memoryClear() {
		calc.clearMemory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("calculator", calc);
		return mv;

	}

	// RequestMapping to recall the accumulated memory
	@RequestMapping("/memrecall")
	public ModelAndView memoryRecall() {
		result = calc.getMemory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
		mv.addObject("calculator", calc);
		return mv;

	}

}
