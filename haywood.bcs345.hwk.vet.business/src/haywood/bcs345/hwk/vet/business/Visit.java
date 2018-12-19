package haywood.bcs345.hwk.vet.business;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class has functions to process data about a
 * client's visit.
 * 
 * @author Jeffrey Haywood
 * @since 11/04/2018
 * @version 2.0
 *
 */

public class Visit {
	
	private String m_vetName = "Default";
	private Appointment m_appointment = new Appointment();
	private VisitProcedure[] m_visitProcedure;
	
	/**
	 * This method is the Default constructor. Will set 
	 * each member variable to a default value.
	 */
	public Visit() {
		m_vetName = "Default";
		m_appointment = new Appointment();
		m_visitProcedure = new VisitProcedure[4];
		
		for (int i = 0; i < m_visitProcedure.length; i++)
		{
			m_visitProcedure[i] = new VisitProcedure();
		}
	}
	
	/**
	 * This method is the constructor that will accept
	 * given parameters. Will set 
	 * each member variable to given parameter value.
	 * 
	 * @param name Name of the veterinarian to be assigned
	 * @param appointment Appointment object to be assigned
	 * @param VisitProcedure[] Array of VisitProcedures
	 */
	/*public Visit(String vetName, Appointment appointment, VisitProcedure[] visitProcedure) {
		m_vetName = vetName;
		m_appointment = appointment;
		m_visitProcedure = visitProcedure;
		m_visitProcedure = new VisitProcedure[4];
		
		for (int i = 0; i < m_visitProcedure.length; i++)
		{
			m_visitProcedure[i] = new VisitProcedure();
			m_visitProcedure[i] = visitProcedure[i];
		}
	}*/
	
	/**
	 * This is the get method for the vet name.
	 * Will return name of the vet.
	 * 
	 * @return Name of the veterinarian
	 */
	public String GetName() { return m_vetName; }
	
	/**
	 * This is the set method for the vet name.
	 * Will set m_vetName variable to given String.
	 * 
	 * @param vetName name to be stored in m_vetName
	 */
	public void SetName(String vetName) { m_vetName = vetName; }
	
	/**
	 * This method will retrieve the name of the pet.
	 * 
	 * @return petName The name of the pet.
	 */
	public String GetPetName() {
		String petName = m_appointment.GetPet().GetName();
		return petName; 
	}
	
	/**
	 * This method will retrieve the species of the pet.
	 * 
	 * @return petSpecies The species of the pet.
	 */
	public String GetPetSpecies() {
		String petSpecies = m_appointment.GetPet().GetSpecies();
		return petSpecies;
	}
	
	/**
	 * This method will retrieve the gender of the pet.
	 * 
	 * @return petGender The gender of the pet.
	 */
	public String GetPetGender() {
		String petGender = m_appointment.GetPet().GetGender();
		return petGender;
	}
	
	/**
	 * This method will retrieve the total amount.
	 * 
	 * @return totalAmount The total amount of the visit.
	 */
	public double GetTotalAmount() {
		double totalAmount = 0;
		for (int i = 0; i < m_visitProcedure.length; i++)
		{	
			totalAmount += m_visitProcedure[i].CalculateProcedureAmount();
		}
		
		return totalAmount;
	}
	
	/**
	 * This method will retrieve the amount covered.
	 * 
	 * @return totalAmountCoverd The total amount of the visit.
	 */
	public double GetAmountCovered() {
		double totalAmountCovered = 0;
		for (int i = 0; i < m_visitProcedure.length; i++)
		{
			totalAmountCovered += m_visitProcedure[i].CalculateProcedureAmountCovered();
		}
		return totalAmountCovered;
	}
	
	/**
	 * This method will retrieve the amount due.
	 * 
	 * @return totalAmountDue The total amount due of the visit.
	 */
	public double GetAmountDue() {
		double totalAmountDue = this.GetTotalAmount() - this.GetAmountCovered();
		
		return totalAmountDue;
	}
	
	/**
	 * This method will retrieve the number of procedures.
	 * 
	 * @return numProcedures The total amount of procedures.
	 */
	public int GetNumProcedures() {
		int numProcedures = m_visitProcedure.length;
		
		return numProcedures;
	}
	
	/**
	 * This method will use a filescanner to read
	 * each line and store the data held on each line to
	 * the member variables of Visit.
	 * 
	 * @param inputFile Scanner object that data is being read from.
	 */
	public void Read(Scanner inputFile) {
		m_vetName = inputFile.nextLine();
		m_appointment.Read(inputFile);
		int numProcedures = inputFile.nextInt();
		inputFile.nextLine();
		m_visitProcedure = new VisitProcedure[numProcedures]; // maybe different way
		for(int i = 0; i < numProcedures; i++)
		{
			m_visitProcedure[i] = new VisitProcedure();
			m_visitProcedure[i].Read(inputFile);
		}
	}
	
	/**
	 * This method will use a printstream to write
	 * each member variable to a line of an output file.
	 * 
	 * @param outputFile printstream object that is writing data to file.
	 */
	public void Write(PrintStream outputFile) {
		outputFile.printf("%s\n", m_vetName);
		m_appointment.Write(outputFile);
		outputFile.printf("%d\n", m_visitProcedure.length);
		for (int i = 0; i < m_visitProcedure.length; i++)
		{
			m_visitProcedure[i].Write(outputFile);
		}
	}
	
