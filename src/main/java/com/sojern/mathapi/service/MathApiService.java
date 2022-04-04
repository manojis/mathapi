/**
 * 
 */
package com.sojern.mathapi.service;

import java.util.List;

/**
 * @author Manoj
 *
 */

public interface MathApiService {
	
	List<Integer> getMin(List<Integer> input, int quantifier);
	List<Integer>  getMax(List<Integer> input, int quantifier);
	float getAvg(List<Integer> input);
	float getMedian(List<Integer> input);
	int getPercentile(List<Integer> input, int quantifier);
}
