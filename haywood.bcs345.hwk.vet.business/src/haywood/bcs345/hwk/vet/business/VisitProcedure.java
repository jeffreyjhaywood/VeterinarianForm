package haywood.bcs345.hwk.vet.business;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains member variables and methods for the VisitProcedure class.
 * If an instance is called will create a VisitProcedure object.
 * Accepts parameters to set VisitProcedure procedure object, quantity,
 * isCovered and pctCoverd, read an input file containing visit procedure data, 
 * write member variables to an output file. Can create a JSON formatted 
 * string if method is called.
 * 
 * 
 * @author Jeffrey Haywood
 * @version 1.0
 * @since 10/10/2018
 *
 */

public class VisitProcedure {
	
	private Procedure m_procedure = new Procedure();
	private double m_quantity = 0;
	private boolean m_isCovered = true;
	private double m_pctCovered = 0;
	
	/**
	 * Default constructor for the Visit Procedure
	 * class.
	 */
	public VisitProcedure(){
		m_procedure = new Procedure();
		m_quantity = 0;
		m_isCovered = true;
		m_pctCovered = 0;
	}
	
	/**
	 * This method is the constructor that will accept
	 * given parameters. Will set 
	 * each member variable to given parameter value.
	 * 
	 * @param procedure Name of the procedure object to be assigned
	 * @param quantity Amount of procedures
	 * @param isCovered If covered by insurance or not
	 * @param pctCovered Amount covered by insurance
	 */
	public VisitProcedure(Procedure procedure, double quantity, boolean isCovered, double pctCovered) {
		m_procedure = procedure;
		m_quantity = quantity;
		m_isCovered = isCovered;
		m_pctCovered = pctCovered;
	}
	
	/**
	 * Get method for m_procedure
	 * 
	 * @return The procedure object
	 */
	public Procedure GetProcedure() { return m_procedure; }
	
	/**
	 * Get method for m_quantity
	 * 
	 * @return The quantity of procedures
	 */
	public double GetQuantity() { return m_quantity; }
	
	/**
	 * Get method for m_isCovered
	 * 
	 * @return True if insurance is coverd, false if not
	 */
	public boolean GetIsCovered() { return m_isCovered; }
	
	/**
	 * Get method for m_pctCoverd
	 * 
	 * @return The percent insurance will cover
	 */
	public double GetPctCovered() { return m_pctCovered; }
	
	/**
	 * Set method for m_procedure
	 * Will set m_procedure member variable to given procedure object.
	 * 
	 * @param procedure Procedure object to be stored in m_procedure
	 */
	public void SetProcedure(Procedure procedure) { m_procedure = procedure; }
	
	/**
	 * Set method for m_quantity
	 * Will set m_quantity member variable to given double.
	 * 
	 * @param quantity Amount to be stored in m_quantity
	 */
	public void SetQuantity(double quantity) { m_quantity = quantity; }
	
	/**
	 * Set method for m_isCovered
	 * Will set m_isCovered member variable to given boolean.
	 * 
	 * @param isCovered value to be stored in m_isCovered
	 */
	public void SetIsCovered(boolean isCovered) { m_isCovered = isCovered; }
	
	/**
	 * Set method for m_pctCovered
	 * Will set m_pctCovered member variable to given double.
	 * 
	 * @param pctCovered Value to be stored in m_pctCovered
	 */
	public void SetPctCovered(double pctCovered) { m_pctCovered = pctCovered; }
	
	/**
	 * This method will multiply the price of the procedure
	 * by the number of procedures performed
	 * 
	 * @return Product of procedure price by quantity
	 */
	public double CalculateProcedureAmount() {
		
		double total = 0;
		total = m_procedure.GetPrice() * m_quantity;
		
		return total;
	}
	
	/**
	 * Determines if the procedure is covered by insurance
	 * then calculates the amount covered based on the 
	 * percent covered.
	 * 
	 * @return The dollar amount covered by insurance
	 */
	public double CalculateProcedureAmountCovered() {
		double amtCovered = 0;
		
		if (m_isCovered == true) {
			amtCovered = CalculateProcedureAmount() * m_pctCovered;
		}
		
		else {
			amtCovered = 0;
		}
		
		return amtCovered;
	}
	
	/**
	 * Calculates the total amount due by subtracting
	 * the amount covered from the procedure amount
	 * 
	 * @return The total that needs to be paid
	 */
	public double CalculateProcedureAmountDue() {
		double total = 0;
		
		total = CalculateProcedureAmount() - CalculateProcedureAmountCovered();
		
		return total;
	}
	
	/**
	 * This method will use a filescanner to read
	 * each line and store the data held on each line to
	 * the member variables of VisitProcedure.
	 * 
	 * @param inputFile Scanner object that data is being read from.
	 */
	public void Read(Scanner inputFile) {
		
		m_procedure.Read(inputFile);
		//m_procedure.SetName(inputFile.nextLine());
		//m_procedure.SetPrice(inputFile.nextDouble());
		m_quantity = inputFile.nextDouble();
		inputFile.nextLine();
		m_isCovered = inputFile.nextBoolean();
		inputFile.nextLine();
		m_pctCovered = inputFile.nextDouble();
		inputFile.nextLine();
		
	}
	
	/**
	 * This method will use a printstream to write
	 * each member variable to a line of an output file.
	 * 
	 * @param outputFile printstream object that is writing data to file.
	 */
	public void Write(PrintStream outputFile) {
		outputFile.printf("%s\n%.2f\n%.2f\n%b\n%.2f\n", m_procedure.GetName(), m_procedure.GetPrice(), m_quantity, m_isCovered, m_pctCovered);
	}
	
	/**
	 * This method concatenates the member variables 
	 * into a JSON formatted string.
	 * 
	 * @return vpJSON which holds a JSON formatted string.
	 */
	public String GetJSON() {
		String vpJSON = "\t\t{\n\t\t\t\"m_procedure\" : \n" + m_procedure.GetJSON() + ",\n" + "\t\t\t\"quantity\" : " 
				+ m_quantity + ",\n" + "\t\t\t\"isCovered\" : " + m_isCovered + ",\n" + "\t\t\t\"pctCovered\" : " 
				+ m_pctCovered + "\n\t\t}";
		
		return vpJSON;
	}
	
	/**
	 * This method will override the toString method to 
	 * return a formatted string showing the member variables.
	 * 
	 * returns s A string holding the formatted string.
	 */
	@Override public String toString() {
		String s = m_procedure.toString() + "\nQuantity: " + m_quantity + "\nIs Covered: " + m_isCovered + "\nPercent Covered: " + m_pctCovered + "\n";
		
		return s;
	}

}
