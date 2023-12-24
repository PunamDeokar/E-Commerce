package com.shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class Test_Main {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		UserServices us = new UserServices();
		AdminLogIn ad = new AdminLogIn();
		
		System.out.println("*****************************************");
		System.out.println("\t WEL-COME TO E-STORE");
		System.out.println("*****************************************");

		System.out.println("\t1. LogIn as User");
		System.out.println("\t2. LogIn as Admin");
		System.out.println("\t3. Used as Guest");
		System.out.println("\t4. Exit");
		System.out.println("*****************************************");
		System.out.println();
		System.out.println("Please Inter your choice >");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: us.getUserOpertion();
			break;
		case 2: try {
				ad.adminLogIn();
			} catch (IncorrectUsernameOrPassword e) {
				e.printStackTrace();
			}
				break;
		case 3:
			break;
		case 4:System.out.println("\tThank You ");
		      System.out.println("   *** Visit Again ***");
		}
		
	}
}
