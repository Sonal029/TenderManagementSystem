package Tender.UI;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import Tender.DAO.AdminDAO;
import Tender.DAO.AdminDAOImpl;
import Tender.DAO.VendorDAO;
import Tender.DAO.VendorDAOImpl;
import Tender.DTO.tendor;
import Tender.DTO.vendor;
import Tender.DTO.vendorImpl;
import Tender.Exception.SomethingWentWrongException;

public class VendorUI 
{
	public static void displayMenuOfVendor(Scanner sc) throws SomethingWentWrongException
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
           viewAllCurrentTenders();
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

	private static void viewAllCurrentTenders() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		VendorDAO adao = new VendorDAOImpl();
		List<tendor> v = adao.viewAllCurrentTenders();
		
		Consumer<tendor> con = ten -> System.out.println("Tendor Id " + ten.getTendor_id() + " Description " + ten.getTendor_desc() 
		+ " Budget " + ten.getTendor_budget() + " Status " + ten.getStatus());
		
		v.forEach(con);
	}

	public static void vendorRegistration(Scanner sc) throws SQLException, ClassNotFoundException, SomethingWentWrongException {
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
	    System.out.println("1.login");
	    System.out.println("2. exit");
        Scanner scanner = new Scanner(System.in);
        int ch= scanner.nextInt();
        if(ch==1)
        {
           vendorAuthentication(scanner);
        }
        else
        {
        	System.out.println("Thanks for registering");
        }
	    
	}

	public static void vendorAuthentication(Scanner sc) throws SomethingWentWrongException {
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

