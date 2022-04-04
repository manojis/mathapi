/**
 * 
 */
package com.sojern.mathapi.rest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sojern.mathapi.model.InputList;
import com.sojern.mathapi.model.Quant;
import com.sojern.mathapi.service.MathApiService;

/**
 * @author Manoj
 *
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class MathApiRestService {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	@Autowired
	MathApiService mathApiService;
	
	
	/**
	 * Get the first n min values
	 * @param quant
	 * @sample input data:
	 * { 
    		"input":[-1, 0, 2,4,8,5,9,7,1,12],
    		"quantifier": 4
    	}
	 * @return List<Integer>:  list of integers
	 */
	@Scope("request")
    @RequestMapping(value = "/min", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Integer>> getMinList (@RequestBody Quant quant) {
		
		boolean status = false;
		if (!quant.getInput().isEmpty() 
				|| quant.getQuantifier().equals(0) 
				|| quant.getQuantifier() > quant.getInput().size()) {
			status = true;
			
		}
		List<Integer> output = new ArrayList<>();
		if(!status) {
			output = mathApiService.getMin(quant.getInput(), quant.getQuantifier());
		}
		return new ResponseEntity<List<Integer>>(output, HttpStatus.OK);		
	}	
	
	/**
	 * Get the first n max values
	 * @param quant
	 * @sample input data:
	 * { 
    		"input":[-1, 0, 2,4,8,5,9,7,1,12],
    		"quantifier": 4
    	}
	 * @return List<Integer>:  list of integers
	 */
	@Scope("request")
    @RequestMapping(value = "/max", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Integer>> getMaxList (@RequestBody Quant quant) {
		
		boolean status = false;
		if (!quant.getInput().isEmpty() 
				|| quant.getQuantifier().equals(0) 
				|| quant.getQuantifier() > quant.getInput().size()) {
			status = true;
			
		}
		List<Integer> output = new ArrayList<>();
		if(!status) {
			output = mathApiService.getMax(quant.getInput(), quant.getQuantifier());	
		}		
		return new ResponseEntity<List<Integer>>(output, HttpStatus.OK);		
	}
	
	/**
	 * Get the average of a list of integers
	 * @param inputList
	 * @sample input data:
	 * { 
    		"input":[-1, 0, 2,4,8,5,9,7,1,12],
    	}
	 * @return Float
	 */
	@Scope("request")
    @RequestMapping(value = "/avg", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Float> getAverage (@RequestBody InputList inputList) {
		
		float output = 0;
		if (!inputList.getInput().isEmpty()) {
			output = mathApiService.getAvg(inputList.getInput());
		}
		return new ResponseEntity<Float>(Float.valueOf(df.format(output)), HttpStatus.OK);		
	}
	
	/**
	 * Get the average of a list of integers
	 * @param quant
	 * @sample input data:
	 * { 
    		"input":[-1, 0, 2,4,8,5,9,7,1,12],
    	}
	 * @return List<Integer>:  list of integers
	 */
	@Scope("request")
    @RequestMapping(value = "/median", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Float> getMedian (@RequestBody InputList inputList) {
		
		float output = 0;
		if (!inputList.getInput().isEmpty()) {
			output = mathApiService.getMedian(inputList.getInput());
		}		

		return new ResponseEntity<Float>(Float.valueOf(df.format(output)), HttpStatus.OK);		
	}
	
	/**
	 * Get the qth percentile from a list of integers
	 * @param quant
	 * @sample input data:
	 * { 
    		"input":[-1, 0, 2,4,8,5,9,7,1,12],
    		"quantifier": 95
    	}
	 * @return Integer
	 */
	@Scope("request")
    @RequestMapping(value = "/percentile", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getQthPercentile (@RequestBody Quant quant) {
		
		int output = mathApiService.getPercentile(quant.getInput(), quant.getQuantifier());
		return new ResponseEntity<Integer>(Integer.valueOf(output), HttpStatus.OK);		
	}	
}
