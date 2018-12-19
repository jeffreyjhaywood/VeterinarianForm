package haywood.bcs345.hwk.vet.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import haywood.bcs345.hwk.vet.business.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Contains the JavaFX GUI implementation for the
 * veterinarian visit program.
 * 
 * @author Jeffrey Haywood
 * @version 1.0
 * @since 12/02/2018
 */
public class VetApplication extends Application{
	private Visit m_visit;
	private MenuBar m_menuBar;
	private Menu m_fileMenu;
	private MenuItem m_openMenuItem, m_separatorMenuItem1, m_saveAsMenuItem, m_saveReportMenuItem, 
					m_separatorMenuItem2, m_exportJSONMenuItem, m_separatorMenuItem3, m_exitMenuItem;
	private TabPane m_tabPane;
	private Tab m_overviewTab, m_visitTab;
	private Label m_vetNameLabel, m_petNameLabel, m_speciesLabel, m_genderLabel, m_totalAmtLabel, 
					m_amtCoveredLabel, m_amtDueLabel;
	private TextField m_vetNameText, m_petNameText, m_speciesText, m_genderText, m_totalAmtText, 
					m_amtCoveredText, m_amtDueText;
	private ListView<String> m_visitListView;
	
	/**
	 * Sets the stage, scene and contents of the program. Gives
	 * the ability to open a file that is in the correct format,
	 * save the instance of visit to another file and export
	 * Report and JSON data to a file.
	 */
	@Override
	public void start(Stage primaryStage) {
		m_visit = new Visit();
		
		// ******************************************************
		// Create instance of TabPane and add Tabs to it.
		m_tabPane = new TabPane();
		m_overviewTab = new Tab("Overview");
		m_visitTab = new Tab("Vist Procedure Data");
		m_overviewTab.setClosable(false);
		m_visitTab.setClosable(false);
		m_tabPane.getTabs().add(m_overviewTab);
		m_tabPane.getTabs().add(m_visitTab);
		// ******************************************************
		
		// ******************************************************
		// Create GridPane for the Overview tab
		GridPane overviewGridPane = new GridPane();
		m_overviewTab.setContent(overviewGridPane);
		overviewGridPane.setMaxSize(500, 500);
		overviewGridPane.setVgap(5); 
	    overviewGridPane.setHgap(5);
	    // ******************************************************
		
	    // ******************************************************
	    // Add all the items to the Overview GridPane 
		m_vetNameLabel = new Label("Veterinarian Name");
		m_vetNameText = new TextField();
		overviewGridPane.add(m_vetNameLabel, 0, 1);
		overviewGridPane.add(m_vetNameText, 1, 1);
		
		m_petNameLabel = new Label("Pet Name");
		m_petNameText = new TextField();
		overviewGridPane.add(m_petNameLabel, 0, 3);
		overviewGridPane.add(m_petNameText, 1, 3);
		
		m_speciesLabel = new Label("Species");
		m_speciesText = new TextField();
		overviewGridPane.add(m_speciesLabel, 0, 5);
		overviewGridPane.add(m_speciesText, 1, 5);
		
		m_genderLabel = new Label("Gender");
		m_genderText = new TextField();
		overviewGridPane.add(m_genderLabel, 0, 7);
		overviewGridPane.add(m_genderText, 1, 7);
		
		m_totalAmtLabel = new Label("Total Amount");
		m_totalAmtText = new TextField();
		overviewGridPane.add(m_totalAmtLabel, 0, 9);
		overviewGridPane.add(m_totalAmtText, 1, 9);
		
		m_amtCoveredLabel = new Label("Total Amount Covered");
		m_amtCoveredText = new TextField();
		overviewGridPane.add(m_amtCoveredLabel, 0, 11);
		overviewGridPane.add(m_amtCoveredText, 1, 11);
		
		m_amtDueLabel = new Label("Total Amount Due");
		m_amtDueText = new TextField();
		overviewGridPane.add(m_amtDueLabel, 0, 13);
		overviewGridPane.add(m_amtDueText, 1, 13);
		// ******************************************************
		
		// ******************************************************
		// Create GridPane for the Visit Procedure tab
		GridPane visitGridPane = new GridPane();
		m_visitTab.setContent(visitGridPane);
		visitGridPane.setMaxSize(500, 500);
		visitGridPane.setVgap(5);
	    visitGridPane.setHgap(5);
		// ******************************************************
		
		// ******************************************************
	    // Add all the items to the Visit Procedure Data GridPane
		m_visitListView = new ListView<String>();
		for(int i = 0; i < m_visit.GetNumProcedures(); i++)
		{
			m_visitListView.getItems().add(m_visit.GetByIndex(i).toString());
		}
		m_visitListView.setPrefWidth(500);
		m_visitListView.setPrefHeight(500);
		
		visitGridPane.add(m_visitListView, 0, 0);
		// ******************************************************
		
		// ******************************************************
		// Create MenuBar add Menu
		m_menuBar = new MenuBar();
		// How to set the MenuBar to display on Mac system menu (for fun!)
		String osName = System.getProperty("os.name").toLowerCase(); // Find operating system name
		boolean isMacOs = osName.startsWith("mac os x");
		if (isMacOs) // Display MenuBar on system menu if macOS
			m_menuBar.useSystemMenuBarProperty().set(true);
		
		m_fileMenu = new Menu("File");
		m_menuBar.getMenus().add(m_fileMenu);
		// ******************************************************
		
		// ******************************************************
		// Add content to Menu
		m_openMenuItem = new MenuItem("Open");
		m_separatorMenuItem1 = new SeparatorMenuItem();
		m_saveAsMenuItem = new MenuItem("Save As...");
		m_saveReportMenuItem = new MenuItem("Save Report...");
		m_separatorMenuItem2 = new SeparatorMenuItem();
		m_exportJSONMenuItem = new MenuItem("Export As JSON...");
		m_separatorMenuItem3 = new SeparatorMenuItem();
		m_exitMenuItem = new MenuItem("Exit");
		m_fileMenu.getItems().add(m_openMenuItem);
		m_fileMenu.getItems().add(m_separatorMenuItem1);
		m_fileMenu.getItems().add(m_saveAsMenuItem);
		m_fileMenu.getItems().add(m_saveReportMenuItem);
		m_fileMenu.getItems().add(m_separatorMenuItem2);
		m_fileMenu.getItems().add(m_exportJSONMenuItem);
		m_fileMenu.getItems().add(m_separatorMenuItem3);
		m_fileMenu.getItems().add(m_exitMenuItem);
		// ******************************************************
		
		// ******************************************************
		// Add MenuItem Functionality
		m_openMenuItem.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent ae)
			{
				FileChooser m_fileChooser = new FileChooser();
				File openFile = m_fileChooser.showOpenDialog(primaryStage);
				try 
				{
					Scanner visitInputFile = new Scanner(new FileReader(openFile));
					m_visit.Read(visitInputFile);
					m_vetNameText.setText(m_visit.GetName());
					m_petNameText.setText(m_visit.GetPetName());
					m_speciesText.setText(m_visit.GetPetSpecies());
					m_genderText.setText(m_visit.GetPetGender());
					m_totalAmtText.setText(String.valueOf(m_visit.GetTotalAmount()));
					m_amtCoveredText.setText(String.valueOf(m_visit.GetAmountCovered()));
					m_amtDueText.setText(String.valueOf(m_visit.GetAmountDue()));
					
					m_visitListView = new ListView<String>();
					
					for(int i = 0; i < m_visit.GetNumProcedures(); i++)
					{
						m_visitListView.getItems().add(m_visit.GetByIndex(i).toString());
					}
					
					visitGridPane.add(m_visitListView, 0, 0);
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
			}
		}
		);
		
		m_saveAsMenuItem.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent ae)
			{
				FileChooser m_fileChooser = new FileChooser();
				File saveFile = m_fileChooser.showSaveDialog(primaryStage);
				
				try 
				{
					PrintStream visitOutputFile = new PrintStream(saveFile);
					m_visit.Write(visitOutputFile);
				}
				catch (Exception e) 
				{
					//e.printStackTrace();
					System.out.println("Error. Could not open file!");
				}
			}
		}
		);
		
		m_saveReportMenuItem.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent ae)
			{
				FileChooser m_fileChooser = new FileChooser();
				File saveFile = m_fileChooser.showSaveDialog(primaryStage);
				
				try 
				{
					PrintStream visitReportOutputFile = new PrintStream(saveFile);
					m_visit.Report(visitReportOutputFile);
				}
				catch (Exception e) 
				{
					//e.printStackTrace();
					System.out.println("Error. Could not open file!");
				}
			}
		}
		);
		
		m_exportJSONMenuItem.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent ae)
			{
				FileChooser m_fileChooser = new FileChooser();
				File saveFile = m_fileChooser.showSaveDialog(primaryStage);
				
				try 
				{
					PrintStream visitJSONOutputFile = new PrintStream(saveFile);
					visitJSONOutputFile.printf("%s", m_visit.GetJSON());
				}
				catch (Exception e) 
				{
					//e.printStackTrace();
					System.out.println("Error. Could not open file!");
				}
			}
		}
		);
		
		m_exitMenuItem.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent ae)
			{
				System.exit(0);
			}
		}
		);
		// ******************************************************
		
		// ******************************************************
		// Create root VBox and add content
		VBox vbox = new VBox();
		vbox.getChildren().add(m_menuBar);
		vbox.getChildren().add(m_tabPane);
		// ******************************************************
		
		Scene scene = new Scene(vbox, 500, 500);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Vet Application");
		primaryStage.show();
		
		// Terminate the program if the window is closed.
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
	}
}
