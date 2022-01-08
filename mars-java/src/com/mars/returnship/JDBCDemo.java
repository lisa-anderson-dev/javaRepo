package com.mars.returnship;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class JDBCDemo {

	public static void main(String[] args) {
		Connection con = null;
		try {	
			// step 1:  load the driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String conUrl = "jdbc:sqlserver://localhost; databaseName=mars; user=sa; password=root";
			
			// step 2:  get the connection object
			con = DriverManager.getConnection(conUrl);
			
			// step 3:  get the statement object
			Statement stmt = con.createStatement();
				
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Welcome to the MARS Database\n");
			
			// selects the last record in the USERINFO table to determine the next User ID to add
			String countSql = "SELECT TOP 1 userid FROM userinfo ORDER BY userid DESC";
			ResultSet countRS = stmt.executeQuery(countSql);
			int last = 0;
			if (countRS.next()) {
				String lastID = countRS.getString(1);
				String[] lastIDsplit = lastID.split("u0*");
				last = Integer.parseInt(lastIDsplit[1]);
				countRS.close();
			}
			
			System.out.println("COMMAND MENU");
			System.out.println("1 - insert a USERINFO record");
			System.out.println("2 - update a USERINFO record");
			System.out.println("3 - delete a USERINFO record");
			System.out.println("4 - list all USERINFO records");
			System.out.println("q - quit the application\n");
			
			while (true) {
				boolean listAll = false;
				System.out.print("Enter an option: ");
				String option = sc.nextLine();
				if (option.equalsIgnoreCase("q")) {
					System.out.println("\nExiting application. Goodbye!");
					break;
				}
				else if (option.equals("1") || option.equals("2") || option.equals("3")) {
					String action = "";
					String sql = "";
					String userid = "";		
					// 1:  insert a record into the USERINFO table
					if (option.equals("1")) {
						action = "inserted";
						System.out.print("Enter a new User Name: ");
						String username = sc.nextLine();
						last++;
						String lastString = String.valueOf(last);
						userid = "u";
						if (lastString.length() < 3) {
							userid += "0".repeat(3 - lastString.length()) + lastString;
						}
						else {
							userid += lastString;
						}
						sql = "INSERT INTO userinfo VALUES('" + userid + "', '" + username + "')";
					}
					// 2:  update an existing record
					else if (option.equals("2")) {
						action = "updated";
						System.out.print("Enter the User ID of the record to update: ");
						userid = sc.nextLine();
						System.out.print("Enter a new User Name: ");
						String username = sc.nextLine();
						sql = "UPDATE userinfo SET username='" + username + "' WHERE userid='" + userid + "'";
					}
					// 3:  delete a record
					else {
						action = "deleted";
						System.out.print("Enter the User Id of the record to delete: ");
						userid = sc.nextLine();
						sql = "DELETE FROM userinfo WHERE userid='" + userid + "'";
					}
					int executed = stmt.executeUpdate(sql);
					
					// checks whether command was successfully executed
					if (executed == 0) {
						System.out.println("Error executing command - record not " + action + ".\n");
					}
					else {
						System.out.println("\nRecord " + userid + " successfully " + action + "!");
						listAll = true;
					}
				}
				else if (option.equals("4")) {
					System.out.println();
					listAll = true;
				}
				else {
					System.out.println("Invalid command. Please try again.\n");
				}
				// lists all records either because of option 4 or after a successful insert, update or delete
				if (listAll) {
					String query = "SELECT * FROM userinfo";
					ResultSet rs = stmt.executeQuery(query);
					
					while (rs.next()) {
						System.out.println("User ID: " + rs.getString(1) + "  Name: " + rs.getString(2));
					}
					System.out.println();
					rs.close();
				}
			}
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		finally {
			// close out JDBC connection
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}