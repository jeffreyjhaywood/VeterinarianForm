package haywood.bcs345.hwk.vet.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import haywood.bcs345.hwk.vet.business.*;

/**
 * VisitProcedureConsoleUI Class contains the method to display a menu
 * to the user which will give options to read, write, get the JSON formatted
 * information and display on screen what is inside each variable. Menu
 * will keep running until 5 is entered.
 * 
 * @author jeffreyhaywood
 * @version 1.0
 * @since 10/07/2018
 *
 */

public class VisitProcedureConsoleUI {
	
	/**
	 * ShowUI will display a menu to the screen that will
	 * have designated numbers that correspond to the listed
	 * choice. User will be asked to enter a choice until 5 is
	 * entered.
	 */
	
	public void ShowUI() {
		
		int choice = 0;
		Scanner keyboardInput = new Scanner(System.in);
		VisitProcedure vp = new VisitProcedure();
		
		do 
		{
			try 
			{
				System.out.println("Visit Procedure UI");
				System.out.println("------------------");
				System.out.println("1 - Read visit procedure from file");
				System.out.println("2 – Write visit procedure to file");
				System.out.println("3 – Show visit procedure data with descriptive text on screen");
				System.out.println("4 – Show visit procedure JSON on screen");
				System.out.println("5 - Exit");
				System.out.print("Enter Choice: ");
				choice = keyboardInput.nextInt();
			}
			catch(InputMismatchException ime)
			{
				// No need to print anything because switch statement default will print.
				choice = 0; // Set choice back to 0 so try/catch still works properly after initial input mismatch.
			}
			
			keyboardInput.nextLine(); // clear buffer, THIS IS WHY I WAS GETTING INFINITE LOOP !
			
			switch(choice) 
			{
				case 1:	
				Scanner vpKeyboardInputFile = new Scanner(System.in);
				System.out.println("Enter input file name for Visit Procedure: ");
				String vpInputFileName = vpKeyboardInputFile.nextLine();
				try 
				{
					Scanner vpInputFile = new Scanner(new FileReader(vpInputFileName));
					vp.Read(vpInputFile);
				}
				catch(FileNotFoundException fnfe)
				{
					System.out.println("Please enter a valid input file name");
				}
				catch (Exception e) 
				{
					//e.printStackTrace();
					System.out.println("Error. Could not open visit input procedure file!");
				}
						break;
				
				case 2:	
				Scanner vpKeyboardOutputFile = new Scanner(System.in);
				System.out.println("Enter output file name for Visit Procedure: ");
				String vpOutputFileName = vpKeyboardOutputFile.nextLine();
				try
				{
					PrintStream vpOutputFile = new PrintStream(vpOutputFileName);
					vp.Write(vpOutputFile);
				}
				catch (Exception e) 
				{
					//e.printStackTrace();
					System.out.println("Error. Could not open Visit Procedure output file!");
				}
						break;
				
				case 3:	System.out.println(vp.toString());
						break;
			
				case 4:	System.out.println(vp.GetJSON());
						break;
						
				case 5:	System.out.println("Menu terminated.\n");
						break;
						
				default: 
					System.out.println("Please enter a valid choice.");
				
			}
			
		}
		while(choice != 5);
		
		//System.out.println("program terminated");
		
		//System.out.println("Procedure Amount: $" + vp.CalculateProcedureAmount());
		//System.out.println("Amount Covered: $" + vp.CalculateProcedureAmountCovered());
		//System.out.println("Total Amount Due: $" + vp.CalculateProcedureAmountDue());
		
	}

}
