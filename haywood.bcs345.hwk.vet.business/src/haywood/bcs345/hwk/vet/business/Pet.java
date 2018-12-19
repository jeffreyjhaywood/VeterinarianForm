package haywood.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains member variables and methods for the Pet class.
 * If an instance in Main is called will create a Pet object.
 * Accepts parameters to set Pet name and price, read an input
 * file containing pet data, write member variables to an output
 * file. Can create a JSON formatted string if method is called.
 * 
 * 
 * @author Jeffrey Haywood
 * @version 1.0
 * @since 9/25/2018
 *
 */

public class Pet {
	
	private String m_name;
	private String m_species;
	private String m_gender;
	
	/**
	 * This method is the Default constructor. Will set 
	 * each member variable to a default value.
	 */
	public Pet() {
		m_name = "Default";
		m_species = "Default";
		m_gender = "Default";
	}
	
	/**
	 * This method is the Copy constructor. Will set 
	 * each member variable to given parameter value.
	 * 
	 * @param name Name of pet to be assigned.
	 * @param gender Gender of pet to be assigned.
	 * @param species Species of pet to be assigned.
	 */
	public Pet(String name, String gender, String species) {
		m_name = name;
		m_species = species;
		m_gender = gender;
	}
	
	/**
	 * This is the get method for the pet name.
	 * Will return the name of the pet.
	 * 
	 * @return The name of the pet.
	 */
	public String GetName() { return m_name; }
	
	/**
	 * This is the get method for the pet species.
	 * Will return the species of the pet.
	 * 
	 * @return The species of the pet.
	 */
	public String GetSpecies() { return m_species; }
	
	/**
	 * This is the get method for the pet gender.
	 * Will return the gender of the pet.
	 * 
	 * @return The gender of the pet.
	 */
	public String GetGender() { return m_gender; }
	
	/**
	 * This is the set method for the pet name.
	 * Will set m_name member variable to given string.
	 * 
	 * @param name String to be stored in m_name.
	 */
	public void SetName(String name) { m_name = name; }
	
	/**
	 * This is the set method for the pet species.
	 * Will set m_species member variable to given string.
	 * 
	 * @param species to be stored in m_species.
	 */
	public void SetSpecies(String species) { m_species = species; }
	
	/**
	 * This is the set method for the pet gender.
	 * Will set m_gender member variable to given string.
	 * 
	 * @param gender Gender to be stored in m_gender.
	 */
	public void SetGender(String gender) { m_gender = gender; }
	
	/**
	 * This method will use a filescanner to read
	 * each line and store the data held on each line to
	 * the member variables of Pet.
	 * 
	 * @param inputFile Scanner object that data is being read from.
	 */
	public void Read(Scanner inputFile) {
		// Read contents of given file
		m_name = inputFile.nextLine();
		m_species = inputFile.nextLine();
		m_gender = inputFile.nextLine();
	}
	
	/**
	 * This method will use a printstream to write
	 * each member variable to a line of an output file.
	 * 
	 * @param outputFile printstream object that is writing data to file.
	 */
	public void Write(PrintStream outputFile) {
		// Write member variables to given printstream
		outputFile.printf("%s\n%s\n%s\n", m_name, m_species, m_gender);
	}
	
	/**
	 * This method concatenates the member variables 
	 * into a JSON formatted string.
	 * 
	 * @return petJSON which holds a JSON formatted string.
	 */
	public String GetJSON() {
		// Return a string using JSON format using member variables
		String petJSON = "\t\t{\n\t\t\t\"m_name\" : \"" + m_name + "\",\n\t\t\t\"m_species\" : \"" + m_species + 
				"\",\n\t\t\t\"m_gender\" : \"" + m_gender + "\"\n\t\t}";
		
		return petJSON;
	}
	
	/**
	 * This method will override the toString method to 
	 * return a formatted string showing the member variables.
	 * 
	 * returns s A string holding the formatted string.
	 */
	@Override public String toString() {
		// Return string instance, not print on screen.
		String s = "Name: " + m_name + "\n" + "Species: " + m_species + "\n" + "Gender: " + m_gender + "\n";
		
		return s;
	}

}
