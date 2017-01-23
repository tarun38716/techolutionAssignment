package com.assignment.to.filereader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.assigment.to.exception.KnapshakException;
import com.assignment.to.data.ParsedData;

/**
 * Class to read from file
 * @author tarunagarwal
 *
 */
@Component("inputFileReader")
public class InputFileReader {

	private ParsedData parsedData;

	/**
	 * Read Files and populate the data from List
	 * Assumption : Data is valid and in proper format
	 * @param filename Input Filename
	 * @return Parsed data
	 * @throws KnapshakException
	 */
	public ParsedData readFile(String filename) throws KnapshakException{
		parsedData = new ParsedData();
		List<Integer> satisfactionList = new ArrayList<Integer>();
		List<Integer> timeTakenList = new ArrayList<Integer>();
		String line = null;
		String splitArray[] = null;
		BufferedReader reader =null;
		Resource resource = new ClassPathResource(filename);
		try{
			//Reading the first record for total time t and total number of dishes n
			reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			line = reader.readLine();
			if(StringUtils.isNotBlank(line)){
				splitArray=line.split("\\s");
				parsedData.setT(Integer.parseInt(splitArray[0]));
				parsedData.setN(Integer.parseInt(splitArray[1]));
			}

			//Populating List of Satisfaction and time taken
			line =  reader.readLine();
			
			while(StringUtils.isNotBlank(line)){
				splitArray=line.split("\\s");
				satisfactionList.add(Integer.parseInt(splitArray[0]));
				timeTakenList.add(Integer.parseInt(splitArray[1]));
				line =  reader.readLine();
			}

			//Setting Data to Parsed Data Object
			parsedData.setSatisfactionList(satisfactionList);
			parsedData.setTimeTakenList(timeTakenList);

			return parsedData;

		} catch(Exception e){
			throw new KnapshakException(e);
		} finally {
			try{
				if(null!=reader){
					reader.close();
				}	
			}catch(Exception e){
				throw new KnapshakException(e);
			}
		}
	}
}
