package com.sojern.mathapi.model;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author Manoj
 *
 */

@Repository
public class Quant {
	
	public List<Integer> input;
	public Integer quantifier;
	
	/**
	 * @return the input
	 */
	public List<Integer> getInput() {
		return input;
	}
	/**
	 * @param input the input to set
	 */
	public void setInput(List<Integer> input) {
		this.input = input;
	}
	/**
	 * @return the quantifier
	 */
	public Integer getQuantifier() {
		return quantifier;
	}
	/**
	 * @param quantifier the quantifier to set
	 */
	public void setQuantifier(Integer quantifier) {
		this.quantifier = quantifier;
	}
}
