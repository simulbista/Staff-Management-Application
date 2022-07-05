package assignment4_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Student Name: Kaiyan Chen, Simul Bista, Jaydenn(Ching-Ting) Chang
 * Student ID: N01489178, N01489966, N01511476
 * Section: ITC-5201-RIA
 */

/*************************************************************************************************
 *  ITC-5201-RIA – Assignment 4 *

 *  I declare that this assignment is my own work in accordance with Humber Academic Policy. *

 *  No part of this assignment has been copied manually or electronically from any other source *

 *  (including websites) or distributed to other students/social media.  *

 *  Name: Kaiyan Chen Student ID: N01489178 Date: 7/6/2022 *
 *  Name: Simul Bista Student ID: N01489966 Date: 7/6/2022 *
 *  Name: Jaydenn(Ching-Ting) Chang Student ID: N01511476 Date: 7/6/2022 *

 * *************************************************************************************************/

public class ReadWriteDB {

    // Jaydenn
    // database connection elements
    private Connection conn = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement pstmt = null;

    // constructor
    public ReadWriteDB() {
        initializeDB();
    }


    // Jaydenn
    // initialize DB connection
    private void initializeDB() {
        try {
            // load driver
            Class.forName(OracleInfo.DRIVER_CLASS_ORACLE);
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver loading failed!");
        }

        try {
            // establish db connection
            conn = DriverManager.getConnection(OracleInfo.THIN_URL, OracleInfo.USERNAME, OracleInfo.PWD);
            System.out.println("Connection to DB is established successfully!");
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection to DB failed!");
        }
    }

    // Jaydenn
    // drop and create table
    public void recreateTable() {

        String sqlDropStaffTable = "DROP TABLE staff";
        String sqlCreateStaffTable = "CREATE TABLE staff" + "(" +
                "  id char(9) not null," +
                "  lastName varchar(15)," +
                "  firstName varchar(15)," +
                "  mi char(1)," +
                "  address varchar(20)," +
                "  city varchar(20)," +
                "  state char(2)," +
                "  telephone char(12)," +
                "  primary key (id)" +
                ")";
        try {
            statement.executeUpdate(sqlDropStaffTable);
            System.out.println("Staff table is dropped...");

            statement.executeUpdate(sqlCreateStaffTable);
            System.out.println("Staff table created successfully!");
        }
        catch (SQLException es) {
            try {
                statement.executeUpdate(sqlCreateStaffTable);
                System.out.println("Staff table created successfully!");
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }


    // Jaydenn
    // function to retrieve all data rows from staff table
    public ArrayList<String[]> viewAllStaff() {
        try {
            // create the query
            String sql = "SELECT * FROM staff";
            resultSet = statement.executeQuery(sql);

            // create an ArrayList to hold all data
            ArrayList<String[]> staffList = new ArrayList<>();

            // go through each row and add data to the ArrayList as String Array
            while (resultSet.next()) {
                String[] staffData = {  resultSet.getString("id"),
                                        resultSet.getString("lastName"),
                                        resultSet.getString("firstName"),
                                        resultSet.getString("mi"),
                                        resultSet.getString("address"),
                                        resultSet.getString("city"),
                                        resultSet.getString("state"),
                                        resultSet.getString("telephone")
                };
                staffList.add(staffData);
            }
            return staffList;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Simul
    //method to insert records in the Staff table
    public boolean insertStaff(String id, String lname, String fname, String gen, String address, String city,
    	String state, String telephone) {
    	
    	//return true on successful insert otherwise return false
    	//false scenario = SQLIntegrityConstraintVoilationException (trying to insert non-unique id)
    	boolean insert = true;
    	try {
        	//insert sql query
        	String sql = "INSERT INTO staff VALUES (?,?,?,?,?,?,?,?)";
        	//prepared statement
        	pstmt = conn.prepareStatement(sql);
        	
        	//setting the sql parameters dynamically
        	pstmt.setString(1,id);
        	pstmt.setString(2,lname);
        	pstmt.setString(3,fname);
        	pstmt.setString(4,gen);
        	pstmt.setString(5,address);
        	pstmt.setString(6,city);
        	pstmt.setString(7,state);
        	pstmt.setString(8,telephone);
        	
        	//executing the prepared statement
            pstmt.executeUpdate();
        }
        catch (Exception e){
//            e.printStackTrace();
        	System.out.println(e.getMessage());
            insert = false;
        }
    	return insert;

    }
  //Simul
  //method to update a record in the Staff table by id
    public boolean updateStaff(String id, String lname, String fname, String gen, String address, String city,
	String state, String telephone) {
    	//return true on successful insert otherwise return false
    	boolean update = true;
		try {
			//check to see if the record with input id already exists in the database
			String selectQry = "SELECT ID from STAFF where ID = " + id;
			resultSet = statement.executeQuery(selectQry);
			String foundId="";

			while (resultSet.next()) {
				foundId = resultSet.getString("ID");
			}
			
			//if the input id is equal to the id in the database
			if(foundId.equals(id)) {
				//update sql query
				String sql = "UPDATE staff " + 
							 "SET LASTNAME = ?,FIRSTNAME = ?,MI = ?,ADDRESS = ?,"+
							 "CITY = ?,STATE = ?,TELEPHONE = ?" +
							 "WHERE ID = ?";
				
				//prepared statement
	        	pstmt = conn.prepareStatement(sql);
	        	
	        	//setting the sql parameters dynamically
	        	pstmt.setString(1,lname);
	        	pstmt.setString(2,fname);
	        	pstmt.setString(3,gen);
	        	pstmt.setString(4,address);
	        	pstmt.setString(5,city);
	        	pstmt.setString(6,state);
	        	pstmt.setString(7,telephone);
	        	pstmt.setString(8,id);
	        	
	        	//executing the prepared statement
	        	pstmt.executeUpdate();
			}else {
				//a record with the input id does not exists in the database
				update = false;
			}		
		}catch(Exception e) {
			e.printStackTrace();
			update=false;
		}
		return update;
    }
}
