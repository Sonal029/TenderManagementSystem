package Tender.UI;

import java.sql.SQLException;
import java.util.Scanner;
import Tender.DAO.VendorDAO;
import Tender.DAO.VendorDAOImpl;
import Tender.DTO.vendor;
import Tender.DTO.vendorImpl;

public class VendorUI 
{
	public static void displayMenuOfVendor(Scanner sc)
	{
		
		System.out.println("Vendor actions:");
        System.out.println("1. View all current tenders");
        System.out.println("2. Place a bid against a tender");
        System.out.println("3. View the status of a bid");
        System.out.println("4. View bid history");
        System.out.println("5. Exit");
        int vendorAction = sc.nextInt();

        if (vendorAction == 1) {
            // View all current tenders
//           viewAllTenders();
        } 
        else if (vendorAction == 2) {
            // Place a bid against a tender
//            placeBid();
        } 
        else if (vendorAction == 3) {
            // View the status of a bid
//           viewBidStatus();
        } 
        else if (vendorAction == 4) {
            // View bid history
//            viewBidHistory();
        }
        else if (vendorAction == 5) {
            // Exit
           System.out.println("Thanks for using our services");
        } 
        else {
            System.out.println("Invalid action. Please try again.");
        }
    }

	public static void vendorRegistration(Scanner sc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		String id = sc.next();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
	    vendor v = new vendorImpl(id,name,username,password);
	     
	    VendorDAO vdao= new VendorDAOImpl();
	    vdao.vendorRegistration(v);
	    System.out.println("Vendor registered sucessfully");
		
	    vendorAuthentication(sc);
	    
	}

	public static void vendorAuthentication(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Username and password");
		String user = sc.next();
		String pass = sc.next();
		
		VendorDAO vdao =  new VendorDAOImpl();
		boolean ans = vdao.vendorAuthentication(user, pass);
		
		if(ans)
		{
			displayMenuOfVendor(sc);
		}
		else
		{
			System.out.println("Incorrect credentials");
		}
	}
	
		
}

