package Tender.UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Tender.DAO.AdminDAO;
import Tender.DAO.AdminDAOImpl;
import Tender.DAO.TenderDAO;
import Tender.DAO.TenderDAOImpl;
import Tender.DTO.Bid;
import Tender.DTO.tendor;
import Tender.DTO.tendorImpl;
import Tender.DTO.vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public class AdminUi {

	static Scanner sc = new Scanner(System.in);
	public static void displayMenuOfAdmin(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException 
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
             AdminUi.createNewTender(sc);
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
         }
     }


	private static void assignTender() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enetr tender id for which the bid is to be assigned");
		String tendor_id = sc.next();
		AdminDAO adao = new AdminDAOImpl();
		try
		{
		    adao.assignTender(tendor_id);
//		    System.out.println("the query has been assigned for tender id : "+tendor_id);
		}
		catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		    displayMenuOfAdmin(sc);
		
	}


	private static void logout() {
		// TODO Auto-generated method stub
		System.out.println("Thank you Admin");
	}


	public static void viewAllBids() throws SomethingWentWrongException, NoRecordFoundException {
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
		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		    displayMenuOfAdmin(sc);
		
	}


	private static void viewAllTenders() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		AdminDAO adao = new AdminDAOImpl();
		try
		{
			List<tendor> t = adao.viewAllTendors();
		
		}
		catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		 System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		    displayMenuOfAdmin(sc);
		
		
	}


	public static void createNewTender(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
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
		
	    tendor t = new tendorImpl(id,tendor_desc,tendor_budget,tender_date,status);
	     
	    TenderDAO tdao= new TenderDAOImpl();
	    tdao.createNewTender(t);
	    System.out.println("Tender created sucessfully");
	    System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
	    displayMenuOfAdmin(sc);
	}


	public static void viewAllVendors() throws NoRecordFoundException, SomethingWentWrongException  {
		// TODO Auto-generated method stub
		
		AdminDAO adao = new AdminDAOImpl();
		try {
			List<vendor> v = adao.getAllVendors();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-");
		displayMenuOfAdmin(sc);
	}
	
	
	}
