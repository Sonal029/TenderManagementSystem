package Tender.UI;

import java.util.Scanner;

public class UIMain 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.println("Welcome to the Tender Management System!");
         System.out.println("Please select your user type:");
		System.out.println("1. Admin");
		System.out.println("2. Vendor");
		
		int choice =sc.nextInt();
		if(choice==1)
		{
			System.out.println("Enter Username and password");
			String user = sc.next();
			String pass = sc.next();
			if(user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin"))
			{
				AdminUi.displayMenuOfAdmin(sc);
			}
		}
		else if(choice==2)
		{
			System.out.println("Enter your choice");
			System.out.println("1. Register yourself");
			System.out.println("2. Login");
			
			int vendorChoice = sc.nextInt();
			
			if(vendorChoice==1)
			{
				
				VendorUI.vendorRegistration(sc);
				
			}
			
			else
			{
				VendorUI.vendorAuthentication(sc);
			}
		}
		
		
		
	}

	

}
