package com.lmig.gfc.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;

//Controller class for the Calculator application
@Controller
public class CalculatorController {

	// declare and instantiate an instance of the Calculator class
	private Calculator calc = new Calculator();

	// RequestMapping for when the user navigates to localhost:8080
	// Creates and instance of the ModelAndView class and returns it
	// Sets the view to calculator.html
	// adds the result and Calculator class instance to the ModelAndView
	@RequestMapping("/")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		clearHistory(); // Clear the history when navigating back to "/"
		memoryClear(); // Clear the memory when navigating to "/"
		mv.setViewName("calculator");
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
	public ModelAndView calculateTwo(String op, double firstNumber, double secondNumber) {
		calc.calculate(op, firstNumber, secondNumber);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("calculator", calc);
		return mv;
	}

	// RequestMapping to clear the ArrayList containing history
	@RequestMapping("/clear")
	public ModelAndView clearHistory() {
		calc.clearHistory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("calculator", calc);
		return mv;
	}

	// RequestMapping to add to the accumulated memory
	@RequestMapping("/memAdd")
	public ModelAndView memoryAdd() {
		calc.addMemory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("calculator", calc);
		return mv;

	}

	// RequestMapping to subtract from the accumulated memory
	@RequestMapping("/memSub")
	public ModelAndView memorySub() {
		calc.removeMemory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("calculator", calc);
		return mv;

	}

	// RequestMapping to clear the accumulated memory
	@RequestMapping("/memClear")
	public ModelAndView memoryClear() {
		calc.clearMemory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("calculator", calc);
		return mv;

	}

	// RequestMapping to recall the accumulated memory
	@RequestMapping("/memRecall")
	public ModelAndView memoryRecall() {
		calc.getMemory();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("calculator", calc);
		return mv;

	}

}
