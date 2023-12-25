package com.shopping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class AdminLogIn {
	
	public void selectOption() {
		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin();
		AdminLogIn adlin = new AdminLogIn();
		Test_Main ts =new Test_Main();
		UserServices us = new UserServices();
		BillGenerateAdmin bg= new BillGenerateAdmin();
		System.out.println("*****************************************");
		System.out.println("\t Admin Operations");
		System.out.println("*****************************************");
		System.out.println("\t 1.Add Product Items ");
		System.out.println("\t 2.Calculate Bill ");
		System.out.println("\t 3.Display Amount  ");
		System.out.println("\t 4.Check Quantity ");
		System.out.println("\t 5.Check Registered Userd  ");
		System.out.println("\t 6.Check User History");	
		System.out.println("\t 7.Home");
		System.out.println("*****************************************");
		System.out.println();
		System.out.println("Please Enter your Choice > ");
		int choice = sc.nextInt();				
		switch(choice){
			case 1:addProductItems();
			adlin.selectOption();
									
			break;
			case 2: UserServices.viewItems();
				bg.CalculateBill();
				adlin.selectOption();
				
				
				break;
			case 3:Admin.displayEndUserAmount();
			adlin.selectOption();
			
				break;
			case 4:admin.checkQuantity();
			adlin.selectOption();
				break;
			case 5:checkRegisteredUser();
			adlin.selectOption();
			break;
			case 6 : admin.userHistory();
			break;
			case 7 : Test_Main.main(null);
			default :System.out.println("Please enter correct Option....");
				
		}
	}
	
	
	
	public int adminLogIn() throws IncorrectUsernameOrPassword {
		AdminLogIn adlin = new AdminLogIn();
		Connection con = null;
		PreparedStatement pst = null;
		int UserId = 0;
		try {
			con=DBUtil.getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Admin LogIn    >> ");
			System.out.println("Enter Username  -");
			String username = sc.next();
			System.out.println("Enter Password   -");
			String password = sc.next();
			String query = "Select *from Admin_Login where Username=? AND A_password=?";
			pst = con.prepareStatement(query);
			AdminOperation ao = new AdminOperation(username, password);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				UserId = rs.getInt(1);
				boolean login = true;
				System.out.println("LogIn Successfull...");
				System.out.println();
				adlin.selectOption();
				
		}else {
			throw new IncorrectUsernameOrPassword
			("Please enter correct Username and Password and try again");
		}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return UserId;
	}
	
	public static void addProductItems() {
		Connection con=null;
		PreparedStatement pst = null;
		 try {
			 Scanner sc = new Scanner(System.in);
			 System.out.println("Enter Product List ");
			 System.out.println();
			 System.out.println("Enter Product Name >> ");
			 String name = sc.next();
			 System.out.println("Enter Product Description >>");
			 String desc = sc.next();
			 System.out.println("Enter Product Price >>");
			 int price = sc.nextInt();
			 System.out.println("Enter Product Quantity >>");
			 int quantity =sc.nextInt();
			 con=DBUtil.getConnection();
			 String query="Insert into Product_list(prod_name, prod_Description, prod_Price, prod_Quantity) value(?,?,?,? )";
			 pst=con.prepareStatement(query);
			 pst.setString(1, name);
			 pst.setString(2, desc);
			 pst.setInt(3, price);
			 pst.setInt(4, quantity);
			 int i=pst.executeUpdate();
			 System.out.println(i+ " Product added successfully ");	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	public static void checkRegisteredUser() {
			Connection con = null;
			PreparedStatement pst = null;
			try {
				con = DBUtil.getConnection();
				String query = "select * from registereduser";
				pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				System.out.println("The registered user are>>");
				System.out.println();
				while (rs.next()) {
					System.out.println("*****************************************");
					System.out.print("User_Id     :" + rs.getInt(1));
					System.out.println("\t");
					System.out.print("First_Name  :" + rs.getString(2));
					System.out.println("\t");
					System.out.print("Last_Name   :" + rs.getString(3));
					System.out.println("\t");
					System.out.print("Username    :" + rs.getString(4));
					System.out.println("\t");
					System.out.print("City        :" + rs.getString(6));
					System.out.println();
					System.out.println("*****************************************");
					System.out.println();
				}
				System.out.println("Please LogIn again for next Operation.....");
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					pst.close();
					con.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
	}
	
}
		
		
		