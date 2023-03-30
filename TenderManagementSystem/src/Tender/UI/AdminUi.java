package Tender.UI;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import Tender.DAO.AdminDAO;
import Tender.DAO.AdminDAOImpl;
import Tender.DAO.TenderDAO;
import Tender.DAO.TenderDAOImpl;
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
//             viewAllBids();
         } else if (adminAction == 5) {
             // Assign tender to a vendor
//            assignTender();
         } else if (adminAction == 6) {
//             Logout
//             logout();
         } 
         else if (adminAction == 0) {
        	 System.out.println("Thanks for using our service");
         } 
		 
         else {
             System.out.println("Invalid action. Please try again.");
         }
     }


	private static void viewAllTenders() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		AdminDAO adao = new AdminDAOImpl();
		List<tendor> v = adao.viewAllTendors();
		
		Consumer<tendor> con = ten -> System.out.println("Tendor Id " + ten.getTendor_id() + " Description " + ten.getTendor_desc() 
		+ " Budget " + ten.getTendor_budget() + " Status " + ten.getStatus());
		
		v.forEach(con);
		
		displayMenuOfAdmin(sc);
		
	}


	private static void createNewTender(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Enter tendor_id");
		String id = sc.next();
		System.out.println("Enter Description");
		String tendor_desc = sc.nextLine();
		System.out.println("Enter tendorbudget");
		int tendor_budget = sc.nextInt();
		System.out.println("Enter password");
		String status = sc.next();
		
	    tendor v = new tendorImpl(id,tendor_desc,tendor_budget,status);
	     
	    TenderDAO vdao= new TenderDAOImpl();
	    vdao.createNewTender(v);
	    
	    displayMenuOfAdmin(sc);
	}


	private static void viewAllVendors() throws NoRecordFoundException, SomethingWentWrongException  {
		// TODO Auto-generated method stub
		
		AdminDAO adao = new AdminDAOImpl();
		try {
			List<vendor> v = adao.getAllVendors();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		
		displayMenuOfAdmin(sc);
	}
	
	
	}
