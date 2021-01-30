package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;
@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
		throw new UnsuportedMathOperationException("Por favor defina um valor numerico!");
		}
		
		
		return math.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));	
	}
	
	

	@RequestMapping(value="/sub/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numeroUm") String numeroUm,@PathVariable("numeroDois") String numeroDois ) throws Exception{
		if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico!");
		}
		
		return math.sub(NumberConverter.convertToDouble(numeroUm),NumberConverter.convertToDouble(numeroDois));	
		
	}
	
	@RequestMapping(value="/mult/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numeroUm") String numeroUm,@PathVariable("numeroDois") String numeroDois ) throws Exception{
		if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico!");
		}
		return math.mult(NumberConverter.convertToDouble(numeroUm),NumberConverter.convertToDouble(numeroDois));	
		
	}
	
	@RequestMapping(value="/div/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double div(@PathVariable("numeroUm") String numeroUm,@PathVariable("numeroDois") String numeroDois ) throws Exception{
		if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico!");
		}
		return math.div(NumberConverter.convertToDouble(numeroUm),NumberConverter.convertToDouble(numeroDois));	
		
	}
	
	@RequestMapping(value="/media/{numeroUm}/{numeroDois}", method=RequestMethod.GET)
	public Double media(@PathVariable("numeroUm") String numeroUm,@PathVariable("numeroDois") String numeroDois ) throws Exception{
		if(!NumberConverter.isNumeric(numeroUm) || !NumberConverter.isNumeric(numeroDois)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico!");
		}
		return math.media(NumberConverter.convertToDouble(numeroUm),NumberConverter.convertToDouble(numeroDois));	
		
	}
	
	@RequestMapping(value="/raiz/{numero}", method=RequestMethod.GET)
	public Double raiz(@PathVariable("numero") String numero ) throws Exception{
		if(!NumberConverter.isNumeric(numero)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico!");
		}
		Double raiz = Math.sqrt(NumberConverter.convertToDouble(numero));
		return raiz;
		
	}
	

	

}

