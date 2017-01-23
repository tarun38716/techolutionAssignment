package com.assigment.to.processor;

import com.assigment.to.exception.KnapshakException;

/**
 * Processor class to find the maximum satisfaction by using dynamic programming approach
 * @author tarunagarwal
 *
 */
public class Processor {
	
	public static int findMaximumStatisfactionPossible(int t,int n , Integer satisfactionList[], Integer timeTakenList[]) throws KnapshakException{
		try{
			int K[][] = new int[n + 1][t + 1];

			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= t; j++) {
					if (i == 0 || j == 0)
						K[i][j] = 0;
					else if (timeTakenList[i - 1] <= j)
						K[i][j] = Math.max(satisfactionList[i - 1] + K[i - 1][j - timeTakenList[i - 1]], K[i - 1][j]);
					else
						K[i][j] = K[i - 1][j];
				}
			}
			return K[n][t];
		}catch(Exception e){
			throw new KnapshakException(e);
		}
		
	}
}
