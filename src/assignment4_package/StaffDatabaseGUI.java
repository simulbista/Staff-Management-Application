package assignment4_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Student Name: Kaiyan Chen, Simul Bista, Jaydenn(Ching-Ting) Chang
 * Student ID: N01489178, N01489966, N01511476
 * Section: ITC-5201-RIA
 */
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*************************************************************************************************
 * ITC-5201-RIA – Assignment 2 *
 * 
 * I declare that this assignment is my own work in accordance with Humber
 * Academic Policy. *
 * 
 * No part of this assignment has been copied manually or electronically from
 * any other source *
 * 
 * (including web sites) or distributed to other students/social media. *
 * 
 * Name: Kaiyan Chen Student ID: N01489178 Date: 7/6/2022 * Name: Simul Bista
 * Student ID: N01489966 Date: 7/6/2022 * Name: Jaydenn(Ching-Ting) Chang
 * Student ID: N01511476 Date: 7/6/2022 *
 * 
 *************************************************************************************************/

public class StaffDatabaseGUI extends JFrame {

	// Kaiyan
	// Frame setting
	private static final int FRAME_WIDTH = 620;
	private static final int FRAME_HEIGHT = 700;

	// Kaiyan
	// staff information elements
	private String id;
	private String lastName;
	private String firstName;
	private String mi;
	private String address;
	private String city;
	private String state;
	private String phone;
//	private String email="";

	// input GUI elements
	private JLabel idLabel;
	private JLabel lastNameLabel;
	private JLabel firstNameLabel;
	private JLabel miLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel stateLabel;
	private JLabel phoneLabel;
	private JLabel idDVLabel;
	private JLabel lastNameDVLabel;
	private JLabel firstNameDVLabel;
	private JLabel miDVLabel;
	private JLabel addressDVLabel;
	private JLabel cityDVLabel;
	private JLabel stateDVLabel;
	private JLabel phoneDVLabel;
	private JLabel statusLabel;
	private JLabel msgLabel;

	private JTextField idField;
	private JTextField lastNameField;
	private JTextField firstNameField;
	private JTextField miField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField stateField;
	private JTextField phoneField;

	private JButton viewButton;
	private JButton insertButton;
	private JButton updateButton;
	private JButton clearButton;

	private JPanel inputPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel buttonPanel;
	private JPanel mainPanel;

	// Jaydenn
	// database instance
	ReadWriteDB db;

	// to store ArrayList<String[]> returned from View Function
	ArrayList<String[]> staffList;

	// viewData result panel
	JPanel viewDataPanel;

	// viewData panel elements
	private DefaultTableModel tableModel;
	private JTable viewDataTable;

	// Kaiyan
	// constructor
	public StaffDatabaseGUI() {

		// Jaydenn create database connection and re-create table
		db = new ReadWriteDB();
        db.recreateTable();
		
//      //insert test
//      db.insertStaff("999999999", "Wang", "Julie", "F", "insert test","New York", "NY",
//      		"123-348-5543");
//      //update test
//      db.updateStaff("999999999", "Wang", "Julie", "F", "update test","Toronto", "ON",
//      		"123-348-5543");
//      
//      db.updateStaff("999999998", "Wang", "Julie", "F", "update test","Toronto", "ON",
//        		"123-348-5543");

		// setup the frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Staff Information");

		// put together the Base Panels to the frame
		// set frame to boxLayout
	    setLayout( new BoxLayout( getContentPane(), BoxLayout.Y_AXIS)); 
	    add( createMainPanel() );
	    add( createViewDataPanel() );

	}

