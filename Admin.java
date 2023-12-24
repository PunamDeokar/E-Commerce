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
			System.out.println("Enter your product_purchased id>>");
			int id = sobj.nextInt();
			String query = "Select Product_List.id, prod_name, quantity_buy, total_amount from product_list INNER JOIN EndUserAmount on Product_List.id = EndUserAmount.id where Product_List.id = ?";
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
	
	
}