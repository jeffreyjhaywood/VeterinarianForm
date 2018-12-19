package haywood.bcs345.hwk.vet.business;

import java.io.PrintStream;


/**
 * Contains member variables and methods for the Procedure class.
 * If an instance in Main is called will create a Procedure object.
 * Accepts parameters to set Procedure name and price, read an input
 * file containing procedure data, write member variables to an output
 * file. Can create a JSON formatted string if method is called.
 * 
 * 
 * @author Jeffrey Haywood
 * @version 1.0
 * @since 9/25/2018
 *
 */

import java.util.Scanner;

public class Procedure {
	
	private String m_name;
	private double m_price;
	
	/**
	 * This method is the Default constructor. Will set 
	 * each member variable to a default value.
	 */
	public Procedure() {
		m_name = "Default";
		m_price = 0.0;
	}
	
	/**
	 * This method is the constructor that will accept
	 * given parameters. Will set 
	 * each member variable to given parameter value.
	 * 
	 * @param name Name of procedure to be assigned.
	 * @param price Price of procedure to be assigned.
	 */
	public Procedure(String name, double price) {
		m_name = name;
		m_price = price;
	}
	
	/**
	 * This is the get method for the procedure name.
	 * Will return the name of the procedure.
	 * 
	 * @return The name of the procedure.
	 */
	public String GetName() { return m_name; }
	
	/**
	 * This is the get method for the procedure price.
	 * Will return the price of the procedure.
	 * 
	 * @return The price of the procedure.
	 */
	public double GetPrice() { return m_price; }
	
	/**
	 * This is the set method for the procedure name.
	 * Will set m_name member variable to given string.
	 * 
	 * @param name String to be stored in m_name.
	 */
	public void SetName(String name) { m_name = name; }
	
	/**
	 * This is the set method for the procedure price.
	 * Will set m_price member variable to given double.
	 * 
	 * @param price Value to be stored in m_price.
	 */
	public void SetPrice(double price) { m_price = price; }
	
	/**
	 * This method will use a filescanner to read
	 * each line and store the data held on each line to
	 * the member variables of Procedure.
	 * 
	 * @param inputFile Scanner object that data is being read from.
	 */
	public void Read(Scanner inputFile) {
		// Read contents of given scanner
		m_name = inputFile.nextLine();
		m_price = inputFile.nextDouble();
		//inputFile.nextLine();
		// eof check true:chomp false:don't do it
	}
	
	/**
	 * This method will use a printstream to write
	 * each member variable to a line of an output file.
	 * 
	 * @param outputFile printstream object that is writing data to file.
	 */
	public void Write(PrintStream outputFile) {
		// Write member variables to given printstream
		outputFile.printf("%s\n%.2f\n", m_name, m_price);
	}
	
	/**
	 * This method concatenates the member variables 
	 * into a JSON formatted string.
	 * 
	 * @return procJSON which holds a JSON formatted string.
	 */
	public String GetJSON() {
		// Return a string using JSON format
		String procJSON = "\t\t\t{\n\t\t\t\t\"m_name\" : \"" + m_name + "\",\n\t\t\t\t\"m_price\" : " + m_price 
				+ "\n\t\t\t}";
		
		return procJSON;
	}
	
	/**
	 * This method will override the toString method to 
	 * return a formatted string showing the member variables.
	 * 
	 * returns s A string holding the formatted string.
	 */
	@Override public String toString() {
		String s = "Name: " + m_name + "\n" + "Price: $" + m_price;
		
		return s;
	}
	
}