	// create input panel
	public JPanel createMainPanel() {
		//create info labels
		idLabel = new JLabel("ID");
		lastNameLabel = new JLabel("Last Name");
		firstNameLabel = new JLabel("First Name");
		miLabel = new JLabel("mi");
		addressLabel = new JLabel("Address");
		cityLabel = new JLabel("City");
		stateLabel = new JLabel("State");
		phoneLabel = new JLabel("Telephone");

		//create data valid msg labels
		idDVLabel = new JLabel();
		lastNameDVLabel = new JLabel();
		firstNameDVLabel = new JLabel();
		miDVLabel = new JLabel();
		addressDVLabel = new JLabel();
		cityDVLabel = new JLabel();
		stateDVLabel = new JLabel();
		phoneDVLabel = new JLabel();

		statusLabel = new JLabel("Database Connected");
		
		msgLabel = new JLabel();

		//create textfields
		idField = new JTextField(15);
		idField.setBackground(Color.yellow);
		lastNameField = new JTextField(15);
		firstNameField = new JTextField(15);
		miField = new JTextField(3);
		addressField = new JTextField(20);
		cityField = new JTextField(20);
		stateField = new JTextField(3);
		phoneField = new JTextField(17);

		//create buttons and panels
		viewButton = new JButton("View");
		insertButton = new JButton("Insert");
		updateButton = new JButton("Update");
		clearButton = new JButton("Clear");
		
		mainPanel = new JPanel();
		inputPanel = new JPanel();
		buttonPanel = new JPanel();
		
		//set each panel in inputPanel align to left
		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//set border of inputPanel
		inputPanel.setBorder(BorderFactory.createTitledBorder("Staff Information"));
		
		//set box layout for inputPanel
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		
		//line1
		panel1.add(idLabel);
		panel1.add(idField);
		
		//line2
		panel2.add(lastNameLabel);
		panel2.add(lastNameField);
		panel2.add(firstNameLabel);
		panel2.add(firstNameField);
		panel2.add(firstNameLabel);
		panel2.add(firstNameField);
		panel2.add(miLabel);
		panel2.add(miField);
		
		//line3
		panel3.add(addressLabel);
		panel3.add(addressField);

		//line4
		panel4.add(cityLabel);
		panel4.add(cityField);
		panel4.add(stateLabel);
		panel4.add(stateField);

		//line5
		panel5.add(phoneLabel);
		panel5.add(phoneField);

		//add each panel as one line in Y_AXIS
		inputPanel.add(panel1);
		inputPanel.add(panel2);
		inputPanel.add(panel3);
		inputPanel.add(panel4);
		inputPanel.add(panel5);
		
		//add data validation label for each textfield
		inputPanel.add(idDVLabel);
		inputPanel.add(lastNameDVLabel);
		inputPanel.add(firstNameDVLabel);
		inputPanel.add(miDVLabel);
		inputPanel.add(addressDVLabel);
		inputPanel.add(cityDVLabel);
		inputPanel.add(stateDVLabel);
		inputPanel.add(phoneDVLabel);
		
		inputPanel.add(msgLabel);

		buttonPanel.add(viewButton);
		buttonPanel.add(insertButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(clearButton);
		// buttonPanel.add(statusLabel);

		//set mainPanel to borderlayout
		mainPanel.setLayout(new BorderLayout());
		// mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		mainPanel.add(statusLabel, BorderLayout.SOUTH);

		// create ActionListener for insertButton
		ActionListener viewListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) {
				idDVLabel.setText("");
				lastNameDVLabel.setText("");
				firstNameDVLabel.setText("");
				miDVLabel.setText("");
				addressDVLabel.setText("");
				cityDVLabel.setText("");
				stateDVLabel.setText("");
				phoneDVLabel.setText("");
				msgLabel.setText("");
				staffList = db.viewAllStaff();
				tableModel.setRowCount(0);
				printAllResult(staffList);
			}
		};

		// create ActionListener for insertButton
		ActionListener insertListener = new ActionListener()

		{
			public void actionPerformed(ActionEvent ae) {
				inputDataCollector();
				msgLabel.setText("");
				boolean result = validation(id, lastName, firstName, mi, address, city, state, phone);
				if (result) {
//					ReadWriteDB readWriteDB = new ReadWriteDB();
					if(db.insertStaff(id, lastName, firstName, mi, address, city, state, phone)) {
						msgLabel.setText("Record inserted successfully!");
					}else{
						msgLabel.setText("A record with the id exits in the database! Please try using a unique id value.");
					};
				}

			}
		};

		// create ActionListener for updateButton
		ActionListener updateListener = new ActionListener()

		{
			public void actionPerformed(ActionEvent ae) {
				inputDataCollector();
				msgLabel.setText("");
				boolean result = validation(id, lastName, firstName, mi, address, city, state, phone);				
				if(result) {
//					ReadWriteDB readWriteDB = new ReadWriteDB();
					if(db.updateStaff(id, lastName, firstName, mi, address, city, state, phone)) {
						msgLabel.setText("Record updated successfully!");
					}else{
						msgLabel.setText("The database doesn't contain any record with the input id!");
					};
				}
			}
		};
		
		// create ActionListener for clearButton
		ActionListener clearListener = new ActionListener()

		{
			public void actionPerformed(ActionEvent ae) {
				idField.setText("");
				lastNameField.setText("");
				firstNameField.setText("");
				miField.setText("");
				addressField.setText("");
				cityField.setText("");
				stateField.setText("");
				phoneField.setText("");
			}
		};
		
		//add listener to buttons
		viewButton.addActionListener(viewListener);
		insertButton.addActionListener(insertListener);
		updateButton.addActionListener(updateListener);
		clearButton.addActionListener(clearListener);

