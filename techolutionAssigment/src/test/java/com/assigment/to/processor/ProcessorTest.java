package com.assigment.to.processor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.assigment.to.exception.KnapshakException;

/**
 * @author tarunagarwal
 *
 */
public class ProcessorTest {

	int t= 20 ;
	int n =4;
	
	Integer[] satisfactionList = {15,35,50,65};
	Integer[] timeTakenList = {1,3,5,15};
	
	@Test
	public void testFindMaximumStatisfactionPossible() throws KnapshakException {
		assertEquals(115, Processor.findMaximumStatisfactionPossible(t, n, satisfactionList, timeTakenList));;
	}
	
	@Test(expected=KnapshakException.class)
	public void testFindMaximumStatisfactionPossibleException() throws KnapshakException {
		Processor.findMaximumStatisfactionPossible(t, n, satisfactionList, null);
	}

}
