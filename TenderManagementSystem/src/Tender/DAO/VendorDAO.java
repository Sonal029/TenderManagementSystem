package Tender.DAO;

import java.util.List;

import Tender.DTO.Bid;
import Tender.DTO.Tendor;
import Tender.DTO.Vendor;
import Tender.Exception.NoRecordFoundException;
import Tender.Exception.SomethingWentWrongException;

public interface VendorDAO 
{
   public void vendorRegistration(Vendor v); 
   
   public boolean vendorAuthentication(String user , String pass);

   public List<Tendor> viewAllCurrentTenders() throws SomethingWentWrongException;
   
   public void placeBid(Bid b);

   public void viewBidHistory(String vendor_id) throws SomethingWentWrongException;

   public void viewBidStatus(String vendor_id, String tendor_id) throws SomethingWentWrongException;

   public void search(String tendor_id) throws SomethingWentWrongException;

   public void vendorUpdate(Vendor v) throws SomethingWentWrongException, NoRecordFoundException;

}
