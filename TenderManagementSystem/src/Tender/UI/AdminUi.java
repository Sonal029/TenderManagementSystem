package Tender.UI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Tender.DAO.AdminDAO;
import Tender.DAO.AdminDAOImpl;
import Tender.DAO.TenderDAO;
import Tender.DAO.TenderDAOImpl;
import Tender.DTO.Bid;
import Tender.DTO.Tendor;
import Tender.DTO.TendorImpl;
import Tender.DTO.Vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public class AdminUi {

	static Scanner sc = new Scanner(System.in);
	public static void displayMenuOfAdmin(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException, SQLException 
	{
		System.out.println("1. View all the vendors.");
		System.out.println("2. Create new tenders.");
		System.out.println("3. View All the Tenders.");
		System.out.println("4. View All the Bids of a tender.");
		System.out.println("5. Assign tender to a vendor.");
		
		System.out.println("6. Logout");
		System.out.println("0. Exit");
		
		int adminAction =sc.nextInt();
		 if (adminAction == 1) {
             // View all vendors
             viewAllVendors();
         } else if (adminAction == 2) {
             // Create new tender
             createNewTender(sc);
         } else if (adminAction == 3) {
             // View all tenders
             viewAllTenders();
         } else if (adminAction == 4) {
             // View all bids of a tender
               viewAllBids();
         } else if (adminAction == 5) {
             // Assign tender to a vendor
            assignTender();
         } else if (adminAction == 6) {
//             Logout
              logout();
         } 
         else if (adminAction == 0) {
        	 System.out.println("Thanks for using our service");
         } 
		 
         else {
             System.out.println("Invalid action. Please try again.");
             System.out.println();
    		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
    		 System.out.println();   
    		 displayMenuOfAdmin(sc);
         }
     }


	private static void assignTender() throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter tender id for which the bid is to be assigned");
		String tendor_id = sc.next();
		AdminDAO adao = new AdminDAOImpl();
		try
		{
		    adao.assignTender(tendor_id);
		}
		catch (SomethingWentWrongException e) 
		{
			
			System.out.println(e.getMessage());
		}
		System.out.println();
		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		 System.out.println();   
		 displayMenuOfAdmin(sc);
		
	}


	private static void logout() throws ClassNotFoundException, SomethingWentWrongException, NoRecordFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Thank you Admin");
		
		System.out.println();
		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		 System.out.println(); 
		UIMain.menu(sc);
	}


	public static void viewAllBids() throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter tender id to view its bid");
		String tenderId= sc.next();
		AdminDAO adao = new AdminDAOImpl();
		try
		{
			List<Bid> b = adao.viewBids(tenderId);
		}
		catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		System.out.println();
		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		 System.out.println();  
		 displayMenuOfAdmin(sc);
		
	}


	private static void viewAllTenders() throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		AdminDAO adao = new AdminDAOImpl();
		try
		{
			List<Tendor> t = adao.viewAllTendors();
		
		}
		catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		System.out.println();
		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		 System.out.println();
		    displayMenuOfAdmin(sc);
		
		
	}


	public static void createNewTender(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Enter tendor_id");
		String id = sc.next();
		sc.nextLine();
		System.out.println("Enter Description");
		String tendor_desc = sc.nextLine();

		System.out.println("Enter tendorbudget in crores");
		int tendor_budget = sc.nextInt();
		
		System.out.println("Enter date of issuing the tender");
		LocalDate tender_date = LocalDate.parse(sc.next());
		System.out.println("Enter status");
		String status = sc.next();
		
	    Tendor t = new TendorImpl(id,tendor_desc,tendor_budget,tender_date,status);
	     
	    TenderDAO tdao= new TenderDAOImpl();
	    tdao.createNewTender(t);
	    System.out.println();
	    System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
	    System.out.println();
	    displayMenuOfAdmin(sc);
	}


	public static void viewAllVendors() throws NoRecordFoundException, SomethingWentWrongException, ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		
		AdminDAO adao = new AdminDAOImpl();
		try {
			List<Vendor> v = adao.getAllVendors();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		 System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		 System.out.println();
		displayMenuOfAdmin(sc);
	}
	
	
	}
