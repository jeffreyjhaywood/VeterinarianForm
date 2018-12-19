/*
 * Excellent Work!
 */

package haywood.bcs345.hwk.vet.presentation;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import haywood.bcs345.hwk.vet.business.*;

/**
 * Contains main program code. 
 * 
 * @author Jeffrey Haywood
 * @version 4.0
 * @since 9/25/2018
 *
 */

public class Main {
	
	/**
	 * This is the main of the program. Will create an
	 * instance of VisitProcedureConsoleUI, VisitConsoleUI or
	 * GraphicalUI depending on what the user chooses and call the
	 * ShowUI() method which displays a menu with options
	 * for the user to choose.
	 * 
	 * @param args Command line arguments
	 */

	public static void main(String[] args) {
		
		int choice = 0;
		Scanner keyboardInput = new Scanner(System.in);

		do 
		{
			try
			{
				System.out.println("Choose UI");
				System.out.println("---------");
				System.out.println("1 – VisitProcedureConsoleUI");
				System.out.println("2 – VisitConsoleUI");
				System.out.println("3 - VetGraphicalUI");
				System.out.println("4 – Exit");
				System.out.print("Enter Choice: ");
				choice = keyboardInput.nextInt();
			}
			catch(InputMismatchException ime)
			{
				// No need to print anything because switch statement default will print.
				choice = 0; // Set choice back to 0 so try/catch still works properly after initial input mismatch.
			}
			
			keyboardInput.nextLine(); // clear buffer
			
			switch(choice)
			{
				case 1: 
					VisitProcedureConsoleUI vpmenu = new VisitProcedureConsoleUI();
					vpmenu.ShowUI();
					break;
					
				case 2:
					VisitConsoleUI vmenu = new VisitConsoleUI();
					vmenu.ShowUI();
					break;
					
				case 3:
					VetGraphicalUI guimenu = new VetGraphicalUI();
					guimenu.ShowUI();
					break;
					
				case 4:
					System.out.println("Program terminated.");
					break;
					
				default: 
					System.out.println("Please enter a valid choice.");
			}

		}
		while(choice != 4);
		
		
		/*VisitConsoleUI vmenu = new VisitConsoleUI();
		vmenu.ShowUI();*/
		/*Visit v = new Visit();
		Scanner visitKeyboardInput = new Scanner(System.in);
		System.out.println("Enter input file name for visit: ");
		String visitInputFileName = visitKeyboardInput.nextLine();
		try 
		{
			Scanner visitInputFile = new Scanner(new FileReader(visitInputFileName));
			v.Read(visitInputFile);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}*/
		
		/*System.out.println("Enter output file name for visit: ");
		String visitOutputFileName = visitKeyboardInput.nextLine();
		try 
		{
			PrintStream visitOutputFile = new PrintStream(visitOutputFileName);
			v.Write(visitOutputFile);
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}*/
		
		
		/*System.out.println("Enter output file name for report: ");
		String reportOutputFileName = visitKeyboardInput.nextLine();
		try 
		{
			PrintStream reportOutputFile = new PrintStream(reportOutputFileName);
			v.Report(reportOutputFile);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}*/
		
		//System.out.println(v.GetJSON());
		//System.out.println(v.toString());
		//System.out.println(v.GetByIndex(5));
		//System.out.println(v.GetHighestProcedureAmountDue());
		//System.out.println(v.GetHighestProcedureAmountDue().CalculateProcedureAmountDue());
		
		//VisitProcedureConsoleUI menu = new VisitProcedureConsoleUI();
		//menu.ShowUI();
		
		/*
		// ****Pet Class Tests****
		
		// Call default constructor
		Pet pet1 = new Pet();
		
		// Test SetName/GetName
		String petTestName = "Test Name";
		pet1.SetName(petTestName);
		
		if (petTestName.equals(pet1.GetName()))
		{
			System.out.println("Pet Get/Set Name: Pass");
		}
		else
		{
			System.out.println("Pet Get/Set Name: FAIL!");
		}
		
		// Test SetSpecies/GetSpecies
		String petTestSpecies = "Test Species";
		pet1.SetSpecies(petTestSpecies);
		
		if (petTestSpecies.equals(pet1.GetSpecies()))
		{
			System.out.println("Pet Get/Set Species: Pass");
		}
		else
		{
			System.out.println("Pet Get/Set Species: FAIL!");
		}
		
		// Test SetGender/GetGender
		String petTestGender = "Test Gender";
		pet1.SetGender(petTestGender);
		
		if (petTestGender.equals(pet1.GetGender()))
		{
			System.out.println("Pet Get/Set Gender: Pass");
		}
		else
		{
			System.out.println("Pet Get/Set Gender: FAIL!");
		}
		
		// Call copy constructor
		Pet pet2 = new Pet("Pepper", "Female", "Dog");
		System.out.println("Pet copy constructor test\n" + pet2.toString());
		
		// Call Read 1st time
		Pet pet3 = new Pet();
		Scanner petKeyboardInput = new Scanner(System.in);
		System.out.println("Enter input file name for pet: ");
		String petInputFileName = petKeyboardInput.nextLine();
		try 
		{
			Scanner petInputFile = new Scanner(new FileReader(petInputFileName));
			pet3.Read(petInputFile);
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}
		
		// Call Write
		System.out.println("Enter output file name for pet: ");
		String petOutputFileName = petKeyboardInput.nextLine();
		try 
		{
			PrintStream petOutputFile = new PrintStream(petOutputFileName);
			pet3.Write(petOutputFile);
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}
		
		// Call Read second time using the created file (petOutputFileName) from Write
		// If program fails to read there is an error
		try 
		{
			Scanner newPetInputFile = new Scanner(new FileReader(petOutputFileName));
			pet3.Read(newPetInputFile);
			System.out.println("Second Pet Read called using new file.");
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}
		
		// Call GetJSON
		System.out.println(pet3.GetJSON());
		
		// Call toString
		System.out.println(pet3.toString());
		
		
		
		
		// ****Procedure Class Tests****
		
		// Call default constructor
		Procedure proc1 = new Procedure();
		
		// Test SetName/GetName
		String procTestName = "Test Name";
		proc1.SetName(procTestName);
		if (procTestName.equals(proc1.GetName()))
		{
			System.out.println("Procedure Get/Set Name: Pass");
		}
		else
		{
			System.out.println("Procedure Get/Set Name: FAIL!");
		}
		
		// Test SetPrice/GetPrice
		double procTestPrice = 100.00;
		proc1.SetPrice(procTestPrice);
		if (procTestPrice == proc1.GetPrice())
		{
			System.out.println("Procedure Get/Set Price: Pass");
		}
		else
		{
			System.out.println("Procedure Get/Set Price: FAIL!");
		}
		
		// Call copy constructor
		Procedure proc2 = new Procedure("Neuter", 150.00);
		System.out.println("Procedure copy constructor test\n" + proc2.toString());
		
		// Call Read 1st time
		Procedure proc3 = new Procedure();
		Scanner procKeyboardInput = new Scanner(System.in);
		System.out.println("Enter input file name for procedure: ");
		String procInputFileName = procKeyboardInput.nextLine();
		try 
		{
			Scanner procInputFile = new Scanner(new FileReader(procInputFileName));
			proc3.Read(procInputFile);
		}
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}
			
		// Call Write
		System.out.println("Enter output file name for procedure: ");
		String procOutputFileName = procKeyboardInput.nextLine();
		try
		{
			PrintStream procOutputFile = new PrintStream(procOutputFileName);
			proc3.Write(procOutputFile);
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}
		
		// Call Read second time using the created file (procOutputFileName) from Write
		// If program fails to read there is an error
		try 
		{
			Scanner newProcInputFile = new Scanner(new FileReader(procOutputFileName));
			proc3.Read(newProcInputFile);
			System.out.println("Second procedure Read called using new file.");
		}
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}
		
		// Call GetJSON
		System.out.println(proc3.GetJSON());
				
		// Call toString
		System.out.println(proc3.toString());
		*/
		
		/*
		// **** Appointment Class Tests ****
		
		// Call Read
		Appointment a = new Appointment();
		Scanner appKeyboardInput = new Scanner(System.in);
		System.out.println("Enter input file name for Appointment: ");
		String appInputFileName = appKeyboardInput.nextLine();
		try 
		{
			Scanner appInputFile = new Scanner(new FileReader(appInputFileName));
			a.Read(appInputFile);
		}
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}

		// Call Write
		System.out.println("Enter output file name for Appointment: ");
		String appOutputFileName = appKeyboardInput.nextLine();
		try
		{
			PrintStream appOutputFile = new PrintStream(appOutputFileName);
			a.Write(appOutputFile);
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.out.println("Error. Could not open file!");
		}
		
		System.out.println(a.GetJSON());
		System.out.println(a.toString());
		*/
	}

}
