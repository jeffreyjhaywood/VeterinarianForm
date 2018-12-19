package haywood.bcs345.hwk.vet.presentation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import haywood.bcs345.hwk.vet.business.*;

/**
 * VisitConsoleUI Class contains the method to display a menu
 * to the user which will give options to read, write, show visit procedure
 * by index, show visit procedure with highest amount due, generate and print
 * a report to the console, get the JSON formatted, and display on screen what 
 * is inside each variable. Menu will keep running until 8 is entered.
 * 
 * @author Jeffrey Haywood
 * @version 1.0
 * @since 10/27/2018
 *
 */

public class VisitConsoleUI {
	
	/**
	 * ShowUI will display a menu to the screen that will
	 * have designated numbers that correspond to the listed
	 * choice. User will be asked to enter a choice until 8 is
	 * entered.
	 */
	
	public void ShowUI() {
		
		int choice = 0;
		Scanner keyboardInput = new Scanner(System.in);
		Visit v = new Visit();
		
		do {
			try 
			{
				System.out.println("Visit UI");
				System.out.println("--------");
				System.out.println("1 – Read visit info from file");
				System.out.println("2 – Write visit info to file");
				System.out.println("3 – Show visit procedure by index");
				System.out.println("4 – Show visit procedure with highest amount due");
				System.out.println("5 - Show visit report on screen");
				System.out.println("6 – Show visit as JSON string on screen");
				System.out.println("7 – Show visit toString on screen");
				System.out.println("8 - Exit");
				System.out.print("Enter Choice: ");
				choice = keyboardInput.nextInt();
			}
			catch(InputMismatchException ime) 
			{
				// No need to print anything because switch statement default will print.
				choice = 0; // Set choice back to 0 so try/catch still works properly after initial input mismatch.
			}
			
			keyboardInput.nextLine(); // Clear buffer
			
			switch(choice)
			{
				case 1:
					Scanner visitKeyboardInputFile = new Scanner(System.in);
					System.out.println("Enter input file name for visit: ");
					String visitInputFileName = visitKeyboardInputFile.nextLine();
					try 
					{
						Scanner visitInputFile = new Scanner(new FileReader(visitInputFileName));
						v.Read(visitInputFile);
					}
					catch(FileNotFoundException fnfe)
					{
						System.out.println("Please enter a valid input file name");
					}
					catch (Exception e) 
					{
						//e.printStackTrace();
						System.out.println("Error. Could not open file!");
					}
					break;
					
				case 2:
					Scanner visitKeyboardOutputFile = new Scanner(System.in);
					System.out.println("Enter output file name for visit: ");
					String visitOutputFileName = visitKeyboardOutputFile.nextLine();
					try 
					{
						PrintStream visitOutputFile = new PrintStream(visitOutputFileName);
						v.Write(visitOutputFile);
					}
					catch (Exception e) 
					{
						//e.printStackTrace();
						System.out.println("Error. Could not open file!");
					}
					break;
					
				case 3:
					Scanner visitKeyboardIndex = new Scanner(System.in);
					System.out.println("Enter index to view: ");
					
					try
					{
						int index = visitKeyboardIndex.nextInt();
						System.out.println(v.GetByIndex(index));
					}
					catch (ArrayIndexOutOfBoundsException aioobe)
					{
						System.out.println("Please enter a valid index.");
					}
					catch(InputMismatchException ime) 
					{
						System.out.println("Please enter an integer.\n");
					}
					break;

				case 4:
					System.out.println(v.GetHighestProcedureAmountDue());
					break;
					
				case 5:
					PrintStream consoleOutput = System.out;
					v.Report(consoleOutput);
					break;
					
				case 6:
					System.out.println(v.GetJSON());
					break;
					
				case 7:
					System.out.println(v.toString());
					break;
					
				case 8:
					System.out.println("Menu terminated.");
					break;
					
				default:
					System.out.println("Please enter a valid choice.");
			}
		}
		while(choice != 8);
	}

}
