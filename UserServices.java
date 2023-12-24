package com.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class UserServices extends UserLogIn {
	static int id =0;
	UserOperation us = new UserOperation();
	BillGenerateAdmin bill= new BillGenerateAdmin();
	static Test_Main main = new Test_Main();
	public static void getUserOpertion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*****************************************");
		System.out.println("\t User Operations ");
		System.out.println("*****************************************");
		System.out.println("\t 1.User Registration ");
		System.out.println("\t 2.User LogIn ");
		System.out.println("*****************************************");
		System.out.println();
		
		System.out.println("Please Select Your Choice   ");	
		System.out.println();
		
		int choice = sc.nextInt();
		UserLogIn login = new UserLogIn();
		UserServices us = new UserServices();
		switch (choice) {
		case 1	 : us.getUserDetails();
				 	break;
		case 2	:  login.userLogin();
					//main.main(null);
		 			break;
		default :System.out.println("Please Enter the Correct Choice");
		}
	}
	public void getUserDetails() {
		Connection con = null;
		PreparedStatement pst = null;
		DBUtil c = new DBUtil();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Details >");
		System.out.println();
		System.out.println("Enter First Name  > ");
		String fname = sc.next();
		System.out.println("Enter Last Name   >");
		String lname = sc.next();
		System.out.println("Enter Username   >");
		String uname = sc.next();
		System.out.println("Enter Password   >");
		String password = sc.next();
		System.out.println("Enter City   >");
		String city = sc.next();
		System.out.println("Enter Email  >");
		String email = sc.next();
		System.out.println("Enter Mobile Number >");
		long mno = sc.nextLong();
		System.out.println("*****************************************");
		System.out.println();
		us.setFname(fname);
		us.setLname(lname);
		us.setUsername(uname);
		us.setpassword(password);
		us.setCity(city);
		us.setEmail(email);
		us.setMno(mno);
		System.out.println("\t***User Details***");
		System.out.println("First Name    > " + fname);
		System.out.println("Last Name     > " + lname);
		System.out.println("UserName      > " + uname);
		System.out.println("City          > " + city);
		System.out.println("Email         > " + email);
		System.out.println("Mobile Number > " + mno);
		System.out.println();
		System.out.println("\tWelcome to E-Store ");
		try {
			con = c.getConnection();
			String query = "insert into RegisteredUser(First_Name, Last_Name, Username, U_Password, City, Email, Mobile_no)values(?,?,?,?, ?, ?, ?);";
			pst = con.prepareStatement(query);
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, uname);
			pst.setString(4, password);
			pst.setString(5, city);
			pst.setString(6, email);
			pst.setLong(7, mno);
			pst.executeUpdate();
			System.out.println(fname + " Your Registration has been Succefull.... ");
			System.out.println("Please LogIn with your Username and Password ");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void viewItems() {
		Connection con = null;
		PreparedStatement pst=null ;
		UserOperation us = new UserOperation();
		try {
			con=DBUtil.getConnection();
			String query="Select *from Product_list";
			pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			System.out.println("------------------------------------------");
			System.out.println("\t E-Store Product List");
			System.out.println("------------------------------------------");

			while(rs.next()) {
				System.out.println(" Id>         > "+rs.getInt(1));
				System.out.println(" Name        > "+rs.getString(2));
				System.out.println("Description  > "+rs.getString(3));
				System.out.println("Price        > "+rs.getInt(4));
				System.out.println("Quantity     > "+rs.getInt(5));
				System.out.println("*****************************************");
				System.out.println();
			}
				con.close();
				pst.close();
		   }	 catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		   }finally {
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void buyProduct() {
		Connection con=null;
		PreparedStatement pst=null;
		Statement st=null;
		Scanner sc = new Scanner(System.in);
		//int [] addProduct = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		try {
			System.out.println("Select Product Id and quatity to add product into cart");
			 int id=sc.nextInt();
			int quantity=sc.nextInt();
			con=DBUtil.getConnection();
			String query="Insert into Cart (Product_id, Quantity) values(?,?)";
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setInt(2, quantity);
			pst.executeUpdate();
			System.out.println("Product Id-"+ id +" Added to cart.");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void viewCart() {
		Connection con=null;
		PreparedStatement pst=null;
		Scanner sc = new Scanner(System.in);
		int [] addProduct = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		try {
			System.out.println("\t To view Cart ");
			System.out.println("Select Product Id which you have added into the card");
			 int id=sc.nextInt();
			con=DBUtil.getConnection();
			String query="select id,prod_name,prod_Price from product_list inner join Cart on product_list.id=Cart.Product_id where product_id=?;";
			pst=con.prepareStatement(query);
			pst.setInt(1, id);
			
			System.out.println();
			System.out.println("*****************************************");
			System.out.println("\t*****  CART\t*****");
			System.out.println("*****************************************");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("Id          > "+rs.getInt(1));
				System.out.println("Name        > "+rs.getString(2));
				System.out.println("Price       > "+rs.getInt(3));
				System.out.println("*****************************************");
				System.out.println();
			}	
			System.out.println("* Press 1 to confirm your Order ");
			System.out.println("* Press 2 to go Home Page");
			int choice= sc.nextInt();
			switch (choice ) {
			case 1 : bill.CalculateBill();
			break;
			case 2 : main.main(null);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	}
}
