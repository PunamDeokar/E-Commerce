package com.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
	public static void displayEndUserAmount() {
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = DBUtil.getConnection();
			Scanner sobj = new Scanner(System.in);
			System.out.println("Enter Product_id>>");
			int id = sobj.nextInt();
			String query = "Select Product_List.id, prod_name, quantity_buy, total_amount from Product_List INNER JOIN EndUserAmount on Product_List.id = EndUserAmount.id where Product_List.id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("Displayed Amount: " + " Total Payable");
				System.out.println("*****************************************************************");
				System.out.print("Product_id      : " + rs.getInt(1));
				System.out.println("\t");
				System.out.print("Product_name    : " + rs.getString(2));
				System.out.println("\t");
				System.out.print("Product_Quantity: " + rs.getInt(3));
				System.out.println("\t");
				System.out.print("Product_Amount  :" + rs.getInt(4));
				System.out.println("\t");
				System.out.println("*****************************************************************");
			
		}
			System.out.println("Please LogIn again for next Operation.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkQuantity() {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBUtil.getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number of Products to check quantity ");
			int no = sc.nextInt();
			for (int i = 1; i <= no; i++) {
				System.out.println("Enter the product_id to check the quantity>>");
				int id = sc.nextInt();
				String query = "select id, prod_name,prod_Quantity from Product_list where id =?";
				pst = con.prepareStatement(query);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					System.out.println("Check_Quantity ");
					System.out.println("*****************************************************************");
					System.out.print("Product_Id           : " + rs.getInt(1));
					System.out.println("\t");
					System.out.print("Product_Name         : " + rs.getString(2));
					System.out.println("\t");
					System.out.print("Available =_Quantity : " + rs.getInt(3));
					System.out.println("\t");
					System.out.println("*****************************************************************");
					System.out.println();
				}
			}

			System.out.println("Please LogIn again for next Operation.....");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void userHistory() {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = DBUtil.getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter UserId to check history >>");
			int id = sc.nextInt();
			String query = "Select id, prod_name,Quantity,Username from product_list inner join cart on product_list.id=cart.sno where product_list.id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("*****************************************************************");
				System.out.println("Id                : " + rs.getInt(1));
				System.out.println("Product Name      : " + rs.getString(2));
				System.out.println("Quantity          : " + rs.getInt(3));
				System.out.println("Username          : " + rs.getString(4));
				System.out.println("*****************************************************************");
				System.out.println();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
