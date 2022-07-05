package assignment4_package;

import javax.swing.JFrame;

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


public class Main {
    public static void main(String[] args) {
        JFrame frame = new StaffDatabaseGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

//        // Jaydenn test use
//        ReadWriteDB db = new ReadWriteDB();
//        db.recreateTable();
//
////      Note from Simul - please pass all parameters for both insert and update method calls as string datatype
//        //insert test
//        db.insertStaff("999999999", "Wang", "Julie", "F", "insert test","New York", "NY",
//        		"1233485543");
//        //update test
//        db.updateStaff("999999999", "Wang", "Julie", "F", "update test","Toronto", "ON",
//        		"1233485543");
//
//
//        ArrayList<String[]> staffList = db.viewAllStaff();
//        for (String[] staff: staffList) {
//            System.out.println(String.join(", ", staff));
//
//        }
    }

}
