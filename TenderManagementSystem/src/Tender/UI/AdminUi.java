package Tender.UI;

import java.util.Scanner;

public class AdminUi {

	public static void displayMenuOfAdmin(Scanner sc) 
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
//             viewAllVendors();
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
	}
