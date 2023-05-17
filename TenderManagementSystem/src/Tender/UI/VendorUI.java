package Tender.UI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Tender.DAO.VendorDAO;
import Tender.DAO.VendorDAOImpl;
import Tender.DTO.Bid;
import Tender.DTO.Tendor;
import Tender.DTO.Vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public class VendorUI 
{
	static Scanner sc = new Scanner(System.in);
	public static void displayMenuOfVendor(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException
	{
		
		System.out.println("Vendor actions:");
        System.out.println("1. View all current tenders");
        System.out.println("2. Place a bid against a tender");
        System.out.println("3. View the status of a bid");
        System.out.println("4. View bid history");
        System.out.println("5. Search for tender on the basis of Tender id");
        System.out.println("6. Update vendor's details.");
        System.out.println("7. Exit");
        int vendorAction = sc.nextInt();

        if (vendorAction == 1) {
            // View all current tenders
           viewAllCurrentTenders();
        } 
        else if (vendorAction == 2) {
            // Place a bid against a tender
            placeBid();
        } 
        else if (vendorAction == 3) {
            // View the status of a bid
           viewBidStatus();
        } 
        else if (vendorAction == 4) {
            // View bid history
             viewBidHistory(sc);
        }
        else if(vendorAction == 5)
        {
//        Search for tender on the basis of Tender id
        	searchTender(sc);
        }
        else if(vendorAction == 6)
        {
        	update(sc);
        }
        else if (vendorAction == 7) {
            // Exit
           System.out.println("Thanks for using our services");
        } 
        else {
            System.out.println("Invalid action. Please try again.");
            System.out.println();
    		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
    	    System.out.println();
    		displayMenuOfVendor(sc);
        }
    }

	private static void update(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		String id = sc.next();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
	    Vendor v = new Vendor(id,name,username,password);
	     
	    VendorDAO vdao= new VendorDAOImpl();
	    vdao.vendorUpdate(v);
	    System.out.println("Your Data is updated sucessfully");
	    
	}

	private static void searchTender(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter your tendor id to check your history");
		String tendor_id=sc.next();
		VendorDAO vdao= new VendorDAOImpl();
		vdao.search(tendor_id);
		
		System.out.println();
 		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
 	    System.out.println();
 		displayMenuOfVendor(sc);
	}

	private static void viewBidStatus() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter your vendor id to check your history");
		String vendor_id=sc.next();
		System.out.println("Enter your tendor id to check your history");
		String tendor_id=sc.next();
		VendorDAO vdao= new VendorDAOImpl();
		vdao.viewBidStatus(vendor_id,tendor_id);
		
		 System.out.println();
 		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
 	    System.out.println();
 		displayMenuOfVendor(sc);
	}

	public static void viewBidHistory(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter your vendor id to check your history");
		String vendor_id=sc.next();
		
		VendorDAO vdao= new VendorDAOImpl();
		vdao.viewBidHistory(vendor_id);
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
	    System.out.println();
		displayMenuOfVendor(sc);
	}

	public static void placeBid() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter tendor id");
		String t_id = sc.next();
		System.out.println("Enter vendor id");
		String v_id = sc.next();
		System.out.println("Enter bidding amount");
		int amt = sc.nextInt();
		System.out.println("Enter Bidding date");
		LocalDate bidDate = LocalDate.parse(sc.next());
		
		Bid b = new Bid(t_id,v_id,amt,bidDate);
		VendorDAO vdao= new VendorDAOImpl();
	    vdao.placeBid(b);
	    System.out.println("Bid placed sucessfully");
	    System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
	    System.out.println();
	    displayMenuOfVendor(sc);
	}

	public static void viewAllCurrentTenders() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		VendorDAO adao = new VendorDAOImpl();
		try
		{
		  List<Tendor> t = adao.viewAllCurrentTenders();
		}
		catch(SomethingWentWrongException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
	    System.out.println();
	    displayMenuOfVendor(sc);
	}

	public static void vendorRegistration(Scanner sc) throws SQLException, ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		String id = sc.next();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		
	    Vendor v = new Vendor(id,name,username,password);
	     
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

	public static void vendorAuthentication(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
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
			System.out.println("Incorrect credentials please try again");
			vendorAuthentication(sc);
		}
	}
	
		
}

