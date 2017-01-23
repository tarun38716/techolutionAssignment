package com.assigment.to;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.assigment.to.exception.KnapshakException;
import com.assigment.to.processor.Processor;
import com.assignment.to.data.ParsedData;
import com.assignment.to.filereader.InputFileReader;

/**
 * Springboot application to find the maximum statisfaction from input File
 * @author tarunagarwal
 *
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.assignment.to"})
public class TecholutionAssigmentApplication implements CommandLineRunner {
	
	@Autowired
	@Qualifier("inputFileReader")
	private InputFileReader inputFileReader;
	
	public static void main(String[] args) {
		SpringApplication.run(TecholutionAssigmentApplication.class, args);
	}

	@Override
	public void run(String... s){
		try{
			//Read data and assembling input for processor
			ParsedData parsedData = inputFileReader.readFile("data.txt");
			int n = parsedData.getN();
			int t = parsedData.getT();
			Integer[] satisfactionList = parsedData.getSatisfactionList().toArray(new Integer[n]);
			Integer[] timeTakenList = parsedData.getTimeTakenList().toArray(new Integer[n]);
			
			//Processor to find maximum satisfaction
			int result = Processor.findMaximumStatisfactionPossible(t, n, satisfactionList, timeTakenList);
			System.out.println("Maximum Satisfaction found from input data : " + result);
		} catch(KnapshakException e){
			System.err.println("Exception Occured while finding the maximum satisfaction");
			System.err.println("Exception " + e.getCause().getMessage());
		} 
		
	}
}