	/**
	 * This method will use a printstream to write
	 * each member variable to a formatted output file.
	 * 
	 * @param reportFile printstream object that is writing data to file.
	 */
	public void Report(PrintStream reportFile) {
		reportFile.println("Pet Veterinarian Visit Report");
		reportFile.println("-----------------------------");
		reportFile.printf("Veterinarian: %-25s\n", m_vetName);
		reportFile.printf("Date        : %2d/%d/%d\n", m_appointment.GetMonth(), m_appointment.GetDay(), 
				m_appointment.GetYear());
		reportFile.printf("\n");
		reportFile.printf("Pet Name   : %-15s\n", m_appointment.GetPet().GetName());
		reportFile.printf("Pet Species: %-10s\n", m_appointment.GetPet().GetSpecies());
		reportFile.printf("Pet Gender : %-6s\n", m_appointment.GetPet().GetGender());
		reportFile.printf("\n");
		reportFile.printf("Procedures: %-3d\n", m_visitProcedure.length);
		reportFile.printf("\n");
		reportFile.printf("Name                       Price   Qty    Amount   Is Covered    Pct Covered    "
				+ "Amount Covered    Amount Due\n");
		reportFile.printf("----                       -----   ---    ------   ----------    -----------    "
				+ "--------------    ----------\n");
		
		double totalAmount = 0, totalAmountCovered = 0, totalAmountDue = 0;
		
		for (int i = 0; i < m_visitProcedure.length; i++)
		{
			reportFile.printf("%-25s%7.2f%6.1f%10.2f%13b%15.2f%18.2f%14.2f\n", m_visitProcedure[i].GetProcedure().GetName(),
					m_visitProcedure[i].GetProcedure().GetPrice(), m_visitProcedure[i].GetQuantity(),
					m_visitProcedure[i].CalculateProcedureAmount(), m_visitProcedure[i].GetIsCovered(),
					m_visitProcedure[i].GetPctCovered(), m_visitProcedure[i].CalculateProcedureAmountCovered(),
					m_visitProcedure[i].CalculateProcedureAmountDue());
			
			totalAmount += m_visitProcedure[i].CalculateProcedureAmount();
			totalAmountCovered += m_visitProcedure[i].CalculateProcedureAmountCovered();
			totalAmountDue += m_visitProcedure[i].CalculateProcedureAmountDue();
		}
		reportFile.printf("----                       -----   ---    ------   ----------    -----------    "
				+ "--------------    ----------\n");
		reportFile.printf("Total%43.2f%46.2f%14.2f\n", totalAmount, totalAmountCovered, totalAmountDue);
	}
	
	/**
	 * This method concatenates the member variables 
	 * into a JSON formatted string.
	 * 
	 * @return visitJSON which holds a JSON formatted string.
	 */
	public String GetJSON() {
		String visitJSON = "{\n\t\"m_vetName\" : \"" + m_vetName + "\",\n\t\"m_appointment\" : \n\t"
				+ m_appointment.GetJSON() + ",\n\t\"m_visitProcedure\" : \n\t[\n";
		
		for(int i = 0; i < m_visitProcedure.length; i++)
		{
			visitJSON += m_visitProcedure[i].GetJSON();
			
			if(i != m_visitProcedure.length - 1)
			{
				visitJSON += ",";
			}
			
			visitJSON += "\n";
		}
		
		visitJSON += "\t]\n}";
		
		return visitJSON;
	}
	
	/**
	 * This method will override the toString method to 
	 * return a formatted string showing the member variables.
	 * 
	 * returns s A string holding the formatted string.
	 */
	@Override public String toString() {
		String s = "\nVeterinarian: " + m_vetName + "\n" + m_appointment.toString() + "\n";
		
		for(int i = 0; i < m_visitProcedure.length; i++)
		{
			s += m_visitProcedure[i].toString() + "\n";
		}
		
		return s;
	}
	
	/**
	 * This method will return the VisitProcedure
	 * at the given index.
	 * 
	 * @param index Specifies which index of the array.
	 * @return the VisitProcedure at the index given.
	 */
	public VisitProcedure GetByIndex(int index) throws ArrayIndexOutOfBoundsException {
		if (index > m_visitProcedure.length)
		{
			ArrayIndexOutOfBoundsException aioobe;
			aioobe = new ArrayIndexOutOfBoundsException();
			throw aioobe;
		}
		
		return m_visitProcedure[index];
	}
	
	/**
	 * This method will search the array of VisitProcedures
	 * and display the visit procedure with the highest amount
	 * of money due.
	 * 
	 * @return the m_visitProcedure element with the highest amount due
	 */
	public VisitProcedure GetHighestProcedureAmountDue() {
		//VisitProcedure highestAmtDue = new VisitProcedure();
		VisitProcedure highestAmtDue = m_visitProcedure[0];
		
		for (int i = 0; i < m_visitProcedure.length; i++)
		{
			if(highestAmtDue.CalculateProcedureAmount() < m_visitProcedure[i].CalculateProcedureAmountDue())
			{
				highestAmtDue = m_visitProcedure[i];
			}
		}
		
		return highestAmtDue;
	}
}
