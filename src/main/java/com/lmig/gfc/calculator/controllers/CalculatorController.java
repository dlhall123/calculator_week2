package com.lmig.gfc.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;
//import com.lmig.gfc.calculator.models.Results;

@Controller
public class CalculatorController {
	double result;
	private Calculator calc = new Calculator();
	public CalculatorController() {
		
	}

	@RequestMapping("/")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
//		mv.addObject("resultList", calc.getResultList());
		return mv;
	}

	@RequestMapping("/calculate")
	public ModelAndView calculate(String op, double firstNumber, double secondNumber) {
		result = calc.calculate(op, firstNumber, secondNumber);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		mv.addObject("result", result);
//		mv.addObject("resultList", calc.getResultList());
		return mv;
	}

}
