package com.assignment.to.data;

import java.util.ArrayList;
import java.util.List;



/**
 * Parsed Data set object
 * @author tarunagarwal
 *
 */
public class ParsedData {

	//Given number of t minutes 
	private int t;
	//Number of Dishes in the Menu
	private int n;

	//List of data present in Data File
	private List<Integer> satisfactionList = new ArrayList<Integer>();
	private List<Integer> timeTakenList = new ArrayList<Integer>();
	
	/**
	 * @return the t
	 */
	public int getT() {
		return t;
	}
	/**
	 * @param t the t to set
	 */
	public void setT(int t) {
		this.t = t;
	}
	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}
	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}
	/**
	 * @return the satisfactionList
	 */
	public List<Integer> getSatisfactionList() {
		return satisfactionList;
	}
	/**
	 * @param satisfactionList the satisfactionList to set
	 */
	public void setSatisfactionList(List<Integer> satisfactionList) {
		this.satisfactionList = satisfactionList;
	}
	/**
	 * @return the timeTakenList
	 */
	public List<Integer> getTimeTakenList() {
		return timeTakenList;
	}
	/**
	 * @param timeTakenList the timeTakenList to set
	 */
	public void setTimeTakenList(List<Integer> timeTakenList) {
		this.timeTakenList = timeTakenList;
	}
}
