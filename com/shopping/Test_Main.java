package com.shopping;
import java.util.Scanner;
public class Test_Main {
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		AdminLogIn ad = new AdminLogIn();
		System.out.println("------------------------------------------");
		System.out.println("\t   By Group-H ");
		System.out.println("------------------------------------------");
		System.out.println();
		System.out.println("*****************************************");
		System.out.println("\t WEL-COME TO E-STORE");
		System.out.println("*****************************************");
		System.out.println("\t1. LogIn as User");
		System.out.println("\t2. LogIn as Admin");
		System.out.println("\t3. Used as Guest");
		System.out.println("\t4. Exit");
		System.out.println("*****************************************");
		System.out.println();
		

		System.out.println("Please Enter your choice >");
		int choice = sc.nextInt();
		switch (choice) {
		case 1	: UserServices.getUserOpertion();
				  break;
		case 2	: try {
				ad.adminLogIn();
			} catch (IncorrectUsernameOrPassword e) {
				e.printStackTrace();
			}
					break;
		case 3	: UserServices.viewItems();
				  Test_Main.main(null);
				  break;
		case 4	: System.out.println("\tThank You ");
		      	  System.out.println("   *** Visit Again ***");
		      	  ;
		      	  break;
		default : System.out.println("Please Enter correct option and try again.....");
				  Test_Main.main(null);
		}
		
	}
}
