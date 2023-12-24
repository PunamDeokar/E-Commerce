package com.shopping;
import java.util.Scanner;
import java.sql.*;

public class BillGenerateAdmin {
	public static void CalculateBill() {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBUtil.getConnection();
			Scanner sobj = new Scanner(System.in);
			System.out.println("Enter the product id to generate the bill>>");
			int id = sobj.nextInt();
			String query = "select id,prod_name,prod_price from Product_List where id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Id   \t Product_Name \t\t\t Total_Amount");
			System.out.println("--------------------------------------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t \t\t"   + rs.getInt(3));
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Total Amount is \t\t\t "+rs.getInt(3));
		}
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	try {
		con.close();
		pst.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
}
}