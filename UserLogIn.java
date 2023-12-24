package com.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogIn {
	public  int userLogin() {
		UserLogIn obj =new UserLogIn();
		Test_Main ts =new Test_Main(); 
		BillGenerateAdmin bill = new BillGenerateAdmin();
		Connection con = null;
		PreparedStatement pst = null;
		int UserId = 0;
		
		try {
			con=DBUtil.getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Username  -");
			String username = sc.next();
			System.out.println("Enter Password   -");
			String password = sc.next();
			String query = "Select *from RegisteredUser where Username=? ANd U_password=?";
			pst = con.prepareStatement(query);
			UserOperation uo = new UserOperation(username, password);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				UserId = rs.getInt(1);
				boolean login = true;
				System.out.println("LogIn Successfull...");
				System.out.println();
				System.out.println("Select Your Choice   ");
				System.out.println("*****************************************");
				System.out.println("\t 1.View Items ");
				System.out.println("\t 2.Buy Product ");
				System.out.println("\t 3.View Cart ");
				System.out.println("\t 4.Purchase the Items.");
				System.out.println("\t 5.Home ");
				System.out.println("*****************************************");
				System.out.println("Please Select Your Choice   ");
				int choice =sc.nextInt();
				UserServices us = new UserServices();
				switch (choice) {
				case 1: us.viewItems();
						us.buyProduct();
						break;
				case 2:us.buyProduct();
						us.viewCart();
						break;
				case 3:us.viewCart();
						break;
				case 4:bill.CalculateBill();
						System.out.println("Your order is Confirmed.....");
						System.out.println();
						ts.main(null);
						break;
				case 5:ts.main(null);
						break;
				}
			}else {
				
				System.out.println("Please Enter Correct Username and Password and Try again....");
				System.out.println();
				ts.main(null);
				
			}
		} catch (Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pst.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return UserId;
	}

}
