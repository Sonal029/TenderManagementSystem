package Tender.DAO;

import java.util.List;
import java.util.Scanner;

import Tender.DTO.tendor;
import Tender.DTO.vendor;
import Tender.DTO.vendorImpl;
import Tender.Exception.SomethingWentWrongException;

public interface VendorDAO 
{
   public void vendorRegistration(vendor v); 
   
   public boolean vendorAuthentication(String user , String pass);

public List<tendor> viewAllCurrentTenders() throws SomethingWentWrongException;

}
