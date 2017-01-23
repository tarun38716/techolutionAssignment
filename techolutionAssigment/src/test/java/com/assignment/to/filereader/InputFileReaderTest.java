package com.assignment.to.filereader;

import static org.junit.Assert.*;

import org.junit.Test;

import com.assigment.to.exception.KnapshakException;
import com.assignment.to.data.ParsedData;

/**
 * @author tarunagarwal
 *
 */
public class InputFileReaderTest {
	
	private InputFileReader inputFileReader = new InputFileReader();

	@Test(expected = KnapshakException.class)
	public void testReadFileException() throws KnapshakException {
		inputFileReader.readFile("datawithWrong.txt");
	}
	
	@Test
	public void testReadFile() throws KnapshakException{
		assertNotNull(inputFileReader.readFile("data.txt"));
	}
	
	@Test
	public void testReadFileDataPopulated() throws KnapshakException{
		ParsedData data = inputFileReader.readFile("data.txt"); 
		assertNotNull(data.getN());
		assertNotNull(data.getT());
		assertNotNull(data.getTimeTakenList());
		assertNotNull(data.getSatisfactionList());
	}
	
	@Test
	public void testReadFileListhasvalues() throws KnapshakException {
		ParsedData data = inputFileReader.readFile("data.txt");
		assertTrue(data.getN() == data.getTimeTakenList().size());
		assertTrue(data.getN() == data.getSatisfactionList().size());
	}

}
