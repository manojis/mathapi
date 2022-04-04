/**
 * 
 */
package com.sojern.mathapi.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * @author Manoj
 *
 */

@Service
public class MathApiServiceImpl implements MathApiService{
	
	@Override
	public List<Integer> getMin(List<Integer> input, int quantifier) {
		
		List<Integer> minList = input.stream().sorted()
				.limit(quantifier).collect(Collectors.toList());
		return minList;		
	}
	
	@Override
	public List<Integer>  getMax(List<Integer> input, int quantifier) {
		List<Integer> maxList = input.stream().sorted(Comparator.reverseOrder())
				.limit(quantifier).collect(Collectors.toList());
		return maxList;		
	}
	
	@Override
	public float getAvg(List<Integer> input) {
		float avg = (input.stream().reduce(0, (x,y) -> x + y))/(float)input.size();
		return avg;
	}
	
	@Override
	public float getMedian(List<Integer> input) {
		
		float median = 0;
		int denom = input.size() % 2;
		int[] arrInput = input.stream().sorted().mapToInt(i -> i).toArray();
		if (denom == 0)
		    median = (float) ((arrInput[arrInput.length/2] + arrInput[arrInput.length/2 - 1]) / 2.0);
		else
		    median = arrInput[arrInput.length/2];
		
		return median;		
	}
	
	@Override
	public int getPercentile(List<Integer> input, int quantifier) {
		
		/**
		 *  based on wikipedia, 
		 *  formula: n = ceiling((P / 100) x N) 
		 *  where, N is list length and n ordinal rank and p percentile or quantifier here.
		*/
		
		List<Integer> sortedList = input.stream().sorted().collect(Collectors.toList());

		int index = (int) Math.ceil(quantifier / 100.00 * (sortedList.size()));
		return sortedList.get(index -1);
	}
}
