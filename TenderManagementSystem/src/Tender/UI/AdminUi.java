package Tender.UI;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;



import Tender.DAO.AdminDAO;
import Tender.DAO.AdminDAOImpl;
import Tender.DTO.vendor;
import Tender.Exception.SomethingWentWrongException;

public class AdminUi {

	public static void displayMenuOfAdmin(Scanner sc) throws SomethingWentWrongException 
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
//             createNewTender();
         } else if (adminAction == 3) {
             // View all tenders
//             viewAllTenders();
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

	private static void viewAllVendors() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		AdminDAO adao = new AdminDAOImpl();
		List<vendor> v = adao.getAllVendors();
		
		Consumer<vendor> con = ven -> System.out.println("Vendor Id " + ven.getId() + " Name " + ven.getName() 
		+ " username " + ven.getUsername() + " password " + ven.getPassword());
		v.forEach(con);
	}
	}