		return mainPanel;
	}

	// pass the input data to the variables
	public void inputDataCollector() {
		id = idField.getText();
		lastName = lastNameField.getText();
		firstName = firstNameField.getText();
		mi = miField.getText();
		address = addressField.getText();
		city = cityField.getText();
		state = stateField.getText();
		phone = phoneField.getText();
	}
	
	//id validation, 9 digits
	public boolean isIdValid(String id) {
		return id.matches("^[0-9]{9}$");
	}
	
	//name validation, no more than 15 characters with capitalizing
	public boolean isLastNameValid(String lastName) {
		if (lastName.length() <= 15)
			return lastName.matches("[A-Z][a-z]*");
		return false;
	}

	//name validation, no more than 15 letters with capitalizing
	public boolean isFirstNameValid(String firstName) {
		if (firstName.length() <= 15)
			return firstName.matches("[A-Z][a-z]*");
		return false;
	}
	
	//gender validation, only accept F or M 
	public boolean isMiValid(String mi) {
		return mi.matches("[FM]");
	}

	//address validation, allow digits,letters and # . , - within 20 characters
	public boolean isAddressValid(String address) {
		if (address.length() <= 20)
			return address.matches("^[#.0-9a-zA-Z\\s,-]+$");
		return false;
	}
	
	//city validation, no more than 15 letters with capitalizing
	public boolean isCityValid(String city) {
		if (city.length() <= 20)
			return city.matches("[A-Z][a-z]*");
		return false;
	}
	
	//state validation, 2 capital letters only
	public boolean isStateValid(String state) {
		return state.matches("[A-Z][A-Z]");
	}

	//phone validation, 10 digits
	public boolean isPhoneValid(String phone) {
		return phone.matches("^\\d{3}-\\d{3}-\\d{4}$");
	}

	// validation method
	public boolean validation(String id, String lastName, String firstName, String mi, String address, String city,
			String state, String phone) {
		boolean valid = true;

		if (!isIdValid(id))
		{
			idDVLabel.setText("Please enter 9 digits number for ID!");
			valid=false;
		}
		else
			idDVLabel.setText("");

		if (!isLastNameValid(lastName))
		{
			lastNameDVLabel.setText("Please enter no more than 15 letters with capitalizing for Last Name!");
			valid=false;
		}
		else
			lastNameDVLabel.setText("");

		if (!isFirstNameValid(firstName))
		{
			firstNameDVLabel.setText("Please enter no more than 15 letters with capitalizing for First Name!");
			valid=false;
		}
		else
			firstNameDVLabel.setText("");

		if (!isMiValid(mi))
		{
			miDVLabel.setText("Please enter F or M for mi!");
			valid=false;
		}
		else
			miDVLabel.setText("");

		if (!isAddressValid(address))
		{
			addressDVLabel.setText("Please enter no more than 20 characters for Address!");
			valid=false;
		}
		else
			addressDVLabel.setText("");

		if (!isCityValid(city))
		{
			cityDVLabel.setText("Please enter no more than 20 characters with capitalizing for City!");
			valid=false;
		}
		else
			cityDVLabel.setText("");

		if (!isStateValid(state))
		{
			stateDVLabel.setText("Please enter 2 capital letters for State!");
			valid=false;
		}
		else
			stateDVLabel.setText("");

		if (!isPhoneValid(phone))
		{
			phoneDVLabel.setText("Please enter 10 digits number for Phone with the format: (647-584-4927)!");
			valid=false;
		}
		else
			phoneDVLabel.setText("");
		return valid;
	}

	// Jaydenn
	public JPanel createViewDataPanel() {

		// create panel
		viewDataPanel = new JPanel();
		viewDataPanel.setLayout(new BorderLayout());

		// create table
		String[] column = new String[] { "ID", "LastName", "FirstName", "MI", "Address", "City", "State", "Telephone"};
		tableModel = new DefaultTableModel(column, 0);
		viewDataTable = new JTable(tableModel);

		// test use
//        String[] item = {"1", "2", "3", "4", "5", "6", "7", "8"};
//        tableModel.addRow(item);

		// set table to be read-only
		viewDataTable.setEnabled(false);

		// give email column a starting width
		viewDataTable.getColumn("Telephone").setPreferredWidth(80);

		// set columns expandable (when expanding, horizontal scrollbar will show up)
		viewDataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// create a JScrollPane for table
		JScrollPane searchScrollPane = new JScrollPane(viewDataTable);

		// add elements to the panel
		viewDataPanel.add(searchScrollPane, BorderLayout.CENTER);

		// return the aggregated panel
		return viewDataPanel;
	}

	// Jaydenn
	// add all customer data to the search result table
	public void printAllResult(ArrayList<String[]> staffList) {
		// test if customer list is null
		if (staffList == null) {
			msgLabel.setText("Please contact developer, something's wrong");
		}
		// test if exists records
		else if (staffList.size() == 0) {
			// Kaiyan
			// show an error msg saying the list returned is empty
			msgLabel.setText("No records are found!");
		}
		else
		{
			// go over the String List in staffList ArrayList to add data to display table
			for (String[] staff : staffList) {
				tableModel.addRow(staff);
			}
			// Kaiyan clear the msg
			msgLabel.setText("");
		}
	}

}
