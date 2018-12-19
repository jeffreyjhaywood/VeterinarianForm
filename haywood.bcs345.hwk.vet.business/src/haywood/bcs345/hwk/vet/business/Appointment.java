package haywood.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains member variables and methods for the Appointment class.
 * If an instance is called will create an Appointment object.
 * Accepts parameters to set Appointment month, day, price, and Pet object, 
 * read an input file containing Appointment data, write member variables to an output
 * file. Can create a JSON formatted string if method is called.
 * 
 * 
 * @author Jeffrey Haywood
 * @version 1.0
 * @since 10/12/2018
 *
 */
public class Appointment {
	
	private int m_month = 1;
	private int m_day = 1;
	private int m_year = 1990;
	private Pet m_pet = new Pet();
	
	/**
	 * This method is the Default constructor. Will set 
	 * each member variable to a default value.
	 */
	public Appointment() {
		m_month = 1;
		m_day = 1;
		m_year = 1990;
		m_pet = new Pet();
	}
	
	public Appointment(int month, int day, int year, Pet pet) {
		m_month = month;
		m_day = day;
		m_year = year;
		m_pet = pet; // probs null pointer
	}
	
	/**
	 * This is the get method for m_month
	 * Will return the month
	 * 
	 * @return The month of appointment
	 */
	public int GetMonth() { return m_month; }
	
	/**
	 * This is the get method for m_day
	 * Will return the day
	 * 
	 * @return The day of appointment
	 */
	public int GetDay() { return m_day; }
	
	/**
	 * This is the get method for m_year
	 * Will return the year
	 * 
	 * @return The year of appointment
	 */
	public int GetYear() { return m_year; }
	
	/**
	 * Get method for m_pet
	 * 
	 * @return The pet object
	 */
	public Pet GetPet() { return m_pet; }
	
	/**
	 * This is the set method for the month.
	 * Will set m_month member variable to given integer.
	 * 
	 * @param month Integer to be stored in m_month.
	 */
	public void SetMonth(int month) { m_month = month; }
	
	/**
	 * This is the set method for the day.
	 * Will set m_day member variable to given integer.
	 * 
	 * @param day Integer to be stored in m_day.
	 */
	public void SetDay(int day) { m_day = day; }
	
	/**
	 * This is the set method for the year.
	 * Will set m_year member variable to given integer.
	 * 
	 * @param year Integer to be stored in m_year.
	 */
	public void SetYear(int year) { m_year = year; }
	
	/**
	 * Set method for m_pet
	 * Will set m_pet member variable to given pet object.
	 * 
	 * @param pet Pet object to be stored in m_pet
	 */
	public void SetPet(Pet pet){m_pet = pet; }
	
	/**
	 * This method will use a filescanner to read
	 * each line and store the data held on each line to
	 * the member variables of Appointment.
	 * 
	 * @param inputFile Scanner object that data is being read from.
	 */
	public void Read(Scanner inputFile) {
		
		m_month = inputFile.nextInt();
		m_day = inputFile.nextInt();
		m_year = inputFile.nextInt();
		inputFile.nextLine();
		m_pet.Read(inputFile);
		//m_pet.SetName(inputFile.nextLine());
		//m_pet.SetSpecies(inputFile.nextLine());
		//m_pet.SetGender(inputFile.nextLine());
		
	}
	
	/**
	 * This method will use a printstream to write
	 * each member variable to a line of an output file.
	 * 
	 * @param outputFile printstream object that is writing data to file.
	 */
	public void Write(PrintStream outputFile) {
		outputFile.printf("%d\n%d\n%d\n%s\n%s\n%s\n", m_month, m_day, m_year, m_pet.GetName(), 
				m_pet.GetSpecies(), m_pet.GetGender());
	}
	
	/**
	 * This method concatenates the member variables 
	 * into a JSON formatted string.
	 * 
	 * @return vpJSON which holds a JSON formatted string.
	 */
	public String GetJSON() {
		String appJSON = "{\n\t\t\"m_month\" : " + m_month + ",\n\t\t\"m_day\" : " + m_day + ",\n\t\t\"m_year\" : " +
				m_year + ",\n\t\t\"pet\" : \n" + m_pet.GetJSON() + "\n\t}";
		
		return appJSON;
	}
	
	/**
	 * This method will override the toString method to 
	 * return a formatted string showing the member variables.
	 * 
	 * returns s A string holding the formatted string.
	 */
	@Override public String toString() {
		String s = "Date: " + m_month + "/" + m_day + "/" + m_year + "\n" + m_pet.toString();
		
		return s;
	}

}
