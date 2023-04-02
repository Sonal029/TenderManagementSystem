package Tender.DAO;

import java.util.List;

import Tender.DTO.Bid;
import Tender.DTO.tendor;
import Tender.DTO.vendor;
import Tender.Exception.SomethingWentWrongException;

public interface VendorDAO 
{
   public void vendorRegistration(vendor v); 
   
   public boolean vendorAuthentication(String user , String pass);

   public List<tendor> viewAllCurrentTenders() throws SomethingWentWrongException;
   
   public void placeBid(Bid b);

   public void viewBidHistory(String vendor_id) throws SomethingWentWrongException;

   public void viewBidStatus(String vendor_id, String tendor_id) throws SomethingWentWrongException;

   public void search(String tendor_id) throws SomethingWentWrongException;

}
